package com.mp.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
  
import com.cmpp.util.MsgContainer;
import com.mp.model.kung_message.Kung_message;
import com.mp.service.kung_dxdy.IKung_dxdyService;
import com.mp.service.kung_message.IKung_messageService;
import com.sgip.client.SGIPClient;
import com.smgp.Client;
import com.smgp.bean.Result;
import com.smgp.bean.Submit;
import com.smgp.client.SendSms;
import com.utils.PhoneNumber; 
 



public class MyTask extends TimerTask { 
	 private static boolean isRunning = false;  
     private ServletContext context = null;  
     private String retry;//发送失败重试次数
     private Map<String,String> retryMap;
      
     //towired
 	 //private IKung_messageService iKung_messageService;
     
     public MyTask(ServletContext servletContext,String retry) { 
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
			IKung_messageService iKung_messageService = (IKung_messageService) context.getBean("iKung_messageService");
        	 Map  paramMap = new HashMap ();
     		 paramMap.put("fromPage",0);
     		 paramMap.put("toPage",20); 
     		 paramMap.put("st_lv", 0);
     		 paramMap.put("status", "1");
     		 paramMap.put("ds_dtTo", new Date());
			 List<Kung_message> list=iKung_messageService.selectkung_messageByParam(paramMap);
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
							Kung_message kung_message = new Kung_message();
							kung_message.setId(id);
							kung_message.setSt_lv("33");
							kung_message.setFs_dt(new Date());
							iKung_messageService.updatekung_message(kung_message);
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
						submitResult=MsgContainer.sendMsg(content,phoneNumber);
						
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
						Kung_message kung_message = new Kung_message();
						kung_message.setId(id);
						kung_message.setSt_lv("9");
						kung_message.setFs_dt(new Date());
						iKung_messageService.updatekung_message(kung_message);
						//
						retryMap.remove(phoneNumber);
						break;

					default:
						break;
					}
					 
					 
					 //发送成功
					if(submitResult){
						Long id=list.get(index).getId();
						Kung_message kung_message = new Kung_message();
						kung_message.setId(id);
						kung_message.setSt_lv("1");
						kung_message.setFs_dt(new Date());
						iKung_messageService.updatekung_message(kung_message);
						//
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
