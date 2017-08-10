import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.cmpp.util.MsgContainer;
import com.sgip.client.SGIPClient;
import com.smgp.client.SendSms;
import com.utils.HttpServletUtil;
import com.utils.PhoneNumber;


public class LT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*String content="尊敬的用户您好，长春农信通本着“解农民所惑，答农民所疑，送农民所需”的服务宗旨，根据用户不同需求，提供价格行情、农业科技、农事指导、惠农政策、农业气象预报等短信息服务。服务范围覆盖全市及各县（市）区，用户登录长春农业信息网可免费申请订阅相关服务。测试测试测试测试";
		System.out.println(content.length());

		// TODO Auto-generated method stub
		String phoneNumber="13504466770";
		//String phoneNumber="13321419193";
		//String content="Test content!";
		boolean submitResult=false;
		Logger logger = Logger.getLogger("MPLogger");
		try {
			switch (PhoneNumber.matchesPhoneNumber(phoneNumber)) {
			case 1://移动
				logger.info("移动:");
				submitResult=MsgContainer.sendMsg(content,phoneNumber);
				break;
			case 2://联通
				logger.info("联通:");
				submitResult=SGIPClient.sendMsg(phoneNumber, content);
				break;
			case 3://电信
				logger.info("电信:");
				submitResult=SendSms.SmgpSending(phoneNumber,content);
				break;
			case 4://非法号码
				 
				logger.info("非法手机号码："+phoneNumber);
				break;

			default:
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("result："+submitResult);*/
		
		/*String url="http://211.149.155.80:8888/sms.aspx?action=send";
		List<NameValuePair> params= new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("userid", "552"));    
		params.add(new BasicNameValuePair("account", "jiubaisoft"));    
		params.add(new BasicNameValuePair("password", "JiubaiSoft123"));    
		params.add(new BasicNameValuePair("mobile", "13321419193"));    
		params.add(new BasicNameValuePair("content", "中文测试【长春农业信息中心】"));    
		params.add(new BasicNameValuePair("sendTime", ""));    
		params.add(new BasicNameValuePair("extno", ""));    
		try {
			String sendResult = HttpServletUtil.doPost(params, url);
			System.out.println(sendResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
 		String json="{\"deviceId\": \"f7146743-3f63-4a3a-b83f-9cfc86eccc44\",\"period\": {\"from\":\"2017-08-08 00:00:00\",\"to\":\"2017-08-08 21:59:00\"}}";
		
		JSONObject jo= JSONObject.fromObject(json);
		JSONArray ja = jo.getJSONArray("recordset");
		JSONObject jo1= (JSONObject) ja.get(0);
		JSONObject jo2= jo1.getJSONObject("record"); 
		System.out.println(jo2.getString("time")); 
		
		/*String loginUrl="http://116.66.187.121:8740/iocm/app/sec/v1.1.0/login";
		List<NameValuePair> params= new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("appId", "AWBfeuRGLK9WQfyx47bb6Q612A0a"));    
		params.add(new BasicNameValuePair("secret", "GZkGXZsfvbfRS0qeRPCynDm54kAa"));    
		try {
			String sendResult = HttpServletUtil.doPost(params, loginUrl);
			System.out.println(sendResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//{"accessToken":"cdbb3c1f417956adf42c914776c3a","tokenType":"bearer","refreshToken":"cbf22e332e55f7447d3bee84176e5f","expiresIn":3600,"scope":"default"}
		String param="{\"deviceId\": \"f7146743-3f63-4a3a-b83f-9cfc86eccc44\",\"period\": {\"from\":\"2017-08-08 00:00:00\",\"to\":\"2017-08-08 21:59:00\"}}";
		String url="http://116.66.187.121:8740/daas/odbdss/v1.1.0/devices/getDeviceTracks";
		 
		try {
			
			httpPost.setHeader("Connection", "keep-alive");
 	        httpPost.setHeader("Authorization", "cdbb3c1f417956adf42c914776c3a");
 	        httpPost.setHeader("app_key", "AWBfeuRGLK9WQfyx47bb6Q612A0a");
 	        httpPost.setHeader("Content-Type", "application/json");
 	        
			Header[] headers = new Header[4];
			headers[0] = new BasicHeader("Connection", "keep-alive");
			headers[1] = new BasicHeader("Authorization", "cdbb3c1f417956adf42c914776c3a");
			headers[2] = new BasicHeader("app_key", "AWBfeuRGLK9WQfyx47bb6Q612A0a");
			headers[3] = new BasicHeader("Content-Type", "application/json"); 
			
			String sendResult = HttpServletUtil.HttpPostWithJson(url, param,headers);
			System.out.println(sendResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		 
		 
	}

}
