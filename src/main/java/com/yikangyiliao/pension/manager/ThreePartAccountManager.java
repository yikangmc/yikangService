package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ThreePartAccountDao;
import com.yikangyiliao.pension.entity.ThreePartAccount;

/**
 * @author liushuaic
 * @date 2016-08-15 17:26
 * @desc 第三方登陆用户管理
 * **/
@Component
public class ThreePartAccountManager {
	
	@Autowired
	private ThreePartAccountDao threePartAccountDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-08-05 17:50
	 * @desc 添加第三方登陆
	 * **/
	public int insertSelective(String userName,String gender,String accountId,byte userSource,String threePartAccountInfo,Long userId){
		Date currentDate=Calendar.getInstance().getTime();
		ThreePartAccount threePartAccount=new ThreePartAccount();
		threePartAccount.setUserName(userName);
		threePartAccount.setGender(gender);
		threePartAccount.setAccountId(accountId);
		threePartAccount.setUserSource(userSource);
		threePartAccount.setThreePartAccountInfo(threePartAccountInfo);
		threePartAccount.setUserId(userId);
		threePartAccount.setCreateTime(currentDate);
		threePartAccount.setUpdateTime(currentDate);
		return threePartAccountDao.insertSelective(threePartAccount);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-08-08 16:31
	 * @desc 获取第三方用户信息
	 * **/
	public ThreePartAccount selectThreePartBaseColumnByAccountId(String accountId){
		return threePartAccountDao.selectThreePartBaseColumnByAccountId(accountId);
	}
}
