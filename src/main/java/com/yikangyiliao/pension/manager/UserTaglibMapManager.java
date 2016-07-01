package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.TaglibDao;
import com.yikangyiliao.pension.dao.UserTaglibMapDao;
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.entity.UserTaglibMap;

@Component
public class UserTaglibMapManager {
	
	@Autowired
	private UserTaglibMapDao userTaglibMapDao;
	
	@Autowired
	private TaglibDao taglibDao;
	 
	
	/**
	 * @author liushuaic
	 * @date 2016-06-06 21:00
	 * @desc 添加我关注的标签
	 * */
	public int insertSelective(Long taglibId,Long userId){
		Date currentDate=Calendar.getInstance().getTime();
		UserTaglibMap userTaglibMap=new UserTaglibMap();
		userTaglibMap.setTaglibId(taglibId);
		userTaglibMap.setCreateTime(currentDate);
		userTaglibMap.setUpdateTime(currentDate);
		userTaglibMap.setCreateUserId(userId);
		userTaglibMapDao.insertSelective(userTaglibMap);
		taglibDao.updateFollowNumberAddByTaglibId(taglibId);
		return 1;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-06 21:04
	 * @desc 删除我关注的标签
	 * **/
	public int deleteTaglibByUserIdTaglibId(Long taglibId,Long userId){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("taglibId", taglibId);
		paramMap.put("userId", userId);
		userTaglibMapDao.deleteUserTaglibMapByUserIdTaglibId(paramMap);
		taglibDao.updateFollowNumberSubByTaglibId(taglibId);
		return 1;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-06 21:04
	 * @desc 查询我关注的标签
	 * */
	public List<Taglib> getMyFollowTaglibs(Long userId){
		return taglibDao.getMyWatchTaglibsByUserid(userId);
	}
	
	 /**
     * @author liushuaic
     * @date 2016-06-06 21:20
     * @desc 查询我关注的某一个标签
     * @param userId
     * @param taglibId
     * **/
	public UserTaglibMap selectUserTaglibMapByUserIdTaglibId(Long taglibId,Long userId){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("taglibId", taglibId);
		paramMap.put("userId", userId);
    	return userTaglibMapDao.selectUserTaglibMapByUserIdTaglibId(paramMap);
    }
	

}
