package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ForumPostsImageDao;
import com.yikangyiliao.pension.entity.ForumPostsImage;

@Component
public class ForumPostsImageManager {
	
	@Autowired
	private ForumPostsImageDao forumPostsImageDao;

	
	/**
	 * @author liushuaic
	 * @date 2015-05-06 18:44
	 * @desc 
	 * */
	public int insertSelective(ForumPostsImage record){
		return forumPostsImageDao.insert(record);
	}
	
	
}
