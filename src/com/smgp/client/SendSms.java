package com.smgp.client;

import java.io.IOException;

import org.apache.log4j.Logger;
 
 

import com.smgp.Client;
import com.smgp.bean.Result;
import com.smgp.bean.Submit;
 
public class SendSms {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//读取配置文件对象
		Config config = new Config();
		
		//获取配置参数
		String host = config.get("smgwip");
		String account = config.get("smgwaccount");
		String passwd = config.get("smgwpasswd");
		String spid = config.get("smgwspid");
		String spnum = config.get("smgpspnum");
		int port = Integer.parseInt(config.get("smgwport"));
		System.out.println("spnum"+spnum);
		//目标号码：18918911891
		String destnum ="18943675558";
		String content ="content";
		String productid="11111111";
		
		//初始化client
		Client client = new Client(host, port, 2,account, passwd,spid, 0);
		
		//设置submit
		Submit submit =new Submit();
		submit.setSrcTermid(spnum);
		submit.setDestTermid(destnum);
		submit.setMsgContent(content.getBytes("iso-10646-ucs-2"));
		submit.setMsgFormat(8);
		if (productid!=null) submit.setProductID(productid);
		
		//发送短信
		Result  result =client.Send(submit);
		System.out.println("Status:"+result.ErrorCode);
		System.out.println("MsgID:"+result.ErrorDescription);
		
		//退出
		client.Close();

	}
	
	 
    public static boolean  SmgpSending(String destnum,String content) throws IOException{
    	Logger logger = Logger.getLogger("MPLogger");
   	 boolean flag=false;
   	//读取配置文件对象
		Config config = new Config();
		
		//获取配置参数
		String host = config.get("smgwip");
		String account = config.get("smgwaccount");
		String passwd = config.get("smgwpasswd");
		String spid = config.get("smgwspid");
		String spnum = config.get("smgpspnum");
	 
		int port = Integer.parseInt(config.get("smgwport"));
 
		//System.out.println("Client:"+host+","+port+","+2+","+account+","+passwd+","+spid+","+ 0);
		//初始化client
		Client client = new Client(host, port, 2,account, passwd,spid, 0);
		
		//设置submit
		Submit submit =new Submit();
		submit.setSrcTermid(spnum);
		submit.setDestTermid(destnum);
		//---------貌似这一段代码不填写会提示Stutus:43的错误
		submit.setMsgType(0);
		submit.setNeedReport(0);
		submit.setPriority(0);
		submit.setServiceID(spid);
		//_______貌似这一段代码不填写会提示Stutus:43的错误
		 
		if(content != null){
			submit.setMsgContent(content.getBytes("iso-10646-ucs-2"));
		}
		else{
			submit.setMsgContent(" ".getBytes("iso-10646-ucs-2"));
		}
		submit.setMsgFormat(8);
		//submit.setProductID(config.get("productid"));
		 
		if(content != null){
	 		if(content.length()<70){
	 			//发送短信
	 			Result  result =client.Send(submit);
	 			logger.info("Status:"+result.ErrorCode);
	 			logger.info("MsgID:"+result.ErrorDescription);
	 			if(result.ErrorCode==0){
	 				flag=true;
	 			}
	 		}
	 		else{
	 			// 发送长短信
	 			Result[] results = client.SendLong(submit);
	 			for (int i = 0; i < results.length; i++) {
	 				System.out.println("--------------------------------");
	 				logger.info("Message "+i+"");
	 				logger.info("Status:" + results[i].ErrorCode);
	 				logger.info("MsgID:" + results[i].ErrorDescription);
	 				System.out.println("--------------------------------");
	 				if(results[i].ErrorCode==0){
	 	 				flag=true;
	 	 			}
	 			}
	 		}
		}
		else {
			//发送短信
			Result  result =client.Send(submit);
			logger.info("Status:"+result.ErrorCode);
			logger.info("MsgID:"+result.ErrorDescription);
			if(result.ErrorCode==0){
				flag=true;
			}
		}
		//退出
		client.Close();
		return  flag;
     
		 
    }

}
