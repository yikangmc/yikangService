package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UpdateVersionDao;
import com.yikangyiliao.pension.entity.UpdateVersion;

@Component
public class UpdateVersionManager {

	@Autowired
	private UpdateVersionDao updateVersionDao;
	
	/**
	 * 获取版本信息
	 * @param updateVersionId
	 * @return
	 */
	public UpdateVersion getUpdateVersionByMobilePhoneType(Map<String, Object> mobilePhoneType){
		return updateVersionDao.getUpdateVersionByMobilePhoneType(mobilePhoneType);
	} 
	
	/**
	 * 删除版本信息
	 * @param updateVersionId
	 * @return
	 */
	public int deleteUpdateVersionByVersionId(Long updateVersionId){
		return updateVersionDao.deleteByPrimaryKey(updateVersionId);
	}
	
	/**
	 * 添加版本信息
	 * @param updateVersion
	 * @return
	 */
	public int insertUpdateVersionByVersionId(UpdateVersion updateVersion){
		return updateVersionDao.insert(updateVersion);
	}
	
	public int updateVersionByVersionId(UpdateVersion updateVersion){
		return updateVersionDao.updateByPrimaryKey(updateVersion);
	}
	
}
