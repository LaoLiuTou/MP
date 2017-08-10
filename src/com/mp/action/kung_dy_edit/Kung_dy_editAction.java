package com.mp.action.kung_dy_edit;
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
import com.mp.service.kung_dy_edit.IKung_dy_editService;
import com.mp.model.kung_dy_edit.Kung_dy_edit;
public class Kung_dy_editAction implements Action {
	private int page;
	private int size;
	private int totalpage;
	private int totalnumber;
	private String message;
	@Autowired
	private IKung_dy_editService iKung_dy_editService;
	private List<Kung_dy_edit> list;
	private Kung_dy_edit kung_dy_edit;
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
	public Kung_dy_edit getKung_dy_edit() {
		return kung_dy_edit;
	}
	public void setKung_dy_edit(Kung_dy_edit kung_dy_edit) {
		this.kung_dy_edit = kung_dy_edit;
	}
	public List<Kung_dy_edit> getList() {
		return list;
	}
	public void setList(List<Kung_dy_edit> list) {
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
	private String cz_lv;
	public String getCz_lv() {
		return cz_lv;
	}
	public void setCz_lv(String cz_lv) {
		this.cz_lv = cz_lv;
	}
	private String cz_dtFrom;
	public String getCz_dtFrom() {
		return cz_dtFrom;
	}
	public void setCz_dtFrom(String cz_dtFrom) {
		this.cz_dtFrom = cz_dtFrom;
	}
	private String cz_dtTo;
	public String getCz_dtTo() {
		return cz_dtTo;
	}
	public void setCz_dtTo(String cz_dtTo) {
		this.cz_dtTo = cz_dtTo;
	}
	private String cz_dt;
	public String getCz_dt() {
		return cz_dt;
	}
	public void setCz_dt(String cz_dt) {
		this.cz_dt = cz_dt;
	}
	public String add() throws Exception {
		response.setCharacterEncoding("UTF-8"); 
		Kung_dy_edit kung_dy_edit =new Kung_dy_edit(); 
		if(id!=null&&!id.equals(""))
		kung_dy_edit.setId(Long.parseLong(id));
		if(user_id!=null&&!user_id.equals(""))
		kung_dy_edit.setUser_id(Long.parseLong(user_id));
		if(dy_id!=null&&!dy_id.equals(""))
		kung_dy_edit.setDy_id(Long.parseLong(dy_id));
		kung_dy_edit.setCz_lv(cz_lv);
		if(cz_dt!=null&&!cz_dt.equals(""))
		kung_dy_edit.setCz_dt(sdf.parse(cz_dt));
		try {
			int result = Integer.parseInt(iKung_dy_editService.addkung_dy_edit(kung_dy_edit).toString());
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
			paramMap.put("cz_lv", cz_lv);
			if(cz_dtFrom!=null&&!cz_dtFrom.equals(""))
			paramMap.put("cz_dtFrom", sdf.parse(cz_dtFrom));
			if(cz_dtTo!=null&&!cz_dtTo.equals(""))
			paramMap.put("cz_dtTo", sdf.parse(cz_dtTo));
		try {
			list=iKung_dy_editService.selectkung_dy_editByParam(paramMap); 
			totalnumber=iKung_dy_editService.selectCountkung_dy_editByParam(paramMap);
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
		Kung_dy_edit kung_dy_edit =new Kung_dy_edit(); 
		if(id!=null&&!id.equals(""))
		kung_dy_edit.setId(Long.parseLong(id));
		if(user_id!=null&&!user_id.equals(""))
		kung_dy_edit.setUser_id(Long.parseLong(user_id));
		if(dy_id!=null&&!dy_id.equals(""))
		kung_dy_edit.setDy_id(Long.parseLong(dy_id));
		kung_dy_edit.setCz_lv(cz_lv);
		if(cz_dt!=null&&!cz_dt.equals(""))
		kung_dy_edit.setCz_dt(sdf.parse(cz_dt));
		try {
			iKung_dy_editService.updatekung_dy_edit(kung_dy_edit);
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
			iKung_dy_editService.deletekung_dy_edit(id);
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
			kung_dy_edit=iKung_dy_editService.selectkung_dy_editById(id);
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
