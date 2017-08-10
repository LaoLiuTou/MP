package com.mp.service.kung_note_code;
import java.util.List;
import java.util.Map;
import com.mp.model.kung_note_code.Kung_note_code;
public interface IKung_note_codeService {
/**
 * 通过id选取
 * @return
 */
public Kung_note_code selectkung_note_codeById(String id);
/**
 * 通过查询参数获取信息
 * @return
 */ 
public List<Kung_note_code> selectkung_note_codeByParam(Map paramMap); 
	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
	public int selectCountkung_note_codeByParam(Map paramMap); 
/**
 * 更新 
 * @return 
 */ 
public  Object updatekung_note_code(Kung_note_code kung_note_code);
/**
 * 添加 
 * @return
 */ 
public  Object addkung_note_code(Kung_note_code kung_note_code);
/**
 * 删除 
 * @return 
 */ 
public  Object deletekung_note_code(String id);

}

