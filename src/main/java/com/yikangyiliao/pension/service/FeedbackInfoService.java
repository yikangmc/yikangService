package com.yikangyiliao.pension.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.FeedbackInfo;
import com.yikangyiliao.pension.manager.FeedbackInfoManager;

@Service("feedbackInfoService")
public class FeedbackInfoService {
	@Autowired
	private FeedbackInfoManager feedbackInfoManager;
	
	public ResponseMessage<Integer> insertFeedbackData(Map<String ,Object> paramMap){
		ResponseMessage<Integer> resData=new ResponseMessage<Integer>();
		Date date = new Date();
		if(paramMap!=null){
			FeedbackInfo info = new FeedbackInfo();
			info.setImage("-2");
			info.setCreateUserId(-2L);
			info.setConnectMethod("-2");
			info.setProcessTime(date);
			info.setProcessUserId(-2L);
			info.setProcessStatus(Byte.valueOf("-2"));
			if(paramMap.containsKey("content")){
				String content = paramMap.get("content").toString();
				info.setContent(content);
				if(paramMap.get("image")!=null&&paramMap.get("image").toString().length()>1){
					String image = paramMap.get("image").toString();
					info.setImage(image);
				}
				if(paramMap.get("createUserId")!=null&&paramMap.get("createUserId").toString().length()>1){
					String createUserId = paramMap.get("createUserId").toString();
					info.setCreateUserId(Long.valueOf(createUserId));
				}
				if(paramMap.get("connectMethod")!=null&&paramMap.get("connectMethod").toString().length()>1){
					String connectMethod = paramMap.get("connectMethod").toString();
					info.setConnectMethod(connectMethod);
				}
				info.setCreateTime(date);
				info.setUpdateTime(date);
				Integer data = feedbackInfoManager.insertFeedbackData(info);
				resData.setData(data);
			}else{
				resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
				resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
			}
			
		}
		return resData;
	}
}
