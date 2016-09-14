package com.yikangyiliao.pension.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.UserConfigration;
import com.yikangyiliao.pension.manager.UserConfigrationManager;

@Service(value="userConfigrationService")
public class UserConfigrationService {
	
	@Autowired
	private UserConfigrationManager userConfigrationManager;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-20 15:50
	 * @desc 获取用户配置信息
	 * */
	public ResponseMessage<UserConfigration> getUserConfigrationByUserId(Map<String,Object> paramMap){

		ResponseMessage<UserConfigration> resData=new ResponseMessage<UserConfigration>();
		
		if(paramMap.containsKey("userId")){
			
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			UserConfigration uc=userConfigrationManager.getUserConfigration(userId);
			
			resData.setData(uc);
			
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
		
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-20 16:27
	 * @desc 修改用户配置
	 * */
	public ResponseMessage<String> updateUserConfigration(Map<String,Object> paramMap){
		
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(
			   paramMap.containsKey("systemAlert")
			&& paramMap.containsKey("dynamicAlert")
		){
			Integer systemAlert=Integer.valueOf(paramMap.get("systemAlert").toString());
			Integer dynamicAlert=Integer.valueOf(paramMap.get("dynamicAlert").toString());
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			userConfigrationManager.updateUserConfigration(systemAlert, dynamicAlert, userId);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return resData;
	}
	
}
