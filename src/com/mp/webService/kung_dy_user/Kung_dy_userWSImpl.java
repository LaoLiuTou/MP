package com.mp.webService.kung_dy_user;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mp.service.kung_dy_user.IKung_dy_userService;
import com.mp.model.kung_dy_user.Kung_dy_user;
public class Kung_dy_userWSImpl implements IKung_dy_userWS {
 	/**
 	 * 根据ID查询
 	 * @return
 	 */
	public String getkung_dy_userById(String id) {
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dy_userService iKung_dy_userService = (IKung_dy_userService)context.getBean("iKung_dy_userService");
		Kung_dy_user kung_dy_user=new Kung_dy_user();
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			kung_dy_user=iKung_dy_userService.selectkung_dy_userById(id);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
				public Object processArrayValue(Object value, JsonConfig jsonConfig) {
					return value;  
				} 
			public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) { 
				if(value instanceof Date){ 
					return sdf.format((Date)value);
				}
				return value; 
			}
			});
			msg.append("\"success\",\"msg\":");
			msg.append(JSONObject.fromObject(kung_dy_user, jsonConfig));
		} catch (Exception e) {
			msg.append("\"failure\",\"msg\":");
			msg.append("\"查询失败.\"");
			log.info("查询失败.ID："+id+";E:"+e);
			e.printStackTrace();
		}
		msg.append("}");
		return msg.toString();
	}


		/**
		 * 根据ID删除
		 * 
		 * @return
		 */
	public String deletekung_dy_userById(String id) {
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dy_userService iKung_dy_userService = (IKung_dy_userService)context.getBean("iKung_dy_userService");
		try {
			iKung_dy_userService.deletekung_dy_user(id);
			msg.append("\"success\",\"msg\":");
			msg.append("\"删除成功.ID："+id+"\"");
		} catch (Exception e) {
			msg.append("\"failure\",\"msg\":");
			msg.append("\"删除失败.\"");
			log.info("删除失败.ID："+id+";E:"+e);
			e.printStackTrace();
		}
		msg.append("}");
		return msg.toString();
	}


		/**
		 * 根据查询条件查询
		 * @return
		 */
		@SuppressWarnings("unchecked")
	public String getkung_dy_userByParam(String id,String user_id,String dy_id,String ph_t,String dy_dtFrom,String dy_dtTo,String dy_dt,String yy_t,int page,int size){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dy_userService iKung_dy_userService = (IKung_dy_userService)context.getBean("iKung_dy_userService");
		List<Kung_dy_user> list;
		try {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			Map paramMap = new HashMap();
			paramMap.put("id", id);
			paramMap.put("user_id", user_id);
			paramMap.put("dy_id", dy_id);
			paramMap.put("ph_t", ph_t);
			if(dy_dtFrom!=null&&!dy_dtFrom.equals(""))
			paramMap.put("dy_dtFrom", sdf.parse(dy_dtFrom));
			if(dy_dtTo!=null&&!dy_dtTo.equals(""))
			paramMap.put("dy_dtTo", sdf.parse(dy_dtTo));
			paramMap.put("dy_dt", dy_dt);
			paramMap.put("yy_t", yy_t);
			paramMap.put("fromPage",(page-1)*size);
			paramMap.put("toPage",page*size);
			list=iKung_dy_userService.selectkung_dy_userByParam(paramMap);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
				public Object processArrayValue(Object value, JsonConfig jsonConfig) {
					return value;  
				} 
			public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) { 
				if(value instanceof Date){ 
					return sdf.format((Date)value);
				}
				return value; 
			}
			});
			msg.append("\"success\",\"msg\":");
			msg.append(JSONArray.fromObject(list, jsonConfig));
		} catch (Exception e) {
			msg.append("\"failure\",\"msg\":");
			msg.append("\"查询失败.\"");
			log.info("查询失败."+e);
			e.printStackTrace();
		}
		msg.append("}");
		return msg.toString();
	}
		/**
		 * 添加
		 * @return
		 * @throws ParseException
		 */
	public String addkung_dy_user(String user_id,String dy_id,String ph_t,String dy_dt,String yy_t){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dy_userService iKung_dy_userService = (IKung_dy_userService)context.getBean("iKung_dy_userService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Kung_dy_user kung_dy_user=new Kung_dy_user();
		if (user_id != null && !user_id.equals(""))
			kung_dy_user.setUser_id(Long.parseLong(user_id));
		if (dy_id != null && !dy_id.equals(""))
			kung_dy_user.setDy_id(Long.parseLong(dy_id));
		kung_dy_user.setPh_t(ph_t);
		try {
		if (dy_dt != null && !dy_dt.equals(""))
			kung_dy_user.setDy_dt(sdf.parse(dy_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		kung_dy_user.setYy_t(yy_t);
		try {
			int result = Integer.parseInt(iKung_dy_userService.addkung_dy_user(kung_dy_user).toString());
			msg.append("\"success\",\"msg\":");
			msg.append("\""+result+"\"");
		} catch (Exception e) {
			msg.append("\"failure\",\"msg\":");
			msg.append("\"添加失败.\"");
			log.info("添加失败."+e);
			e.printStackTrace();
		}
		msg.append("}");
		return msg.toString();
	}
		/**
		 * 更新
		 * @return
		 */
	public String updatekung_dy_user(String id,String user_id,String dy_id,String ph_t,String dy_dt,String yy_t){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dy_userService iKung_dy_userService = (IKung_dy_userService)context.getBean("iKung_dy_userService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Kung_dy_user kung_dy_user=new Kung_dy_user();
		if (id != null && !id.equals(""))
			kung_dy_user.setId(Long.parseLong(id));
		if (user_id != null && !user_id.equals(""))
			kung_dy_user.setUser_id(Long.parseLong(user_id));
		if (dy_id != null && !dy_id.equals(""))
			kung_dy_user.setDy_id(Long.parseLong(dy_id));
		kung_dy_user.setPh_t(ph_t);
		try {
		if (dy_dt != null && !dy_dt.equals(""))
			kung_dy_user.setDy_dt(sdf.parse(dy_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		kung_dy_user.setYy_t(yy_t);
		try {
			iKung_dy_userService.updatekung_dy_user(kung_dy_user);
			msg.append("\"success\",\"msg\":");
			msg.append("\"更新成功.\"");
		} catch (Exception e) {
			msg.append("\"failure\",\"msg\":");
			msg.append("\"更新失败.\"");
			log.info("更新失败."+e);
			e.printStackTrace();
		}
		msg.append("}");
		return msg.toString();
	}

}

