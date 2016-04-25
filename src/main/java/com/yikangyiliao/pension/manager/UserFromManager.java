package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UserFromDao;
import com.yikangyiliao.pension.entity.UserFrom;

@Component
public class UserFromManager {
	
	@Autowired
	private UserFromDao userFromDao;
	
	
	/**
	 *@author liushuaic
	 *@date 2015/11/16 15:18
	 *@desc 注册用户来源
	 * */
	public int insertSelective(UserFrom record){
		return userFromDao.insertSelective(record);
	}

	
	public int updateUserStatus1ByUserId(Long userId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("userId", userId);
		paramData.put("userStatus", 1);
		return userFromDao.updateUserStatusByUserId(paramData);
	}
	
	public int updateUserStatus0ByUserId(Long userId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("userId", userId);
		paramData.put("userStatus", 0);
		return userFromDao.updateUserStatusByUserId(paramData);
	}
	
	
	public UserFrom selectByPrimaryKey(Long userFromId){
		return userFromDao.selectByPrimaryKey(userFromId);
	}
	
	/**
     * @author liushuaic
     * @date 2015/11/17 15:55
     * @desc 查询用户来源 根据 userId
     * */
	public UserFrom selectByUserId(Long userId){
		return userFromDao.selectByUserId(userId);
	}
	
	
}
