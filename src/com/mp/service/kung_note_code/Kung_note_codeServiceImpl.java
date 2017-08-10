package com.mp.service.kung_note_code;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.mp.dao.kung_note_code.IKung_note_codeDao;
import com.mp.model.kung_note_code.Kung_note_code;
public class Kung_note_codeServiceImpl  implements IKung_note_codeService {

	@Autowired
	private IKung_note_codeDao iKung_note_codeDao;
	/**
 * 通过id选取
 * @return
 */
 @Transactional
	public Kung_note_code selectkung_note_codeById(String id){
		return iKung_note_codeDao.selectkung_note_codeById(id);
	}

	/**
 * 通过查询参数获取信息
 * @return
 */ 
 @Transactional
	public List<Kung_note_code> selectkung_note_codeByParam(Map paramMap){ 
		return iKung_note_codeDao.selectkung_note_codeByParam(paramMap);
	}

	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
 @Transactional
	public int selectCountkung_note_codeByParam(Map paramMap){ 
		return iKung_note_codeDao.selectCountkung_note_codeByParam(paramMap);
	}

	/**
 * 更新 
 * @return 
 */ 
 @Transactional
	public  Object updatekung_note_code(Kung_note_code kung_note_code){
		return iKung_note_codeDao.updatekung_note_code(kung_note_code);
	}

	/**
 * 添加 
 * @return
 */ 
 @Transactional
	public  Object addkung_note_code(Kung_note_code kung_note_code){
		return iKung_note_codeDao.addkung_note_code(kung_note_code);
	}

	/**
 * 删除 
 * @return 
 */ 
 @Transactional
	public  Object deletekung_note_code(String id){
		return iKung_note_codeDao.deletekung_note_code(id);
	}

}

