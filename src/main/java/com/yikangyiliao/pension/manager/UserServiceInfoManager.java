package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UserServiceInfoDao;

@Component
public class UserServiceInfoManager {

	
	@Autowired
	private UserServiceInfoDao userServiceInfoDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-03-21 18:38
	 * @desc 提交用户修改职位的申请
	 * **/
	public int submitUpdateUserPosition(Long userId,Long userPostion){
		
		Map<String,Object> paramData=new HashMap<String,Object>();
		
		return userServiceInfoDao.submitUpdateUserPosition(paramData);
	}
	
	
}
