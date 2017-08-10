package com.mp.dao.kung_message;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.mp.model.kung_message.Kung_message;
public class Kung_messageDaoImpl extends SqlMapClientDaoSupport implements IKung_messageDao {

	/**
 * 通过id选取
 * @return
 */
	public Kung_message selectkung_messageById(String id){
		return (Kung_message) getSqlMapClientTemplate().queryForObject("selectkung_messageById",id);
	}

	/**
 * 通过查询参数获取信息
 * @return
 */ 
	@SuppressWarnings("unchecked")
	public List<Kung_message> selectkung_messageByParam(Map paramMap){ 
		return  getSqlMapClientTemplate().queryForList("selectkung_messageByParam",paramMap);
	}

	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
	@SuppressWarnings("unchecked")
	public int selectCountkung_messageByParam(Map paramMap){ 
		return   Integer.parseInt(getSqlMapClientTemplate().queryForObject("selectCountkung_messageByParam",paramMap).toString()); 
	}

	/**
 * 更新 
 * @return 
 */ 
	public  Object updatekung_message(Kung_message kung_message){
		return  getSqlMapClientTemplate().update("updatekung_message",kung_message); 
	}

	/**
 * 添加 
 * @return
 */ 
	public  Object addkung_message(Kung_message kung_message){
		return  getSqlMapClientTemplate().insert("addkung_message",kung_message);
	}

	/**
 * 删除 
 * @return 
 */ 
	public  Object deletekung_message(String id){
		return  getSqlMapClientTemplate().delete("deletekung_message",id);
	}

}

