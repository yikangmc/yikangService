package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Message;
import com.yikangyiliao.pension.manager.MessageManager;

@Service(value="messageService")
public class MessageService {
	
	
	@Autowired
	private MessageManager messageManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-25 14:12
	 * @desc 获取消息列表根据用户id
	 * */
	public ResponseMessage<List<Message>> getMessageAlert(Map<String,Object> paramMap){
		ResponseMessage<List<Message>> resData=new ResponseMessage<List<Message>>();
		
		if(paramMap.containsKey("userId")){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			List<Message> data=messageManager.getMessageListByUserId(userId);
			resData.setData(data);
		}
		return resData;
	}
	

}
