package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.StoreUpDao;
import com.yikangyiliao.pension.entity.StoreUp;

@Component
public class StoreupManager {
	
	@Autowired
	private StoreUpDao storeUpDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-25 14:34
	 * @desc 添加文章收藏
	 * */
	public int addStoreupForumpost(Long forumPostId,Long userId){
		Date currretDate=Calendar.getInstance().getTime();
		StoreUp storeup=new StoreUp();
		storeup.setCreateUserId(userId);
		storeup.setForumPostId(forumPostId);
		storeup.setGroup(Byte.valueOf("0"));
		return storeUpDao.insertSelective(storeup);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-25 14:34
	 * @dasc 删除文章收藏
	 * **/
	public int deleteStreupForumpost(Long forumPostId,Long userId){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("forumPostId", forumPostId);
		paramMap.put("userId", userId);
		return storeUpDao.deleteForumpostStoreupByUserIdAndForumPostId(paramMap);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-25 15:33
	 * @desc 获取用户收藏
	 * */
	public List<StoreUp> getStoreupByUserId(Long userId){
		Map<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("userId", userId);
		return storeUpDao.getStoreupByUserId(paramMap);
	}
	
}
