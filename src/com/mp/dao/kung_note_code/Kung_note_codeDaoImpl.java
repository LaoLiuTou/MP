package com.mp.dao.kung_note_code;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.mp.model.kung_note_code.Kung_note_code;
public class Kung_note_codeDaoImpl extends SqlMapClientDaoSupport implements IKung_note_codeDao {

	/**
 * 通过id选取
 * @return
 */
	public Kung_note_code selectkung_note_codeById(String id){
		return (Kung_note_code) getSqlMapClientTemplate().queryForObject("selectkung_note_codeById",id);
	}

	/**
 * 通过查询参数获取信息
 * @return
 */ 
	@SuppressWarnings("unchecked")
	public List<Kung_note_code> selectkung_note_codeByParam(Map paramMap){ 
		return  getSqlMapClientTemplate().queryForList("selectkung_note_codeByParam",paramMap);
	}

	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
	@SuppressWarnings("unchecked")
	public int selectCountkung_note_codeByParam(Map paramMap){ 
		return   Integer.parseInt(getSqlMapClientTemplate().queryForObject("selectCountkung_note_codeByParam",paramMap).toString()); 
	}

	/**
 * 更新 
 * @return 
 */ 
	public  Object updatekung_note_code(Kung_note_code kung_note_code){
		return  getSqlMapClientTemplate().update("updatekung_note_code",kung_note_code); 
	}

	/**
 * 添加 
 * @return
 */ 
	public  Object addkung_note_code(Kung_note_code kung_note_code){
		return  getSqlMapClientTemplate().insert("addkung_note_code",kung_note_code);
	}

	/**
 * 删除 
 * @return 
 */ 
	public  Object deletekung_note_code(String id){
		return  getSqlMapClientTemplate().delete("deletekung_note_code",id);
	}

}

