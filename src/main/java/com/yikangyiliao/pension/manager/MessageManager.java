package com.yikangyiliao.pension.manager;

import java.util.List;

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
	
	
	
}
