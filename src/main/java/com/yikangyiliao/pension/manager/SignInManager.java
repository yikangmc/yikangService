package com.yikangyiliao.pension.manager;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SignInDao;
import com.yikangyiliao.pension.entity.SignIn;

@Component
public class SignInManager {

	@Autowired
	private SignInDao signInDao;
	
	/**
	 * 签到积分增加
	 * @param record
	 * @return
	 */
	public int insertSignDao(SignIn record){
		int score = new Random().nextInt(5)+5;
		Date date = new Date();
		record.setScore(score);
		record.setCreateDatetime(date);
		record.setUpdateDatetime(date);
		return signInDao.insertSelective(record);
	}
	
	
}
