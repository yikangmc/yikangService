package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
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
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
    		resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-25 15:30
	 * @desc 获取信息详情
	 * */
	public ResponseMessage<Message> getMessageById(Map<String,Object> paramMap){
		ResponseMessage<Message> resData=new ResponseMessage<Message>();
		if(
				paramMap.containsKey("userId")
			&&  paramMap.containsKey("messagesId")
		){
			Long messagesId=Long.valueOf(paramMap.get("messagesId").toString());
			Message message=messageManager.getMessageById(messagesId);
			resData.setData(message);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return resData;
		
	}
	

}
