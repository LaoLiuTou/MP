package com.mp.webService.kung_dy_user;
public interface IKung_dy_userWS{
 	/**
 	 * 根据ID查询
 	 * @return
 	 */
	public String getkung_dy_userById(String id);

		/**
		 * 根据ID删除
		 * 
		 * @return
		 */
	public String deletekung_dy_userById(String id);

		/**
		 * 根据查询条件查询
		 * @return
		 */
		@SuppressWarnings("unchecked")
	public String getkung_dy_userByParam(String id,String user_id,String dy_id,String ph_t,String dy_dtFrom,String dy_dtTo,String dy_dt,String yy_t,int page,int size);

		/**
		 * 添加
		 * @return
		 * @throws ParseException
		 */
	public String addkung_dy_user(String user_id,String dy_id,String ph_t,String dy_dt,String yy_t);
		/**
		 * 更新
		 * @return
		 */
	public String updatekung_dy_user(String id,String user_id,String dy_id,String ph_t,String dy_dt,String yy_t);
}

