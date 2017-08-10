package com.mp.dao.kung_dxdy;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.mp.model.kung_dxdy.Kung_dxdy;
public class Kung_dxdyDaoImpl extends SqlMapClientDaoSupport implements IKung_dxdyDao {

	/**
 * 通过id选取
 * @return
 */
	public Kung_dxdy selectkung_dxdyById(String id){
		return (Kung_dxdy) getSqlMapClientTemplate().queryForObject("selectkung_dxdyById",id);
	}

	/**
 * 通过查询参数获取信息
 * @return
 */ 
	@SuppressWarnings("unchecked")
	public List<Kung_dxdy> selectkung_dxdyByParam(Map paramMap){ 
		return  getSqlMapClientTemplate().queryForList("selectkung_dxdyByParam",paramMap);
	}

	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
	@SuppressWarnings("unchecked")
	public int selectCountkung_dxdyByParam(Map paramMap){ 
		return   Integer.parseInt(getSqlMapClientTemplate().queryForObject("selectCountkung_dxdyByParam",paramMap).toString()); 
	}

	/**
 * 更新 
 * @return 
 */ 
	public  Object updatekung_dxdy(Kung_dxdy kung_dxdy){
		return  getSqlMapClientTemplate().update("updatekung_dxdy",kung_dxdy); 
	}

	/**
 * 添加 
 * @return
 */ 
	public  Object addkung_dxdy(Kung_dxdy kung_dxdy){
		return  getSqlMapClientTemplate().insert("addkung_dxdy",kung_dxdy);
	}

	/**
 * 删除 
 * @return 
 */ 
	public  Object deletekung_dxdy(String id){
		return  getSqlMapClientTemplate().delete("deletekung_dxdy",id);
	}

}

