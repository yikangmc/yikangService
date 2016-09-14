package com.yikangyiliao.base.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.yikangyiliao.base.utils.messageUtil.im.MessageThreads;
import com.yikangyiliao.pension.message.ForumPostAnswerMsgOperation;
import com.yikangyiliao.pension.message.ForumPostStarOperation;
import com.yikangyiliao.pension.message.ForumPostsMsgOpration;
import com.yikangyiliao.pension.message.QuestionAnswerCommentOperation;
import com.yikangyiliao.pension.message.QuestionAnswerMsgOperation;
import com.yikangyiliao.pension.message.QuestionStarOperation;


/**
 * @author liushuaic
 * @date 2015/10/10 10:41
 * @desc 加载一些基本的信息
 * 队列容器，是需要，在一个单独的地方存储的。
 * 这样才不会出现，问题。
 * **/
public class PorpertiesLonder implements ApplicationContextAware {

	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		
//		PersonnelDistribution personnelDistribution=applicationContext.getBean(PersonnelDistribution.class);
//		Thread thread=new Thread(personnelDistribution);
//		thread.start();
		
		/**
		 * @author liushuaic
		 * @date 2015/12/08 11:49 信息推送
		 * **/
		MessageThreads messageThreads =new MessageThreads();
		messageThreads.startSendMessage();
		
//		起动异步通知功能
//		ForumPostsMsgOpration forumPostsMsgOpration=new ForumPostsMsgOpration();
		ForumPostsMsgOpration forumPostsMsgOpration=(ForumPostsMsgOpration) ApplicationContextUtil.applicationContext.getBean("forumPostsMsgOpration");
		Thread forumThread=new Thread(forumPostsMsgOpration);
		forumThread.start();
		
		//问题回复
		QuestionAnswerMsgOperation questionAnswerMsgOperation=(QuestionAnswerMsgOperation) ApplicationContextUtil.applicationContext.getBean("questionAnswerMsgOperation");
		Thread questionAnswerMsgOperationThread=new Thread(questionAnswerMsgOperation);
		questionAnswerMsgOperationThread.start();
		
		
		//支持
		ForumPostStarOperation forumPostStarOperation=(ForumPostStarOperation) ApplicationContextUtil.applicationContext.getBean("forumPostStarOperation");
		Thread forumPostStarOperationThread=new Thread(forumPostStarOperation);
		forumPostStarOperationThread.start();
		
		//文章，帖子评论支持
		ForumPostAnswerMsgOperation forumPostAnswerMsgOperation=(ForumPostAnswerMsgOperation) ApplicationContextUtil.applicationContext.getBean("forumPostAnswerMsgOperation");
		Thread forumPostAnswerMsgOperationThread=new Thread(forumPostAnswerMsgOperation);
		forumPostAnswerMsgOperationThread.start();
		
		
		//专家解答的评论
		QuestionAnswerCommentOperation questionAnswerCommentOperation = (QuestionAnswerCommentOperation) applicationContext.getBean("questionAnswerCommentOperation");
		Thread questionAnswerCommentOperationThread = new Thread(questionAnswerCommentOperation);
		questionAnswerCommentOperationThread.start();
		
		
		//专家解答的评论
		QuestionStarOperation questionStarOperationRunable = (QuestionStarOperation) applicationContext.getBean("questionStarOperation");
		Thread questionStarOperationThread = new Thread(questionStarOperationRunable);
		questionStarOperationThread.start();
		
		
		
	}

}
