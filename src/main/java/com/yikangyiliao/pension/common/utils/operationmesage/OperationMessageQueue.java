package com.yikangyiliao.pension.common.utils.operationmesage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liushuaic
 * @date 2016-06-06 12:10
 * @desc 业务信息发送队列
 * **/
public class OperationMessageQueue {

	private static BlockingQueue<OperationMessage> messageQueues=new LinkedBlockingQueue<OperationMessage>();
	
	private static Logger logger=LoggerFactory.getLogger(OperationMessageQueue.class);
	
	
	public static void putMessage(OperationMessage operationMessage){
		try {
			messageQueues.put(operationMessage);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-06 15:20
	 * @desc 获取信息，阻塞
	 * */
	public static OperationMessage takeMessage(){
		try {
			return messageQueues.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-13 10:40
	 * @desc 文章支持队列
	 * */
	private static BlockingQueue<OperationMessage> forumPostStarQueues=new LinkedBlockingQueue<OperationMessage>();
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-13 10:42
	 * @desc 添加文章支持推送
	 * */
	public static void putForumPostStarMessage(OperationMessage operationMessage){
		try {
			forumPostStarQueues.put(operationMessage);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-13 10:46
	 * @desc 获取文章的支持信息
	 * */
	public static OperationMessage takeForumPostStarMessage(){
		try {
			return forumPostStarQueues.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-13 10:40
	 * @desc 问题回答队列
	 * */
	private static BlockingQueue<OperationMessage> questionAnswerQueues=new LinkedBlockingQueue<OperationMessage>();
	
	
	public static void putQuestionAnswerMessage(OperationMessage operationMessage){
		try {
			questionAnswerQueues.put(operationMessage);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-13 10:56
	 * @desc 获取问题回答
	 * */
	public static OperationMessage getQuestionAnswerMessage(){
		try {
			return questionAnswerQueues.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	/**
	 * @author liushuaic
	 * @date 2016-06-13 10:40
	 * @desc 帖子回答队列
	 * */
	private static BlockingQueue<OperationMessage> tzForumPostsAnswerQueues=new LinkedBlockingQueue<OperationMessage>();
	
	
	public static void putTZForumPostsAnswerQueues(OperationMessage operationMessage){
		try{
			tzForumPostsAnswerQueues.put(operationMessage);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-07-05 17:48
	 * @desc 获取所有的回答
	 * */
	public static OperationMessage takeTZForumPostsAnswerQueues(){
		try{
			return tzForumPostsAnswerQueues.take();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-08-01 13:59
	 * @desc 添加文章信息回复队列
	 * **/
	public static BlockingQueue<OperationMessage> forumPostsAnswerQueues=new LinkedBlockingQueue<OperationMessage>();
	
	public static void putForumPostsAnswerToQueue(OperationMessage operationMessage){
		logger.info("forumPostsAnswerQueues -->putForumPostsAnswerToQueue-->info--> "+operationMessage.getContent());
		try {
			forumPostsAnswerQueues.put(operationMessage);
		} catch (InterruptedException e) {
			logger.error("forumPostsAnswerQueues -->putForumPostsAnswerToQueue-->error:"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-08-01 14:14
	 * @desc 获取文章回复
	 * **/
	public static OperationMessage takeForumPostsAnswer(){
		try {
			logger.info("forumPostsAnswerQueues-->takeForumPostsAnswer-->info:getMessage");
			return forumPostsAnswerQueues.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.error("forumPostsAnswerQueues-->takeForumPostsAnswer-->error:"+e.getMessage());
		}
		return null;
		
	}
	
}
