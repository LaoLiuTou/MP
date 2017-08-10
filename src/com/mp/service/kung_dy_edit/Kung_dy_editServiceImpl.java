package com.mp.service.kung_dy_edit;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.mp.dao.kung_dy_edit.IKung_dy_editDao;
import com.mp.model.kung_dy_edit.Kung_dy_edit;
public class Kung_dy_editServiceImpl  implements IKung_dy_editService {

	@Autowired
	private IKung_dy_editDao iKung_dy_editDao;
	/**
 * 通过id选取
 * @return
 */
 @Transactional
	public Kung_dy_edit selectkung_dy_editById(String id){
		return iKung_dy_editDao.selectkung_dy_editById(id);
	}

	/**
 * 通过查询参数获取信息
 * @return
 */ 
 @Transactional
	public List<Kung_dy_edit> selectkung_dy_editByParam(Map paramMap){ 
		return iKung_dy_editDao.selectkung_dy_editByParam(paramMap);
	}

	/**
	* 通过查询参数获取总条数
	 * @return
	 */ 
 @Transactional
	public int selectCountkung_dy_editByParam(Map paramMap){ 
		return iKung_dy_editDao.selectCountkung_dy_editByParam(paramMap);
	}

	/**
 * 更新 
 * @return 
 */ 
 @Transactional
	public  Object updatekung_dy_edit(Kung_dy_edit kung_dy_edit){
		return iKung_dy_editDao.updatekung_dy_edit(kung_dy_edit);
	}

	/**
 * 添加 
 * @return
 */ 
 @Transactional
	public  Object addkung_dy_edit(Kung_dy_edit kung_dy_edit){
		return iKung_dy_editDao.addkung_dy_edit(kung_dy_edit);
	}

	/**
 * 删除 
 * @return 
 */ 
 @Transactional
	public  Object deletekung_dy_edit(String id){
		return iKung_dy_editDao.deletekung_dy_edit(id);
	}

}

