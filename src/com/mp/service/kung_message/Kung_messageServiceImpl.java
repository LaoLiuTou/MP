package com.mp.service.kung_message;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.mp.dao.kung_message.IKung_messageDao;
import com.mp.model.kung_message.Kung_message;
public class Kung_messageServiceImpl  implements IKung_messageService {

	@Autowired
	private IKung_messageDao iKung_messageDao;
	/**
 * 通过id选取
 * @return
 */
 @Transactional
	public Kung_message selectkung_messageById(String id){
		return iKung_messageDao.selectkung_messageById(id);
	}

	/**
 * 通过查询参数获取信息
 * @return
 */ 
 @Transactional
	public List<Kung_message> selectkung_messageByParam(Map paramMap){ 
		return iKung_messageDao.selectkung_messageByParam(paramMap);
	}

	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
 @Transactional
	public int selectCountkung_messageByParam(Map paramMap){ 
		return iKung_messageDao.selectCountkung_messageByParam(paramMap);
	}

	/**
 * 更新 
 * @return 
 */ 
 @Transactional
	public  Object updatekung_message(Kung_message kung_message){
		return iKung_messageDao.updatekung_message(kung_message);
	}

	/**
 * 添加 
 * @return
 */ 
 @Transactional
	public  Object addkung_message(Kung_message kung_message){
		return iKung_messageDao.addkung_message(kung_message);
	}

	/**
 * 删除 
 * @return 
 */ 
 @Transactional
	public  Object deletekung_message(String id){
		return iKung_messageDao.deletekung_message(id);
	}

}

