package com.mp.model.kung_dy_edit;
import java.util.Date;
/**
 * @author LT
 */
public class Kung_dy_edit {

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
	/** 操作类型：订阅、退订 */
	private  String cz_lv;
	public String getCz_lv() {
		return cz_lv;
	}
	public void setCz_lv(String cz_lv) {
		this.cz_lv = cz_lv;
	}
	/** 操作时间 */
	private  Date cz_dt;
	public Date getCz_dt() {
		return cz_dt;
	}
	public void setCz_dt(Date cz_dt) {
		this.cz_dt = cz_dt;
	}



}
