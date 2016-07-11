package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.FollowUserMap;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.FollowUserMapManager;

@Service(value="followUserMapService")
public class FollowUserMapService {

	@Autowired
	private FollowUserMapManager followUserMapManager;
	
	
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2016-06-06 20:21
	 * @desc 添加关注
	 * **/
	public ResponseMessage<String> addFolloUser(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(paramMap.containsKey("followUserId") && (!StringUtils.isEmpty(paramMap.get("followUserId")))){
			Long followUserId=Long.valueOf(paramMap.get("followUserId").toString());
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			FollowUserMap followUserMap=followUserMapManager.getMyFollowUserByUserIdAndFolloUserId(userId, followUserId);
			if(null == followUserMap){
				followUserMapManager.insertSelective(followUserId, userId);
			}else{
				resData.setStatus(ExceptionConstants.followException.followSuccess.errorCode);
				resData.setMessage(ExceptionConstants.followException.followSuccess.errorMessage);
			}
		}else{
			resData.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			resData.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return resData;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-31 15:45
	 * @desc 获取我关注的用户
	 * **/
	public ResponseMessage<List<UserServiceInfo>> getMyFollowUseByUserId(Map<String,Object> paramMap){
		
		ResponseMessage<List<UserServiceInfo>> resData=new ResponseMessage<List<UserServiceInfo>>();
		
		if(paramMap.containsKey("userId")){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			List<UserServiceInfo> data=followUserMapManager.getMyFollowUser(userId);
			resData.setData(data);
		}else{
			resData.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			resData.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return resData;
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-31 15:45
	 * @desc 获取我关注的用户
	 * **/
	public ResponseMessage<List<UserServiceInfo>> getFollowUseByServerUserId(Map<String,Object> paramMap){
		
		ResponseMessage<List<UserServiceInfo>> resData=new ResponseMessage<List<UserServiceInfo>>();
		
		if(paramMap.containsKey("serverUserId")){
			Long serverUserId=Long.valueOf(paramMap.get("serverUserId").toString());
			List<UserServiceInfo> data=followUserMapManager.getMyFollowUser(serverUserId);
			resData.setData(data);
		}else{
			resData.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			resData.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return resData;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-06 20:44
	 * @desc 删除我关注的用户
	 * **/
	public ResponseMessage<String>  deleteMyFollowUser(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		if(
				paramMap.containsKey("userId")
			&& paramMap.containsKey("followUserId")
		 ){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			Long followUserId=Long.valueOf(paramMap.get("followUserId").toString());
			followUserMapManager.deleteMyFollowUser(userId, followUserId);
		}else{
			resData.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			resData.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return resData;
	}
	
}
