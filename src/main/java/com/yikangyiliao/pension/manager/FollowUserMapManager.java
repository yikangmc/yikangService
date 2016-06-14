package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yikangyiliao.pension.dao.FollowUserMapDao;
import com.yikangyiliao.pension.dao.UserServiceInfoDao;
import com.yikangyiliao.pension.entity.FollowUserMap;
import com.yikangyiliao.pension.entity.UserServiceInfo;

@Repository
public class FollowUserMapManager {
	
	@Autowired
	private FollowUserMapDao followUserMapDao;
	
	@Autowired
	private UserServiceInfoDao userServiceInfoDao;
	
	/**
	 * @author liushuaic
	 * @date  2016-06-06 20:18
	 * @desc  查询我关注的用户
	 * */
	public List<UserServiceInfo> getMyFollowUser(Long userId){
		return	userServiceInfoDao.getMyFollowUser(userId);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-06 20:34
	 * @desc 添加我的关注
	 * **/
	public int insertSelective(Long followUserId,Long userId){
		FollowUserMap followUserMap=new FollowUserMap();
		followUserMap.setFollowUserId(followUserId);
		followUserMap.setCreateUserId(userId);
		followUserMap.setCreateTime(Calendar.getInstance().getTime());
		followUserMap.setUpdateTime(Calendar.getInstance().getTime());
		return followUserMapDao.insertSelective(followUserMap);
	} 
	
	  /**
     * @author liushuaic
     * @date 2016-06-06 20:31
     * @desc 删除我关注的用户
     * ***/
	public int deleteMyFollowUser(Long userId,Long followUserId){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("createUserId", userId);
		paramMap.put("followUserId", followUserId);
		return followUserMapDao.deleteMyFollowUser(paramMap);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-08 10:22
	 * @desc 获取我关注的记录
	 * */
	public FollowUserMap getMyFollowUserByUserIdAndFolloUserId(Long userId,Long followUserId){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("createUserId", userId);
		paramMap.put("followUserId", followUserId);
		return followUserMapDao.getMyFollowUserByUserIdAndFolloUserId(paramMap);
	}
	
}
