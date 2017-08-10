package com.mp.webService.kung_dy_edit;
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
import com.mp.service.kung_dy_edit.IKung_dy_editService;
import com.mp.model.kung_dy_edit.Kung_dy_edit;
public class Kung_dy_editWSImpl implements IKung_dy_editWS {
 	/**
 	 * 根据ID查询
 	 * @return
 	 */
	public String getkung_dy_editById(String id) {
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dy_editService iKung_dy_editService = (IKung_dy_editService)context.getBean("iKung_dy_editService");
		Kung_dy_edit kung_dy_edit=new Kung_dy_edit();
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			kung_dy_edit=iKung_dy_editService.selectkung_dy_editById(id);
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
			msg.append(JSONObject.fromObject(kung_dy_edit, jsonConfig));
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
	public String deletekung_dy_editById(String id) {
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dy_editService iKung_dy_editService = (IKung_dy_editService)context.getBean("iKung_dy_editService");
		try {
			iKung_dy_editService.deletekung_dy_edit(id);
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
	public String getkung_dy_editByParam(String id,String user_id,String dy_id,String cz_lv,String cz_dtFrom,String cz_dtTo,String cz_dt,int page,int size){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dy_editService iKung_dy_editService = (IKung_dy_editService)context.getBean("iKung_dy_editService");
		List<Kung_dy_edit> list;
		try {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			Map paramMap = new HashMap();
			paramMap.put("id", id);
			paramMap.put("user_id", user_id);
			paramMap.put("dy_id", dy_id);
			paramMap.put("cz_lv", cz_lv);
			if(cz_dtFrom!=null&&!cz_dtFrom.equals(""))
			paramMap.put("cz_dtFrom", sdf.parse(cz_dtFrom));
			if(cz_dtTo!=null&&!cz_dtTo.equals(""))
			paramMap.put("cz_dtTo", sdf.parse(cz_dtTo));
			paramMap.put("cz_dt", cz_dt);
			paramMap.put("fromPage",(page-1)*size);
			paramMap.put("toPage",page*size);
			list=iKung_dy_editService.selectkung_dy_editByParam(paramMap);
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
	public String addkung_dy_edit(String user_id,String dy_id,String cz_lv,String cz_dt){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dy_editService iKung_dy_editService = (IKung_dy_editService)context.getBean("iKung_dy_editService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Kung_dy_edit kung_dy_edit=new Kung_dy_edit();
		if (user_id != null && !user_id.equals(""))
			kung_dy_edit.setUser_id(Long.parseLong(user_id));
		if (dy_id != null && !dy_id.equals(""))
			kung_dy_edit.setDy_id(Long.parseLong(dy_id));
		kung_dy_edit.setCz_lv(cz_lv);
		try {
		if (cz_dt != null && !cz_dt.equals(""))
			kung_dy_edit.setCz_dt(sdf.parse(cz_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			int result = Integer.parseInt(iKung_dy_editService.addkung_dy_edit(kung_dy_edit).toString());
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
	public String updatekung_dy_edit(String id,String user_id,String dy_id,String cz_lv,String cz_dt){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dy_editService iKung_dy_editService = (IKung_dy_editService)context.getBean("iKung_dy_editService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Kung_dy_edit kung_dy_edit=new Kung_dy_edit();
		if (id != null && !id.equals(""))
			kung_dy_edit.setId(Long.parseLong(id));
		if (user_id != null && !user_id.equals(""))
			kung_dy_edit.setUser_id(Long.parseLong(user_id));
		if (dy_id != null && !dy_id.equals(""))
			kung_dy_edit.setDy_id(Long.parseLong(dy_id));
		kung_dy_edit.setCz_lv(cz_lv);
		try {
		if (cz_dt != null && !cz_dt.equals(""))
			kung_dy_edit.setCz_dt(sdf.parse(cz_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			iKung_dy_editService.updatekung_dy_edit(kung_dy_edit);
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

