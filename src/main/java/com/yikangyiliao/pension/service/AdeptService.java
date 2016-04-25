package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Adept;
import com.yikangyiliao.pension.manager.AdeptManager;

@Service(value="adeptService")
public class AdeptService {

	
	@Autowired
	private AdeptManager adeptManager;
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-03-16 17:42
	 * @desc 获取某一类型的擅长
	 * **/
	public ResponseMessage getAdeptsByType(Map<String,Object> paramData){
		
		ResponseMessage responseMessage=new ResponseMessage();
		
		try{
			if(paramData.containsKey("userPosition")){
				String jobPosition=paramData.get("userPosition").toString();
				String userId=paramData.get("userId").toString();
				List<Adept> data=adeptManager.getAdeptsByTypeAndUserId(Long.valueOf(jobPosition),Long.valueOf(userId));
				responseMessage.setData(data);
				responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
				responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
				responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
			}

		}catch(Exception e){
			e.printStackTrace();
			responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return responseMessage;
	}
	
}
