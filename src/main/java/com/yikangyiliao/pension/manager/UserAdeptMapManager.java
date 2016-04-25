package com.yikangyiliao.pension.manager;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UserAdeptMapDao;
import com.yikangyiliao.pension.entity.UserAdeptMap;

@Component
public class UserAdeptMapManager {
	
	@Autowired
	private UserAdeptMapDao userAdeptMapDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-03-23 16:53
	 * @desc 删除用户的所有擅长
	 * */
	public int deleteUserAdeptAll(Long userId){
		return userAdeptMapDao.deleteUserAdeptAllByUserId(userId);
	}

	
	/**
	 * @author liushuaic
	 * @date 2016-03-23 16:58
	 * @desc 添加用户擅长
	 * */
	public int insertSelective(Long adeptId,Long userId){
		Long currentDateTime=Calendar.getInstance().getTimeInMillis();
		UserAdeptMap uam=new UserAdeptMap();
		uam.setAdeptId(adeptId);
		uam.setUserId(userId);
		uam.setCreateTime(currentDateTime);
		uam.setUpdateTime(currentDateTime);
		return userAdeptMapDao.insertSelective(uam);
	}
}
