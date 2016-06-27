package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ForumPostDetailDao;
import com.yikangyiliao.pension.entity.ForumPostDetail;

@Component
public class ForumPostDetailManager {

	@Autowired
	private ForumPostDetailDao forumPostDetailDao;
	
	/**
	 * @author liushuaic
	 * @date 2016-06-22 17:32
	 * @desc 添加文章
	 * **/
	public int insertSelective(String forumPostDetailContent,String forumPostHtmlDetailContent){
		ForumPostDetail forumPostDetail=new ForumPostDetail();
		forumPostDetail.setForumPostDetailContent(forumPostDetailContent);
		forumPostDetail.setForumPostHtmlDetailContent(forumPostHtmlDetailContent);
		return forumPostDetailDao.insertSelective(forumPostDetail);
	}
	
}
