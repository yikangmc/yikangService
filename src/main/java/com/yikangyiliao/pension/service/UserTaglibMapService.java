package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.manager.UserTaglibMapManager;

@Service(value="userTaglibMapService")
public class UserTaglibMapService{
	
	@Autowired
	private UserTaglibMapManager userTaglibMapManager;
	
	public ResponseMessage<String> addUserTaglibMap(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		if(
				paramMap.containsKey("userId")
				&& paramMap.containsKey("taglibId")
			){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			Long taglibId=Long.valueOf(paramMap.get("taglibId").toString());
			userTaglibMapManager.insertSelective(taglibId, userId);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
	}
	
	public ResponseMessage<String> deleteUserTaglibMap(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		if(
				paramMap.containsKey("userId")
				&& paramMap.containsKey("taglibId")
			){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			Long taglibId=Long.valueOf(paramMap.get("taglibId").toString());
			userTaglibMapManager.deleteTaglibByUserIdTaglibId(taglibId, userId);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		
		}
		return resData;
	}
	
	public ResponseMessage<List<Taglib>> getUserMyFollowTaglibByUserId(Map<String,Object> paramMap){
		ResponseMessage<List<Taglib>> resData=new ResponseMessage<List<Taglib>>();
		if(
				paramMap.containsKey("userId")
			){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			List<Taglib> taglibs=userTaglibMapManager.getMyFollowTaglibs(userId);
			resData.setData(taglibs);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-07-09 10:53
	 * @desc 获取某一个服务人员的所有关注者
	 * */
	public ResponseMessage<List<Taglib>> getUserMyFollowTaglibByServerUserId(Map<String,Object> paramMap){
		ResponseMessage<List<Taglib>> resData=new ResponseMessage<List<Taglib>>();
		if(
				paramMap.containsKey("serverUserId")
			){
			Long serverUserId=Long.valueOf(paramMap.get("serverUserId").toString());
			List<Taglib> taglibs=userTaglibMapManager.getMyFollowTaglibs(serverUserId);
			resData.setData(taglibs);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
	}
	
	
}
