package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.dao.ForumPostsAnswerDao;
import com.yikangyiliao.pension.entity.ForumPostsAnswer;

@Component
public class ForumPostsAnswerManager {
	
	
	@Autowired
	private ForumPostsAnswerDao forumPostsAnswerDao;
	
	@Autowired
	private IntegralManager integralManager;
	
	
	
	public int insertSelective(ForumPostsAnswer record){
		return forumPostsAnswerDao.insert(record);
	}

	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-04-28 16:22
	 * @desc 添加回复
	 * **/
	public ForumPostsAnswer insertSelective(String content,Long createUserId,Long formPostId,Long toUserId,Byte answerTo){
		Date currentDate=Calendar.getInstance().getTime();
		ForumPostsAnswer record=new ForumPostsAnswer();
		record.setContent(content);
		record.setCreateUserId(createUserId);
		record.setFormPostId(formPostId);
		record.setToUserId(toUserId);
		record.setAnswerTo(answerTo);
		record.setCreateTime(currentDate);
		forumPostsAnswerDao.insertSelective(record);
		
		integralManager.insertIntegralAddScoreIsONCEJob("CCPL",Long.valueOf(createUserId));
		integralManager.insertIntegralAddScoreIsUsualJob("PLTZ",Byte.valueOf("2"),Long.valueOf(createUserId));

		return record;
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-04-28 19:22
	 * @desc 获取某一个文章的所有回答
	 * 
	 * */
	public List<ForumPostsAnswer> getForumPostsAnswersByFormPostId(Long forumPostsId){
		return forumPostsAnswerDao.getForumPostsAnswersByFormPostId(forumPostsId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-08-01 14:52
	 * @desc 获取回复详情
	 * **/
	public ForumPostsAnswer getForumpostsAnswerByAnswerId(Long forumPostsAnswerId){
		return forumPostsAnswerDao.selectByPrimaryKey(forumPostsAnswerId);
	}
	
}