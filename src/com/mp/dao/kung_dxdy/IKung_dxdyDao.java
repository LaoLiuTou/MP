package com.mp.dao.kung_dxdy;
import java.util.List;
import java.util.Map;
import com.mp.model.kung_dxdy.Kung_dxdy;
public interface IKung_dxdyDao {
/**
 * 通过id选取
 * @return
 */
public Kung_dxdy selectkung_dxdyById(String id);
/**
 * 通过查询参数获取信息
 * @return
 */ 
public List<Kung_dxdy> selectkung_dxdyByParam(Map paramMap); 
	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
	public int selectCountkung_dxdyByParam(Map paramMap); 
/**
 * 更新 
 * @return 
 */ 
public  Object updatekung_dxdy(Kung_dxdy kung_dxdy);
/**
 * 添加 
 * @return
 */ 
public  Object addkung_dxdy(Kung_dxdy kung_dxdy);
/**
 * 删除 
 * @return 
 */ 
public  Object deletekung_dxdy(String id);

}

