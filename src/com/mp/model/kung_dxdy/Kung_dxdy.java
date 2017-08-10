package com.mp.model.kung_dxdy;
import java.util.Date;
/**
 * @author LT
 */
public class Kung_dxdy {

	/**  */
	private  Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/** 订阅码 */
	private  String dy_t;
	public String getDy_t() {
		return dy_t;
	}
	public void setDy_t(String dy_t) {
		this.dy_t = dy_t;
	}
	/** 退订码 */
	private  String td_t;
	public String getTd_t() {
		return td_t;
	}
	public void setTd_t(String td_t) {
		this.td_t = td_t;
	}
	/** 业务码
 */
	private  String yw_t;
	public String getYw_t() {
		return yw_t;
	}
	public void setYw_t(String yw_t) {
		this.yw_t = yw_t;
	}
	/** 业务名称
 */
	private  String nm_t;
	public String getNm_t() {
		return nm_t;
	}
	public void setNm_t(String nm_t) {
		this.nm_t = nm_t;
	}



}
