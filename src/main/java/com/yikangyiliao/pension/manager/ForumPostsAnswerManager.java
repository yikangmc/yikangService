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
	
	
	
	public int insertSelective(ForumPostsAnswer record){
		return forumPostsAnswerDao.insert(record);
	}

	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-04-28 16:22
	 * @desc 添加回复
	 * **/
	public int insertSelective(String content,Long createUserId,Long formPostId,Long toUserId,Byte answerTo){
		Date currentDate=Calendar.getInstance().getTime();
		ForumPostsAnswer record=new ForumPostsAnswer();
		record.setContent(content);
		record.setCreateUserId(createUserId);
		record.setFormPostId(formPostId);
		record.setToUserId(toUserId);
		record.setAnswerTo(answerTo);
		record.setCreateTime(currentDate);
		int rowCount= forumPostsAnswerDao.insertSelective(record);
		//推送信息
				OperationMessage operationMessage=new OperationMessage();
				operationMessage.setContent(record.getForumPostsAnswerId()+"");  //设置问题id
				operationMessage.setContentType(2+"");    //设置分类id
				OperationMessageQueue.putForumPostsAnswerToQueue(operationMessage);
		return rowCount;
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