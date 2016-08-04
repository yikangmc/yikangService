package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.MessageDao;
import com.yikangyiliao.pension.entity.Message;

@Component
public class MessageManager {

	@Autowired
	private MessageDao messageDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-25 14:08
	 * @desc 获取信息列表
	 * **/
	public List<Message> getMessageListByUserId(Long userId){
		return messageDao.getMessageByToUserId(userId);
	}
	

	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-26 15:26
	 * @desc 获取信息详情
	 * **/
	public Message getMessageById(Long messagesId){
		return messageDao.selectByPrimaryKey(messagesId);
	}
	
	/***
	 * @author liushuaic
	 * @date 2016-06-07 10:12
	 * @desc 获取系统消息
	 * */
	
	public List<Message> getSystemMessageByUserId(Long userId){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("messageGroup",0);
		paramMap.put("userId",userId);
		return messageDao.getMessageByMessageGroupAndUserId(paramMap);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-07 10:13
	 * @desc 获取动态信息
	 * */
	public List<Message> getDynamicMessageByUserId(Long userId){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("messageGroup",1);
		paramMap.put("userId",userId);
		return messageDao.getMessageByMessageGroupAndUserId(paramMap);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-12 13:51
	 * @desc 添加的新的关注动态
	 * @param messageGroup
	 * 消息内容分类（
		1：问题被接答
		2：帖子被认同
		3：帖子被评论
		4：新的关注信息
		）
		@param contentGroup
		消息分类（
				0：系统消息
				1：动态通知
				2.：私信消息
		）
		
	 * */
	public int insertDynamicFollowMessage(Long fromUserId,Long toUserId,String title,String content,Long dataId,Byte contentGroup){
		Date currentDateTime=Calendar.getInstance().getTime();
		Message message=new Message();
		message.setCreateTime(currentDateTime);
		message.setFromUserId(fromUserId);
		message.setToUserId(toUserId);
		message.setTitle(title);
		message.setContent(content);
		message.setIsRead(Byte.valueOf("0"));
		message.setUpdateTime(currentDateTime);
		message.setContentGroup(contentGroup);
		message.setMessageGroup(Byte.valueOf("1")); 
		message.setCreateTimeMillisecond(currentDateTime.getTime());
		message.setDataId(dataId);
		return	messageDao.insertSelective(message);
	}
	
	
	
	
}
