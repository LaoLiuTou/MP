package com.mp.dao.kung_dy_edit;
import java.util.List;
import java.util.Map;
import com.mp.model.kung_dy_edit.Kung_dy_edit;
public interface IKung_dy_editDao {
/**
 * 通过id选取
 * @return
 */
public Kung_dy_edit selectkung_dy_editById(String id);
/**
 * 通过查询参数获取信息
 * @return
 */ 
public List<Kung_dy_edit> selectkung_dy_editByParam(Map paramMap); 
	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
	public int selectCountkung_dy_editByParam(Map paramMap); 
/**
 * 更新 
 * @return 
 */ 
public  Object updatekung_dy_edit(Kung_dy_edit kung_dy_edit);
/**
 * 添加 
 * @return
 */ 
public  Object addkung_dy_edit(Kung_dy_edit kung_dy_edit);
/**
 * 删除 
 * @return 
 */ 
public  Object deletekung_dy_edit(String id);

}

