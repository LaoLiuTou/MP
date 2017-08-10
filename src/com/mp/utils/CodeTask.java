package com.mp.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import javax.servlet.ServletContext;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
  
import com.mp.model.kung_note_code.Kung_note_code;
import com.mp.service.kung_note_code.IKung_note_codeService;
import com.sgip.client.SGIPClient;
import com.smgp.client.SendSms;
import com.utils.HttpServletUtil;
import com.utils.PhoneNumber; 
 



public class CodeTask extends TimerTask { 
	private static boolean isRunning = false;  
    private ServletContext context = null;  
    private String retry;//发送失败重试次数
    private Map<String,String> retryMap;
     
    //towired
	 //private IKung_messageService iKung_messageService;
    
    public CodeTask(ServletContext servletContext,String retry) { 
        this.context = servletContext; 
        this.retry = retry; 
        this.retryMap = new HashMap<String,String>();
    } 
     
     
       @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override 
     public void run() { 
       if(!isRunning) 
       { 
    	 Logger logger = Logger.getLogger("MPLogger");
         isRunning = true; 
        
         Date d=new Date(); 
         
         try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
			 "applicationContext.xml"); 
			IKung_note_codeService iKung_note_codeService = (IKung_note_codeService) context.getBean("iKung_note_codeService");
        	 Map  paramMap = new HashMap ();
     		 paramMap.put("fromPage",0);
     		 paramMap.put("toPage",20); 
     		 paramMap.put("st_lv", 0);
			 List<Kung_note_code> list=iKung_note_codeService.selectkung_note_codeByParam(paramMap);
			 if(list.size()>0){
				 System.out.println("开始执行任务");
				 logger.info("更新条数："+list.size());
			 }
			 
			 
			 for(int index=0;index<list.size();index++){
				 String phoneNumber=list.get(index).getJs_t();
				 String content = list.get(index).getCm_tx();
				 logger.info("------信息下发--------接收号码："+phoneNumber);
				 
				 try {
					  
					boolean submitResult=false;
					 
					
					///////////////重试次数
					if(retryMap.containsKey(phoneNumber)){
						 String currentRetry= retryMap.get(phoneNumber);
						 if(currentRetry.equals(retry)){
							 Long id=list.get(index).getId(); 
								Kung_note_code kung_note_code = new Kung_note_code();
								kung_note_code.setId(id);
								kung_note_code.setSt_lv("33");
								kung_note_code.setFs_dt(new Date());
								iKung_note_codeService.updatekung_note_code(kung_note_code);
							//
							retryMap.remove(phoneNumber);
						 }
						 else{
							 
							 retryMap.put(phoneNumber, (Integer.parseInt(currentRetry)+1)+"");
						 }
					 }
					else{
						 retryMap.put(phoneNumber, 1+"");
					}
					
					
					switch (PhoneNumber.matchesPhoneNumber(phoneNumber)) {
					case 1://移动
						//submitResult=MsgContainer.sendMsg(content,phoneNumber);
						String url="http://211.149.155.80:8888/sms.aspx?action=send";
						List<NameValuePair> params= new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("userid", "552"));    
						params.add(new BasicNameValuePair("account", "jiubaisoft"));    
						params.add(new BasicNameValuePair("password", "JiubaiSoft123"));    
						params.add(new BasicNameValuePair("mobile", phoneNumber));    
						params.add(new BasicNameValuePair("content", content+"【长春农业信息中心】"));    
						params.add(new BasicNameValuePair("sendTime", ""));    
						params.add(new BasicNameValuePair("extno", ""));    
						String sendResult = HttpServletUtil.doPost(params, url);
						String[] results = sendResult.split("<returnstatus>");
						if(results.length>1){
							if(results[1].split("</returnstatus>")[0].equals("Success")){
								submitResult=true;
							}
							else{
								submitResult=false;
							}
							
						}
						else{
							submitResult=false;
						}
						
						break;
					case 2://联通
						String tempContent="【长春农业信息中心】"+content;
						submitResult=SGIPClient.sendMsg(phoneNumber, tempContent);
						 
						break;
					case 3://电信
						submitResult=SendSms.SmgpSending(phoneNumber,content);
						//submitResult=true;
						break;
					case 4://非法号码
						logger.info("非法手机号码："+phoneNumber);
						Long id=list.get(index).getId(); 
						Kung_note_code kung_note_code = new Kung_note_code();
						kung_note_code.setId(id);
						kung_note_code.setSt_lv("9");
						kung_note_code.setFs_dt(new Date());
						iKung_note_codeService.updatekung_note_code(kung_note_code);
						//
						retryMap.remove(phoneNumber);
						break;

					default:
						break;
					}
					 
					 
					 //发送成功
					if(submitResult){
						Long id=list.get(index).getId(); 
						Kung_note_code kung_note_code = new Kung_note_code();
						kung_note_code.setId(id);
						kung_note_code.setSt_lv("1");
						kung_note_code.setFs_dt(new Date());
						iKung_note_codeService.updatekung_note_code(kung_note_code);
				 
						retryMap.remove(phoneNumber);
					} 
				} catch (Exception e) {
					logger.error(e);
					e.printStackTrace();
				}
			 }		 
				
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
 		
         
         isRunning = false; 
       } 
       else 
       { 
           context.log("上次的任务还未执行完成"); 
       } 
     } 
      
}
