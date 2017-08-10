package com.mp.webService.kung_note_code;
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
import com.mp.service.kung_note_code.IKung_note_codeService;
import com.mp.model.kung_note_code.Kung_note_code;
public class Kung_note_codeWSImpl implements IKung_note_codeWS {
 	/**
 	 * 根据ID查询
 	 * @return
 	 */
	public String getkung_note_codeById(String id) {
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_note_codeService iKung_note_codeService = (IKung_note_codeService)context.getBean("iKung_note_codeService");
		Kung_note_code kung_note_code=new Kung_note_code();
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			kung_note_code=iKung_note_codeService.selectkung_note_codeById(id);
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
			msg.append(JSONObject.fromObject(kung_note_code, jsonConfig));
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
	public String deletekung_note_codeById(String id) {
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_note_codeService iKung_note_codeService = (IKung_note_codeService)context.getBean("iKung_note_codeService");
		try {
			iKung_note_codeService.deletekung_note_code(id);
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
	public String getkung_note_codeByParam(String id,String js_t,String st_lv,String cm_tx,String fs_dtFrom,String fs_dtTo,String fs_dt,String c_dtFrom,String c_dtTo,String c_dt,int page,int size){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_note_codeService iKung_note_codeService = (IKung_note_codeService)context.getBean("iKung_note_codeService");
		List<Kung_note_code> list;
		try {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			Map paramMap = new HashMap();
			paramMap.put("id", id);
			paramMap.put("js_t", js_t);
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
			paramMap.put("fromPage",(page-1)*size);
			paramMap.put("toPage",page*size);
			list=iKung_note_codeService.selectkung_note_codeByParam(paramMap);
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
	public String addkung_note_code(String js_t,String st_lv,String cm_tx,String fs_dt,String c_dt){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_note_codeService iKung_note_codeService = (IKung_note_codeService)context.getBean("iKung_note_codeService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Kung_note_code kung_note_code=new Kung_note_code();
		kung_note_code.setJs_t(js_t);
		kung_note_code.setSt_lv(st_lv);
		kung_note_code.setCm_tx(cm_tx);
		try {
		if (fs_dt != null && !fs_dt.equals(""))
			kung_note_code.setFs_dt(sdf.parse(fs_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
		if (c_dt != null && !c_dt.equals(""))
			kung_note_code.setC_dt(sdf.parse(c_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			int result = Integer.parseInt(iKung_note_codeService.addkung_note_code(kung_note_code).toString());
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
	public String updatekung_note_code(String id,String js_t,String st_lv,String cm_tx,String fs_dt,String c_dt){
		Logger log = Logger.getLogger("MPLogger");
		StringBuffer msg = new StringBuffer("{\"state\":");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IKung_note_codeService iKung_note_codeService = (IKung_note_codeService)context.getBean("iKung_note_codeService");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Kung_note_code kung_note_code=new Kung_note_code();
		if (id != null && !id.equals(""))
			kung_note_code.setId(Long.parseLong(id));
		kung_note_code.setJs_t(js_t);
		kung_note_code.setSt_lv(st_lv);
		kung_note_code.setCm_tx(cm_tx);
		try {
		if (fs_dt != null && !fs_dt.equals(""))
			kung_note_code.setFs_dt(sdf.parse(fs_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
		if (c_dt != null && !c_dt.equals(""))
			kung_note_code.setC_dt(sdf.parse(c_dt));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			iKung_note_codeService.updatekung_note_code(kung_note_code);
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

