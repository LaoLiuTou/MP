package com.mp.dao.kung_dy_edit;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.mp.model.kung_dy_edit.Kung_dy_edit;
public class Kung_dy_editDaoImpl extends SqlMapClientDaoSupport implements IKung_dy_editDao {

	/**
 * 通过id选取
 * @return
 */
	public Kung_dy_edit selectkung_dy_editById(String id){
		return (Kung_dy_edit) getSqlMapClientTemplate().queryForObject("selectkung_dy_editById",id);
	}

	/**
 * 通过查询参数获取信息
 * @return
 */ 
	@SuppressWarnings("unchecked")
	public List<Kung_dy_edit> selectkung_dy_editByParam(Map paramMap){ 
		return  getSqlMapClientTemplate().queryForList("selectkung_dy_editByParam",paramMap);
	}

	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
	@SuppressWarnings("unchecked")
	public int selectCountkung_dy_editByParam(Map paramMap){ 
		return   Integer.parseInt(getSqlMapClientTemplate().queryForObject("selectCountkung_dy_editByParam",paramMap).toString()); 
	}

	/**
 * 更新 
 * @return 
 */ 
	public  Object updatekung_dy_edit(Kung_dy_edit kung_dy_edit){
		return  getSqlMapClientTemplate().update("updatekung_dy_edit",kung_dy_edit); 
	}

	/**
 * 添加 
 * @return
 */ 
	public  Object addkung_dy_edit(Kung_dy_edit kung_dy_edit){
		return  getSqlMapClientTemplate().insert("addkung_dy_edit",kung_dy_edit);
	}

	/**
 * 删除 
 * @return 
 */ 
	public  Object deletekung_dy_edit(String id){
		return  getSqlMapClientTemplate().delete("deletekung_dy_edit",id);
	}

}

