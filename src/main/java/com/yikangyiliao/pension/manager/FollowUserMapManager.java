package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yikangyiliao.pension.dao.FollowUserMapDao;
import com.yikangyiliao.pension.entity.UserServiceInfo;

@Repository
public class FollowUserMapManager {
	
	@Autowired
	private FollowUserMapDao followUserMapDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 
	 * */
	public List<UserServiceInfo> getMyFollowUser(Long userId){
		
		return null;
	}
	

}
