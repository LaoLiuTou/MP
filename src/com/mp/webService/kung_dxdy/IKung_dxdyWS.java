package com.mp.webService.kung_dxdy;
public interface IKung_dxdyWS{
 	/**
 	 * 根据ID查询
 	 * @return
 	 */
	public String getkung_dxdyById(String id);

		/**
		 * 根据ID删除
		 * 
		 * @return
		 */
	public String deletekung_dxdyById(String id);

		/**
		 * 根据查询条件查询
		 * @return
		 */
		@SuppressWarnings("unchecked")
	public String getkung_dxdyByParam(String id,String dy_t,String td_t,String yw_t,String nm_t,int page,int size);

		/**
		 * 添加
		 * @return
		 * @throws ParseException
		 */
	public String addkung_dxdy(String dy_t,String td_t,String yw_t,String nm_t);
		/**
		 * 更新
		 * @return
		 */
	public String updatekung_dxdy(String id,String dy_t,String td_t,String yw_t,String nm_t);
}

