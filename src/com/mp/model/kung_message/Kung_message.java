package com.mp.model.kung_message;
import java.util.Date;
/**
 * @author LT
 */
public class Kung_message {

	/**  */
	private  Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/** 发送号 */
	private  String fs_t;
	public String getFs_t() {
		return fs_t;
	}
	public void setFs_t(String fs_t) {
		this.fs_t = fs_t;
	}
	/** 接收号 */
	private  String js_t;
	public String getJs_t() {
		return js_t;
	}
	public void setJs_t(String js_t) {
		this.js_t = js_t;
	}
	/** 接收ID */
	private  Long js_id;
	public Long getJs_id() {
		return js_id;
	}
	public void setJs_id(Long js_id) {
		this.js_id = js_id;
	}
	/** 状态:0/1;待发送,已发送 */
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
	/** 短信长度 */
	private  String cd_n;
	public String getCd_n() {
		return cd_n;
	}
	public void setCd_n(String cd_n) {
		this.cd_n = cd_n;
	}
	/** 业务编码 */
	private  String yw_t;
	public String getYw_t() {
		return yw_t;
	}
	public void setYw_t(String yw_t) {
		this.yw_t = yw_t;
	}
	/** 运营商 */
	private  String yy_t;
	public String getYy_t() {
		return yy_t;
	}
	public void setYy_t(String yy_t) {
		this.yy_t = yy_t;
	}
	/** 订阅ID */
	private  Long dy_id;
	public Long getDy_id() {
		return dy_id;
	}
	public void setDy_id(Long dy_id) {
		this.dy_id = dy_id;
	}
	/** 状态0/1;待审核,已审批 */
	private  String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/** 批次号 */
	private  Long num;
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	/** 延迟时间 */
	private Date ds_dt;
	public Date getDs_dt() {
		return ds_dt;
	}
	public void setDs_dt(Date ds_dt) {
		this.ds_dt = ds_dt;
	}
	
	


}
