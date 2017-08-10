package com.mp.dao.kung_dy_user;
import java.util.List;
import java.util.Map;
import com.mp.model.kung_dy_user.Kung_dy_user;
public interface IKung_dy_userDao {
/**
 * 通过id选取
 * @return
 */
public Kung_dy_user selectkung_dy_userById(String id);
/**
 * 通过查询参数获取信息
 * @return
 */ 
public List<Kung_dy_user> selectkung_dy_userByParam(Map paramMap); 
	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
	public int selectCountkung_dy_userByParam(Map paramMap); 
/**
 * 更新 
 * @return 
 */ 
public  Object updatekung_dy_user(Kung_dy_user kung_dy_user);
/**
 * 添加 
 * @return
 */ 
public  Object addkung_dy_user(Kung_dy_user kung_dy_user);
/**
 * 删除 
 * @return 
 */ 
public  Object deletekung_dy_user(String id);

}

