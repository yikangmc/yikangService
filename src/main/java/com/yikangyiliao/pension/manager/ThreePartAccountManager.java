package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;

import com.yikangyiliao.pension.dao.ThreePartAccountDao;
import com.yikangyiliao.pension.entity.ThreePartAccount;

/**
 * @author liushuaic
 * @date 2016-08-15 17:26
 * @desc 第三方登陆用户管理
 * **/
public class ThreePartAccountManager {
	
	@Autowired
	private ThreePartAccountDao threePartAccountDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-08-05 17:50
	 * @desc 添加第三方登陆
	 * **/
	public int insertSelective(String userName,String gender,String accountId,byte userSource,String threePartAccountInfo){
		
		ThreePartAccount threePartAccount=new ThreePartAccount();
		threePartAccount.setUserName(userName);
		threePartAccount.setGender(gender);
		threePartAccount.setAccountId(accountId);
		threePartAccount.setUserSource(userSource);
		threePartAccount.setThreePartAccountInfo(threePartAccountInfo);
		return threePartAccountDao.insertSelective(threePartAccount);
	}
}
