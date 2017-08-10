package com.mp.model.kung_dy_user;
import java.util.Date;
/**
 * @author LT
 */
public class Kung_dy_user {

	/**  */
	private  Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/** 用户id */
	private  Long user_id;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	/** 订阅id */
	private  Long dy_id;
	public Long getDy_id() {
		return dy_id;
	}
	public void setDy_id(Long dy_id) {
		this.dy_id = dy_id;
	}
	/** 用户手机号 */
	private  String ph_t;
	public String getPh_t() {
		return ph_t;
	}
	public void setPh_t(String ph_t) {
		this.ph_t = ph_t;
	}
	/** 订阅时间 */
	private  Date dy_dt;
	public Date getDy_dt() {
		return dy_dt;
	}
	public void setDy_dt(Date dy_dt) {
		this.dy_dt = dy_dt;
	}
	/** 运营商 */
	private  String yy_t;
	public String getYy_t() {
		return yy_t;
	}
	public void setYy_t(String yy_t) {
		this.yy_t = yy_t;
	}



}
