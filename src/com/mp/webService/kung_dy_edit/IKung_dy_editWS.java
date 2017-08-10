package com.mp.webService.kung_dy_edit;
public interface IKung_dy_editWS{
 	/**
 	 * 根据ID查询
 	 * @return
 	 */
	public String getkung_dy_editById(String id);

		/**
		 * 根据ID删除
		 * 
		 * @return
		 */
	public String deletekung_dy_editById(String id);

		/**
		 * 根据查询条件查询
		 * @return
		 */
		@SuppressWarnings("unchecked")
	public String getkung_dy_editByParam(String id,String user_id,String dy_id,String cz_lv,String cz_dtFrom,String cz_dtTo,String cz_dt,int page,int size);

		/**
		 * 添加
		 * @return
		 * @throws ParseException
		 */
	public String addkung_dy_edit(String user_id,String dy_id,String cz_lv,String cz_dt);
		/**
		 * 更新
		 * @return
		 */
	public String updatekung_dy_edit(String id,String user_id,String dy_id,String cz_lv,String cz_dt);
}

