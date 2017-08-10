package com.mp.model.kung_note_code;
import java.util.Date;
/**
 * @author LT
 */
public class Kung_note_code {

	/**  */
	private  Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/** 接收号 */
	private  String js_t;
	public String getJs_t() {
		return js_t;
	}
	public void setJs_t(String js_t) {
		this.js_t = js_t;
	}
	/** 状态0/1;待发送,已发送 */
	private  String st_lv;
	public String getSt_lv() {
		return st_lv;
	}
	public void setSt_lv(String st_lv) {
		this.st_lv = st_lv;
	}
	/** 内容 */
	private  String cm_tx;
	public String getCm_tx() {
		return cm_tx;
	}
	public void setCm_tx(String cm_tx) {
		this.cm_tx = cm_tx;
	}
	/** 发送时间 */
	private  Date fs_dt;
	public Date getFs_dt() {
		return fs_dt;
	}
	public void setFs_dt(Date fs_dt) {
		this.fs_dt = fs_dt;
	}
	/** 创建时间 */
	private  Date c_dt;
	public Date getC_dt() {
		return c_dt;
	}
	public void setC_dt(Date c_dt) {
		this.c_dt = c_dt;
	}



}
