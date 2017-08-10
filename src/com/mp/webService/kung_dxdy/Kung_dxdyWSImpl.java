package com.mp.webService.kung_dxdy;
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
import com.mp.service.kung_dxdy.IKung_dxdyService;
import com.mp.model.kung_dxdy.Kung_dxdy;
public class Kung_dxdyWSImpl implements IKung_dxdyWS {
 	/**
 	 * 根据ID查询
 	 * @return
 	 */
	public String getkung_dxdyById(String id) {
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dxdyService iKung_dxdyService = (IKung_dxdyService)context.getBean("iKung_dxdyService");
		Kung_dxdy kung_dxdy=new Kung_dxdy();
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			kung_dxdy=iKung_dxdyService.selectkung_dxdyById(id);
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
			msg.append(JSONObject.fromObject(kung_dxdy, jsonConfig));
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
	public String deletekung_dxdyById(String id) {
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dxdyService iKung_dxdyService = (IKung_dxdyService)context.getBean("iKung_dxdyService");
		try {
			iKung_dxdyService.deletekung_dxdy(id);
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
	public String getkung_dxdyByParam(String id,String dy_t,String td_t,String yw_t,String nm_t,int page,int size){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dxdyService iKung_dxdyService = (IKung_dxdyService)context.getBean("iKung_dxdyService");
		List<Kung_dxdy> list;
		try {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			Map paramMap = new HashMap();
			paramMap.put("id", id);
			paramMap.put("dy_t", dy_t);
			paramMap.put("td_t", td_t);
			paramMap.put("yw_t", yw_t);
			paramMap.put("nm_t", nm_t);
			paramMap.put("fromPage",(page-1)*size);
			paramMap.put("toPage",page*size);
			list=iKung_dxdyService.selectkung_dxdyByParam(paramMap);
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
	public String addkung_dxdy(String dy_t,String td_t,String yw_t,String nm_t){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dxdyService iKung_dxdyService = (IKung_dxdyService)context.getBean("iKung_dxdyService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Kung_dxdy kung_dxdy=new Kung_dxdy();
		kung_dxdy.setDy_t(dy_t);
		kung_dxdy.setTd_t(td_t);
		kung_dxdy.setYw_t(yw_t);
		kung_dxdy.setNm_t(nm_t);
		try {
			int result = Integer.parseInt(iKung_dxdyService.addkung_dxdy(kung_dxdy).toString());
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
	public String updatekung_dxdy(String id,String dy_t,String td_t,String yw_t,String nm_t){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_dxdyService iKung_dxdyService = (IKung_dxdyService)context.getBean("iKung_dxdyService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Kung_dxdy kung_dxdy=new Kung_dxdy();
		if (id != null && !id.equals(""))
			kung_dxdy.setId(Long.parseLong(id));
		kung_dxdy.setDy_t(dy_t);
		kung_dxdy.setTd_t(td_t);
		kung_dxdy.setYw_t(yw_t);
		kung_dxdy.setNm_t(nm_t);
		try {
			iKung_dxdyService.updatekung_dxdy(kung_dxdy);
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

