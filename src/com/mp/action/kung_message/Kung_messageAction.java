package com.mp.action.kung_message;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.Action;
import com.mp.service.kung_message.IKung_messageService;
import com.mp.model.kung_message.Kung_message;
public class Kung_messageAction implements Action {
	private int page;
	private int size;
	private int totalpage;
	private int totalnumber;
	private String message;
	@Autowired
	private IKung_messageService iKung_messageService;
	private List<Kung_message> list;
	private Kung_message kung_message;
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
	public Kung_message getKung_message() {
		return kung_message;
	}
	public void setKung_message(Kung_message kung_message) {
		this.kung_message = kung_message;
	}
	public List<Kung_message> getList() {
		return list;
	}
	public void setList(List<Kung_message> list) {
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
	private String fs_t;
	public String getFs_t() {
		return fs_t;
	}
	public void setFs_t(String fs_t) {
		this.fs_t = fs_t;
	}
	private String js_t;
	public String getJs_t() {
		return js_t;
	}
	public void setJs_t(String js_t) {
		this.js_t = js_t;
	}
	private String js_id;
	public String getJs_id() {
		return js_id;
	}
	public void setJs_id(String js_id) {
		this.js_id = js_id;
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
	private String cd_n;
	public String getCd_n() {
		return cd_n;
	}
	public void setCd_n(String cd_n) {
		this.cd_n = cd_n;
	}
	private String yw_t;
	public String getYw_t() {
		return yw_t;
	}
	public void setYw_t(String yw_t) {
		this.yw_t = yw_t;
	}
	private String yy_t;
	public String getYy_t() {
		return yy_t;
	}
	public void setYy_t(String yy_t) {
		this.yy_t = yy_t;
	}
	private String dy_id;
	public String getDy_id() {
		return dy_id;
	}
	public void setDy_id(String dy_id) {
		this.dy_id = dy_id;
	}
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String num;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String add() throws Exception {
		response.setCharacterEncoding("UTF-8"); 
		Kung_message kung_message =new Kung_message(); 
		if(id!=null&&!id.equals(""))
		kung_message.setId(Long.parseLong(id));
		kung_message.setFs_t(fs_t);
		kung_message.setJs_t(js_t);
		if(js_id!=null&&!js_id.equals(""))
		kung_message.setJs_id(Long.parseLong(js_id));
		kung_message.setSt_lv(st_lv);
		kung_message.setCm_tx(cm_tx);
		if(fs_dt!=null&&!fs_dt.equals(""))
		kung_message.setFs_dt(sdf.parse(fs_dt));
		if(c_dt!=null&&!c_dt.equals(""))
		kung_message.setC_dt(sdf.parse(c_dt));
		kung_message.setCd_n(cd_n);
		kung_message.setYw_t(yw_t);
		kung_message.setYy_t(yy_t);
		if(dy_id!=null&&!dy_id.equals(""))
		kung_message.setDy_id(Long.parseLong(dy_id));
		kung_message.setStatus(status);
		if(num!=null&&!num.equals(""))
		kung_message.setNum(Long.parseLong(num));
		try {
			int result = Integer.parseInt(iKung_messageService.addkung_message(kung_message).toString());
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
			paramMap.put("fs_t", fs_t);
			paramMap.put("js_t", js_t);
			paramMap.put("js_id", js_id);
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
			paramMap.put("cd_n", cd_n);
			paramMap.put("yw_t", yw_t);
			paramMap.put("yy_t", yy_t);
			paramMap.put("dy_id", dy_id);
			paramMap.put("status", status);
			paramMap.put("num", num);
		try {
			list=iKung_messageService.selectkung_messageByParam(paramMap); 
			totalnumber=iKung_messageService.selectCountkung_messageByParam(paramMap);
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
		Kung_message kung_message =new Kung_message(); 
		if(id!=null&&!id.equals(""))
		kung_message.setId(Long.parseLong(id));
		kung_message.setFs_t(fs_t);
		kung_message.setJs_t(js_t);
		if(js_id!=null&&!js_id.equals(""))
		kung_message.setJs_id(Long.parseLong(js_id));
		kung_message.setSt_lv(st_lv);
		kung_message.setCm_tx(cm_tx);
		if(fs_dt!=null&&!fs_dt.equals(""))
		kung_message.setFs_dt(sdf.parse(fs_dt));
		if(c_dt!=null&&!c_dt.equals(""))
		kung_message.setC_dt(sdf.parse(c_dt));
		kung_message.setCd_n(cd_n);
		kung_message.setYw_t(yw_t);
		kung_message.setYy_t(yy_t);
		if(dy_id!=null&&!dy_id.equals(""))
		kung_message.setDy_id(Long.parseLong(dy_id));
		kung_message.setStatus(status);
		if(num!=null&&!num.equals(""))
		kung_message.setNum(Long.parseLong(num));
		try {
			iKung_messageService.updatekung_message(kung_message);
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
			iKung_messageService.deletekung_message(id);
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
			kung_message=iKung_messageService.selectkung_messageById(id);
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
