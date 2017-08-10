package com.mp.action.kung_note_code;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.mp.service.kung_dxdy.IKung_dxdyService;
import com.mp.service.kung_note_code.IKung_note_codeService;
import com.mp.model.kung_dxdy.Kung_dxdy;
import com.mp.model.kung_note_code.Kung_note_code;
public class Kung_note_codeAction implements Action {
	private int page;
	private int size;
	private int totalpage;
	private int totalnumber;
	private String message;
	@Autowired
	private IKung_note_codeService iKung_note_codeService;
	private List<Kung_note_code> list;
	private Kung_note_code kung_note_code;
	
	 
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getTotalnumber() {
		return totalnumber;
	}
	public void setTotalnumber(int totalnumber) {
		this.totalnumber = totalnumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Kung_note_code getKung_note_code() {
		return kung_note_code;
	}
	public void setKung_note_code(Kung_note_code kung_note_code) {
		this.kung_note_code = kung_note_code;
	}
	public List<Kung_note_code> getList() {
		return list;
	}
	public void setList(List<Kung_note_code> list) {
		this.list = list;
	}
	HttpServletResponse response = ServletActionContext.getResponse(); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Logger logger = Logger.getLogger("MPLogger");
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String js_t;
	public String getJs_t() {
		return js_t;
	}
	public void setJs_t(String js_t) {
		this.js_t = js_t;
	}
	private String st_lv;
	public String getSt_lv() {
		return st_lv;
	}
	public void setSt_lv(String st_lv) {
		this.st_lv = st_lv;
	}
	private String cm_tx;
	public String getCm_tx() {
		return cm_tx;
	}
	public void setCm_tx(String cm_tx) {
		this.cm_tx = cm_tx;
	}
	private String fs_dtFrom;
	public String getFs_dtFrom() {
		return fs_dtFrom;
	}
	public void setFs_dtFrom(String fs_dtFrom) {
		this.fs_dtFrom = fs_dtFrom;
	}
	private String fs_dtTo;
	public String getFs_dtTo() {
		return fs_dtTo;
	}
	public void setFs_dtTo(String fs_dtTo) {
		this.fs_dtTo = fs_dtTo;
	}
	private String fs_dt;
	public String getFs_dt() {
		return fs_dt;
	}
	public void setFs_dt(String fs_dt) {
		this.fs_dt = fs_dt;
	}
	private String c_dtFrom;
	public String getC_dtFrom() {
		return c_dtFrom;
	}
	public void setC_dtFrom(String c_dtFrom) {
		this.c_dtFrom = c_dtFrom;
	}
	private String c_dtTo;
	public String getC_dtTo() {
		return c_dtTo;
	}
	public void setC_dtTo(String c_dtTo) {
		this.c_dtTo = c_dtTo;
	}
	private String c_dt;
	public String getC_dt() {
		return c_dt;
	}
	public void setC_dt(String c_dt) {
		this.c_dt = c_dt;
	}
	public String add() throws Exception {
		response.setCharacterEncoding("UTF-8"); 
		Kung_note_code kung_note_code =new Kung_note_code(); 
		if(id!=null&&!id.equals(""))
		kung_note_code.setId(Long.parseLong(id));
		kung_note_code.setJs_t(js_t);
		kung_note_code.setSt_lv(st_lv);
		kung_note_code.setCm_tx(cm_tx);
		if(fs_dt!=null&&!fs_dt.equals(""))
		kung_note_code.setFs_dt(sdf.parse(fs_dt));
		if(c_dt!=null&&!c_dt.equals(""))
		kung_note_code.setC_dt(sdf.parse(c_dt));
		try {
			int result = Integer.parseInt(iKung_note_codeService.addkung_note_code(kung_note_code).toString());
			response.getWriter().write("添加成功！"); 
			message="添加成功！";  
			logger.info(result+"添加成功！。");
		} catch (Exception e) {
			message="添加失败！";  
			logger.info("添加失败！。");
			e.printStackTrace();
		}
		return "add";
	}
	@SuppressWarnings("unchecked")
	public String list() throws Exception {

		size=15;
		Map  paramMap = new HashMap ();
		paramMap.put("fromPage",(page-1)*size);
		paramMap.put("toPage",page*size); 
			paramMap.put("id", id);
			paramMap.put("js_t", js_t);
			paramMap.put("st_lv", st_lv);
			paramMap.put("cm_tx", cm_tx);
			if(fs_dtFrom!=null&&!fs_dtFrom.equals(""))
			paramMap.put("fs_dtFrom", sdf.parse(fs_dtFrom));
			if(fs_dtTo!=null&&!fs_dtTo.equals(""))
			paramMap.put("fs_dtTo", sdf.parse(fs_dtTo));
			if(c_dtFrom!=null&&!c_dtFrom.equals(""))
			paramMap.put("c_dtFrom", sdf.parse(c_dtFrom));
			if(c_dtTo!=null&&!c_dtTo.equals(""))
			paramMap.put("c_dtTo", sdf.parse(c_dtTo));
		try {
			list=iKung_note_codeService.selectkung_note_codeByParam(paramMap); 
			totalnumber=iKung_note_codeService.selectCountkung_note_codeByParam(paramMap);
			if((totalnumber%size)==0){
				totalpage=(totalnumber/size);
			}
			else{
				totalpage=(totalnumber/size)+1;
			}	
			logger.info("获取列表成功！");
		} catch (Exception e) {
			logger.info("获取列表失败！"+e);
			e.printStackTrace();
		}
		return "list";
	}

	public String update() throws Exception {
		Kung_note_code kung_note_code =new Kung_note_code(); 
		if(id!=null&&!id.equals(""))
		kung_note_code.setId(Long.parseLong(id));
		kung_note_code.setJs_t(js_t);
		kung_note_code.setSt_lv(st_lv);
		kung_note_code.setCm_tx(cm_tx);
		if(fs_dt!=null&&!fs_dt.equals(""))
		kung_note_code.setFs_dt(sdf.parse(fs_dt));
		if(c_dt!=null&&!c_dt.equals(""))
		kung_note_code.setC_dt(sdf.parse(c_dt));
		try {
			iKung_note_codeService.updatekung_note_code(kung_note_code);
			response.getWriter().write("更新成功！"); 
			message="更新成功！";  
			logger.info(id+"更新成功！");
		} catch (Exception e) {
			logger.info(id+"更新失败！"+e);
			message="更新失败！"; 
			response.getWriter().write("更新失败！"); 
			e.printStackTrace();
		}
			return null;
	}
	public String delete() throws Exception {
		try {
			iKung_note_codeService.deletekung_note_code(id);
			response.getWriter().write("删除成功！"); 
			logger.info(id+"删除成功！");
		} catch (Exception e) {
			logger.info(id+"删除失败！"+e);
			response.getWriter().write("删除失败！"); 
			e.printStackTrace();
		}
		return null;
	}
	public String select() throws Exception {
		try {
			kung_note_code=iKung_note_codeService.selectkung_note_codeById(id);
			logger.info(id+"查询成功！");
		} catch (Exception e) {
			logger.info(id+"查询失败！"+e);
			e.printStackTrace();
		}
		return "select";
	}
    public String execute() throws Exception {
		return null;
	}
    
    
    
}
