package com.mp.dao.kung_dy_user;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.mp.model.kung_dy_user.Kung_dy_user;
public class Kung_dy_userDaoImpl extends SqlMapClientDaoSupport implements IKung_dy_userDao {

	/**
 * 通过id选取
 * @return
 */
	public Kung_dy_user selectkung_dy_userById(String id){
		return (Kung_dy_user) getSqlMapClientTemplate().queryForObject("selectkung_dy_userById",id);
	}

	/**
 * 通过查询参数获取信息
 * @return
 */ 
	@SuppressWarnings("unchecked")
	public List<Kung_dy_user> selectkung_dy_userByParam(Map paramMap){ 
		return  getSqlMapClientTemplate().queryForList("selectkung_dy_userByParam",paramMap);
	}

	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
	@SuppressWarnings("unchecked")
	public int selectCountkung_dy_userByParam(Map paramMap){ 
		return   Integer.parseInt(getSqlMapClientTemplate().queryForObject("selectCountkung_dy_userByParam",paramMap).toString()); 
	}

	/**
 * 更新 
 * @return 
 */ 
	public  Object updatekung_dy_user(Kung_dy_user kung_dy_user){
		return  getSqlMapClientTemplate().update("updatekung_dy_user",kung_dy_user); 
	}

	/**
 * 添加 
 * @return
 */ 
	public  Object addkung_dy_user(Kung_dy_user kung_dy_user){
		return  getSqlMapClientTemplate().insert("addkung_dy_user",kung_dy_user);
	}

	/**
 * 删除 
 * @return 
 */ 
	public  Object deletekung_dy_user(String id){
		return  getSqlMapClientTemplate().delete("deletekung_dy_user",id);
	}

}

