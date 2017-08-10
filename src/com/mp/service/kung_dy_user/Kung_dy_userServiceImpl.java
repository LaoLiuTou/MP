package com.mp.service.kung_dy_user;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.mp.dao.kung_dy_user.IKung_dy_userDao;
import com.mp.model.kung_dy_user.Kung_dy_user;
public class Kung_dy_userServiceImpl  implements IKung_dy_userService {

	@Autowired
	private IKung_dy_userDao iKung_dy_userDao;
	/**
 * 通过id选取
 * @return
 */
 @Transactional
	public Kung_dy_user selectkung_dy_userById(String id){
		return iKung_dy_userDao.selectkung_dy_userById(id);
	}

	/**
 * 通过查询参数获取信息
 * @return
 */ 
 @Transactional
	public List<Kung_dy_user> selectkung_dy_userByParam(Map paramMap){ 
		return iKung_dy_userDao.selectkung_dy_userByParam(paramMap);
	}

	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
 @Transactional
	public int selectCountkung_dy_userByParam(Map paramMap){ 
		return iKung_dy_userDao.selectCountkung_dy_userByParam(paramMap);
	}

	/**
 * 更新 
 * @return 
 */ 
 @Transactional
	public  Object updatekung_dy_user(Kung_dy_user kung_dy_user){
		return iKung_dy_userDao.updatekung_dy_user(kung_dy_user);
	}

	/**
 * 添加 
 * @return
 */ 
 @Transactional
	public  Object addkung_dy_user(Kung_dy_user kung_dy_user){
		return iKung_dy_userDao.addkung_dy_user(kung_dy_user);
	}

	/**
 * 删除 
 * @return 
 */ 
 @Transactional
	public  Object deletekung_dy_user(String id){
		return iKung_dy_userDao.deletekung_dy_user(id);
	}

}

