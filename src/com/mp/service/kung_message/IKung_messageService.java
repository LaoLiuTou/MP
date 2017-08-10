package com.mp.service.kung_message;
import java.util.List;
import java.util.Map;
import com.mp.model.kung_message.Kung_message;
public interface IKung_messageService {
/**
 * 通过id选取
 * @return
 */
public Kung_message selectkung_messageById(String id);
/**
 * 通过查询参数获取信息
 * @return
 */ 
public List<Kung_message> selectkung_messageByParam(Map paramMap); 
	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
	public int selectCountkung_messageByParam(Map paramMap); 
/**
 * 更新 
 * @return 
 */ 
public  Object updatekung_message(Kung_message kung_message);
/**
 * 添加 
 * @return
 */ 
public  Object addkung_message(Kung_message kung_message);
/**
 * 删除 
 * @return 
 */ 
public  Object deletekung_message(String id);

}

