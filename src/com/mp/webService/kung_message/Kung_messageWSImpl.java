package com.mp.webService.kung_message;
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
import com.mp.service.kung_message.IKung_messageService;
import com.mp.model.kung_message.Kung_message;
public class Kung_messageWSImpl implements IKung_messageWS {
 	/**
 	 * 根据ID查询
 	 * @return
 	 */
	public String getkung_messageById(String id) {
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_messageService iKung_messageService = (IKung_messageService)context.getBean("iKung_messageService");
		Kung_message kung_message=new Kung_message();
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			kung_message=iKung_messageService.selectkung_messageById(id);
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
			msg.append(JSONObject.fromObject(kung_message, jsonConfig));
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
	public String deletekung_messageById(String id) {
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_messageService iKung_messageService = (IKung_messageService)context.getBean("iKung_messageService");
		try {
			iKung_messageService.deletekung_message(id);
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
	public String getkung_messageByParam(String id,String fs_t,String js_t,String js_id,String st_lv,String cm_tx,String fs_dtFrom,String fs_dtTo,String fs_dt,String c_dtFrom,String c_dtTo,String c_dt,String cd_n,String yw_t,String yy_t,String dy_id,String status,String num,int page,int size){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_messageService iKung_messageService = (IKung_messageService)context.getBean("iKung_messageService");
		List<Kung_message> list;
		try {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			Map paramMap = new HashMap();
			paramMap.put("id", id);
			paramMap.put("fs_t", fs_t);
			paramMap.put("js_t", js_t);
			paramMap.put("js_id", js_id);
			paramMap.put("st_lv", st_lv);
			paramMap.put("cm_tx", cm_tx);
			if(fs_dtFrom!=null&&!fs_dtFrom.equals(""))
			paramMap.put("fs_dtFrom", sdf.parse(fs_dtFrom));
			if(fs_dtTo!=null&&!fs_dtTo.equals(""))
			paramMap.put("fs_dtTo", sdf.parse(fs_dtTo));
			paramMap.put("fs_dt", fs_dt);
			if(c_dtFrom!=null&&!c_dtFrom.equals(""))
			paramMap.put("c_dtFrom", sdf.parse(c_dtFrom));
			if(c_dtTo!=null&&!c_dtTo.equals(""))
			paramMap.put("c_dtTo", sdf.parse(c_dtTo));
			paramMap.put("c_dt", c_dt);
			paramMap.put("cd_n", cd_n);
			paramMap.put("yw_t", yw_t);
			paramMap.put("yy_t", yy_t);
			paramMap.put("dy_id", dy_id);
			paramMap.put("status", status);
			paramMap.put("num", num);
			paramMap.put("fromPage",(page-1)*size);
			paramMap.put("toPage",page*size);
			list=iKung_messageService.selectkung_messageByParam(paramMap);
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
	public String addkung_message(String fs_t,String js_t,String js_id,String st_lv,String cm_tx,String fs_dt,String c_dt,String cd_n,String yw_t,String yy_t,String dy_id,String status,String num){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_messageService iKung_messageService = (IKung_messageService)context.getBean("iKung_messageService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Kung_message kung_message=new Kung_message();
		kung_message.setFs_t(fs_t);
		kung_message.setJs_t(js_t);
		if (js_id != null && !js_id.equals(""))
			kung_message.setJs_id(Long.parseLong(js_id));
		kung_message.setSt_lv(st_lv);
		kung_message.setCm_tx(cm_tx);
		try {
		if (fs_dt != null && !fs_dt.equals(""))
			kung_message.setFs_dt(sdf.parse(fs_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
		if (c_dt != null && !c_dt.equals(""))
			kung_message.setC_dt(sdf.parse(c_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		kung_message.setCd_n(cd_n);
		kung_message.setYw_t(yw_t);
		kung_message.setYy_t(yy_t);
		if (dy_id != null && !dy_id.equals(""))
			kung_message.setDy_id(Long.parseLong(dy_id));
		kung_message.setStatus(status);
		if (num != null && !num.equals(""))
			kung_message.setNum(Long.parseLong(num));
		try {
			int result = Integer.parseInt(iKung_messageService.addkung_message(kung_message).toString());
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
	public String updatekung_message(String id,String fs_t,String js_t,String js_id,String st_lv,String cm_tx,String fs_dt,String c_dt,String cd_n,String yw_t,String yy_t,String dy_id,String status,String num){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_messageService iKung_messageService = (IKung_messageService)context.getBean("iKung_messageService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Kung_message kung_message=new Kung_message();
		if (id != null && !id.equals(""))
			kung_message.setId(Long.parseLong(id));
		kung_message.setFs_t(fs_t);
		kung_message.setJs_t(js_t);
		if (js_id != null && !js_id.equals(""))
			kung_message.setJs_id(Long.parseLong(js_id));
		kung_message.setSt_lv(st_lv);
		kung_message.setCm_tx(cm_tx);
		try {
		if (fs_dt != null && !fs_dt.equals(""))
			kung_message.setFs_dt(sdf.parse(fs_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
		if (c_dt != null && !c_dt.equals(""))
			kung_message.setC_dt(sdf.parse(c_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		kung_message.setCd_n(cd_n);
		kung_message.setYw_t(yw_t);
		kung_message.setYy_t(yy_t);
		if (dy_id != null && !dy_id.equals(""))
			kung_message.setDy_id(Long.parseLong(dy_id));
		kung_message.setStatus(status);
		if (num != null && !num.equals(""))
			kung_message.setNum(Long.parseLong(num));
		try {
			iKung_messageService.updatekung_message(kung_message);
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

