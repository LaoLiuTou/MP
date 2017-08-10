package com.mp.action.kung_dxdy;
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
import com.mp.service.kung_dxdy.IKung_dxdyService;
import com.mp.model.kung_dxdy.Kung_dxdy;
public class Kung_dxdyAction implements Action {
	private int page;
	private int size;
	private int totalpage;
	private int totalnumber;
	private String message;
	@Autowired
	private IKung_dxdyService iKung_dxdyService;
	private List<Kung_dxdy> list;
	private Kung_dxdy kung_dxdy;
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
	public Kung_dxdy getKung_dxdy() {
		return kung_dxdy;
	}
	public void setKung_dxdy(Kung_dxdy kung_dxdy) {
		this.kung_dxdy = kung_dxdy;
	}
	public List<Kung_dxdy> getList() {
		return list;
	}
	public void setList(List<Kung_dxdy> list) {
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
	private String dy_t;
	public String getDy_t() {
		return dy_t;
	}
	public void setDy_t(String dy_t) {
		this.dy_t = dy_t;
	}
	private String td_t;
	public String getTd_t() {
		return td_t;
	}
	public void setTd_t(String td_t) {
		this.td_t = td_t;
	}
	private String yw_t;
	public String getYw_t() {
		return yw_t;
	}
	public void setYw_t(String yw_t) {
		this.yw_t = yw_t;
	}
	private String nm_t;
	public String getNm_t() {
		return nm_t;
	}
	public void setNm_t(String nm_t) {
		this.nm_t = nm_t;
	}
	public String add() throws Exception {
		response.setCharacterEncoding("UTF-8"); 
		Kung_dxdy kung_dxdy =new Kung_dxdy(); 
		if(id!=null&&!id.equals(""))
		kung_dxdy.setId(Long.parseLong(id));
		kung_dxdy.setDy_t(dy_t);
		kung_dxdy.setTd_t(td_t);
		kung_dxdy.setYw_t(yw_t);
		kung_dxdy.setNm_t(nm_t);
		try {
			int result = Integer.parseInt(iKung_dxdyService.addkung_dxdy(kung_dxdy).toString());
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
			paramMap.put("dy_t", dy_t);
			paramMap.put("td_t", td_t);
			paramMap.put("yw_t", yw_t);
			paramMap.put("nm_t", nm_t);
		try {
			list=iKung_dxdyService.selectkung_dxdyByParam(paramMap); 
			totalnumber=iKung_dxdyService.selectCountkung_dxdyByParam(paramMap);
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
		Kung_dxdy kung_dxdy =new Kung_dxdy(); 
		if(id!=null&&!id.equals(""))
		kung_dxdy.setId(Long.parseLong(id));
		kung_dxdy.setDy_t(dy_t);
		kung_dxdy.setTd_t(td_t);
		kung_dxdy.setYw_t(yw_t);
		kung_dxdy.setNm_t(nm_t);
		try {
			iKung_dxdyService.updatekung_dxdy(kung_dxdy);
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
			iKung_dxdyService.deletekung_dxdy(id);
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
			kung_dxdy=iKung_dxdyService.selectkung_dxdyById(id);
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
