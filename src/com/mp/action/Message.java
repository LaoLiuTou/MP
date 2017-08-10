package com.mp.action;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.mp.model.kung_note_code.Kung_note_code;
import com.mp.service.kung_note_code.IKung_note_codeService;
import com.opensymphony.xwork2.Action;
import com.smgp.client.Config;
import com.utils.Key;
import com.utils.PhoneNumber;

public class Message implements Action {
	private int page;
	private int size;
	private int totalpage;
	private int totalnumber;
	private String message;
	@Autowired
	private IKung_note_codeService iKung_note_codeService;
	private List<Kung_note_code> list;
	private Kung_note_code kung_note_code;
	
	
	//调用短信接口使用
	private String phone;
	private String key;
	private String content;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
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
	public String send()throws Exception{
	    StringBuffer msg = new StringBuffer("{\"state\":");
    	//
		//response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			
			if(PhoneNumber.matchesPhoneNumber(phone)==4){
				message="号码错误！";  
				msg.append("\"1\",\"msg\":\""+message);
				
			}
			else {
				Properties properties = new Properties();
				String base = Config.class.getResource("/")
						.getPath();
				properties.load(new FileInputStream(base
							+ "properties/key.properties"));
				System.out.println(properties.getProperty("nongweiKeys")+phone+content);
				String localKey=Key.Md5Str(properties.getProperty("nongweiKeys")+phone+content);
				System.out.println(localKey);
				if(!localKey.equals(key.toUpperCase())){
					message="验证错误！";  
					msg.append("\"1\",\"msg\":\""+message);
					
				}
				else{
					Kung_note_code kung_note_code =new Kung_note_code(); 
					if(id!=null&&!id.equals(""))
					kung_note_code.setId(Long.parseLong(id));
					kung_note_code.setJs_t(phone);
					kung_note_code.setSt_lv("0");
					kung_note_code.setCm_tx(content);  
					kung_note_code.setC_dt(new Date());
					int result = Integer.parseInt(iKung_note_codeService.addkung_note_code(kung_note_code).toString());
					message="发送成功！";  
					msg.append("\"0\",\"msg\":\""+message);
					logger.info(result+"添加成功！。");
					 
				}
				
			} 
		} catch (Exception e) {
			message="添加失败！";  
			msg.append("\"1\",\"msg\":\""+message);
			logger.info("添加失败！。"+e);
			e.printStackTrace();
		}
		finally{
			
			msg.append("\"}");
			response.getWriter().write(msg.toString()); 
		}
		
		return null;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
     
    
}
