package com.mp.webService.kung_message;
public interface IKung_messageWS{
 	/**
 	 * 根据ID查询
 	 * @return
 	 */
	public String getkung_messageById(String id);

		/**
		 * 根据ID删除
		 * 
		 * @return
		 */
	public String deletekung_messageById(String id);

		/**
		 * 根据查询条件查询
		 * @return
		 */
		@SuppressWarnings("unchecked")
	public String getkung_messageByParam(String id,String fs_t,String js_t,String js_id,String st_lv,String cm_tx,String fs_dtFrom,String fs_dtTo,String fs_dt,String c_dtFrom,String c_dtTo,String c_dt,String cd_n,String yw_t,String yy_t,String dy_id,String status,String num,int page,int size);

		/**
		 * 添加
		 * @return
		 * @throws ParseException
		 */
	public String addkung_message(String fs_t,String js_t,String js_id,String st_lv,String cm_tx,String fs_dt,String c_dt,String cd_n,String yw_t,String yy_t,String dy_id,String status,String num);
		/**
		 * 更新
		 * @return
		 */
	public String updatekung_message(String id,String fs_t,String js_t,String js_id,String st_lv,String cm_tx,String fs_dt,String c_dt,String cd_n,String yw_t,String yy_t,String dy_id,String status,String num);
}

