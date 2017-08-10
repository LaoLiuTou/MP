package com.mp.action.kung_dy_user;
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
import com.mp.service.kung_dy_user.IKung_dy_userService;
import com.mp.model.kung_dy_user.Kung_dy_user;
public class Kung_dy_userAction implements Action {
	private int page;
	private int size;
	private int totalpage;
	private int totalnumber;
	private String message;
	@Autowired
	private IKung_dy_userService iKung_dy_userService;
	private List<Kung_dy_user> list;
	private Kung_dy_user kung_dy_user;
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
	public Kung_dy_user getKung_dy_user() {
		return kung_dy_user;
	}
	public void setKung_dy_user(Kung_dy_user kung_dy_user) {
		this.kung_dy_user = kung_dy_user;
	}
	public List<Kung_dy_user> getList() {
		return list;
	}
	public void setList(List<Kung_dy_user> list) {
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
	private String user_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	private String dy_id;
	public String getDy_id() {
		return dy_id;
	}
	public void setDy_id(String dy_id) {
		this.dy_id = dy_id;
	}
	private String ph_t;
	public String getPh_t() {
		return ph_t;
	}
	public void setPh_t(String ph_t) {
		this.ph_t = ph_t;
	}
	private String dy_dtFrom;
	public String getDy_dtFrom() {
		return dy_dtFrom;
	}
	public void setDy_dtFrom(String dy_dtFrom) {
		this.dy_dtFrom = dy_dtFrom;
	}
	private String dy_dtTo;
	public String getDy_dtTo() {
		return dy_dtTo;
	}
	public void setDy_dtTo(String dy_dtTo) {
		this.dy_dtTo = dy_dtTo;
	}
	private String dy_dt;
	public String getDy_dt() {
		return dy_dt;
	}
	public void setDy_dt(String dy_dt) {
		this.dy_dt = dy_dt;
	}
	private String yy_t;
	public String getYy_t() {
		return yy_t;
	}
	public void setYy_t(String yy_t) {
		this.yy_t = yy_t;
	}
	public String add() throws Exception {
		response.setCharacterEncoding("UTF-8"); 
		Kung_dy_user kung_dy_user =new Kung_dy_user(); 
		if(id!=null&&!id.equals(""))
		kung_dy_user.setId(Long.parseLong(id));
		if(user_id!=null&&!user_id.equals(""))
		kung_dy_user.setUser_id(Long.parseLong(user_id));
		if(dy_id!=null&&!dy_id.equals(""))
		kung_dy_user.setDy_id(Long.parseLong(dy_id));
		kung_dy_user.setPh_t(ph_t);
		if(dy_dt!=null&&!dy_dt.equals(""))
		kung_dy_user.setDy_dt(sdf.parse(dy_dt));
		kung_dy_user.setYy_t(yy_t);
		try {
			int result = Integer.parseInt(iKung_dy_userService.addkung_dy_user(kung_dy_user).toString());
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
			paramMap.put("user_id", user_id);
			paramMap.put("dy_id", dy_id);
			paramMap.put("ph_t", ph_t);
			if(dy_dtFrom!=null&&!dy_dtFrom.equals(""))
			paramMap.put("dy_dtFrom", sdf.parse(dy_dtFrom));
			if(dy_dtTo!=null&&!dy_dtTo.equals(""))
			paramMap.put("dy_dtTo", sdf.parse(dy_dtTo));
			paramMap.put("yy_t", yy_t);
		try {
			list=iKung_dy_userService.selectkung_dy_userByParam(paramMap); 
			totalnumber=iKung_dy_userService.selectCountkung_dy_userByParam(paramMap);
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
		Kung_dy_user kung_dy_user =new Kung_dy_user(); 
		if(id!=null&&!id.equals(""))
		kung_dy_user.setId(Long.parseLong(id));
		if(user_id!=null&&!user_id.equals(""))
		kung_dy_user.setUser_id(Long.parseLong(user_id));
		if(dy_id!=null&&!dy_id.equals(""))
		kung_dy_user.setDy_id(Long.parseLong(dy_id));
		kung_dy_user.setPh_t(ph_t);
		if(dy_dt!=null&&!dy_dt.equals(""))
		kung_dy_user.setDy_dt(sdf.parse(dy_dt));
		kung_dy_user.setYy_t(yy_t);
		try {
			iKung_dy_userService.updatekung_dy_user(kung_dy_user);
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
			iKung_dy_userService.deletekung_dy_user(id);
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
			kung_dy_user=iKung_dy_userService.selectkung_dy_userById(id);
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
