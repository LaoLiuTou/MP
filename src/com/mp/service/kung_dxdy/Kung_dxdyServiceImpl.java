package com.mp.service.kung_dxdy;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.mp.dao.kung_dxdy.IKung_dxdyDao;
import com.mp.model.kung_dxdy.Kung_dxdy;
public class Kung_dxdyServiceImpl  implements IKung_dxdyService {

	@Autowired
	private IKung_dxdyDao iKung_dxdyDao;
	/**
 * 通过id选取
 * @return
 */
 @Transactional
	public Kung_dxdy selectkung_dxdyById(String id){
		return iKung_dxdyDao.selectkung_dxdyById(id);
	}

	/**
 * 通过查询参数获取信息
 * @return
 */ 
 @Transactional
	public List<Kung_dxdy> selectkung_dxdyByParam(Map paramMap){ 
		return iKung_dxdyDao.selectkung_dxdyByParam(paramMap);
	}

	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
 @Transactional
	public int selectCountkung_dxdyByParam(Map paramMap){ 
		return iKung_dxdyDao.selectCountkung_dxdyByParam(paramMap);
	}

	/**
 * 更新 
 * @return 
 */ 
 @Transactional
	public  Object updatekung_dxdy(Kung_dxdy kung_dxdy){
		return iKung_dxdyDao.updatekung_dxdy(kung_dxdy);
	}

	/**
 * 添加 
 * @return
 */ 
 @Transactional
	public  Object addkung_dxdy(Kung_dxdy kung_dxdy){
		return iKung_dxdyDao.addkung_dxdy(kung_dxdy);
	}

	/**
 * 删除 
 * @return 
 */ 
 @Transactional
	public  Object deletekung_dxdy(String id){
		return iKung_dxdyDao.deletekung_dxdy(id);
	}

}

