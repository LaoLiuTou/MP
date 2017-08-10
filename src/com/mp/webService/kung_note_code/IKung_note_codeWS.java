package com.mp.webService.kung_note_code;
public interface IKung_note_codeWS{
 	/**
 	 * 根据ID查询
 	 * @return
 	 */
	public String getkung_note_codeById(String id);

		/**
		 * 根据ID删除
		 * 
		 * @return
		 */
	public String deletekung_note_codeById(String id);

		/**
		 * 根据查询条件查询
		 * @return
		 */
		@SuppressWarnings("unchecked")
	public String getkung_note_codeByParam(String id,String js_t,String st_lv,String cm_tx,String fs_dtFrom,String fs_dtTo,String fs_dt,String c_dtFrom,String c_dtTo,String c_dt,int page,int size);

		/**
		 * 添加
		 * @return
		 * @throws ParseException
		 */
	public String addkung_note_code(String js_t,String st_lv,String cm_tx,String fs_dt,String c_dt);
		/**
		 * 更新
		 * @return
		 */
	public String updatekung_note_code(String id,String js_t,String st_lv,String cm_tx,String fs_dt,String c_dt);
}

