package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.StoreUp;
import com.yikangyiliao.pension.manager.StoreupManager;

@Service(value="storeupService")
public class StoreupService {

	
	@Autowired
	private StoreupManager storeupManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-25 15:54
	 * @desc 获取一个用户的收藏列表
	 * **/
	public ResponseMessage<List<StoreUp>> getStoreupsByUserId(Map<String,Object> paramMap){
		
		ResponseMessage<List<StoreUp>> resData=new ResponseMessage<List<StoreUp>>();
		
		if(paramMap.containsKey("userId")){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			List<StoreUp> storeups=storeupManager.getStoreupByUserId(userId);
			resData.setData(storeups);
		}
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-25 16:03
	 * @desc 删除收藏
	 * */
	public ResponseMessage<String> deleteStoreups(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		if(paramMap.containsKey("forumPostId")){
			Long forumPostId=Long.valueOf(paramMap.get("forumPostId").toString());
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			storeupManager.deleteStreupForumpost(forumPostId, userId);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
		
	}

	

	/**
	 * @author liushuaic
	 * @date 2016-05-25 16:16
	 * @desc 添加用户收藏
	 * */
	public ResponseMessage<String> addFourmpostStoreup(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(
				paramMap.containsKey("forumPostId")
			&& paramMap.containsKey("userId")
		 ){
			Long forumPostId=Long.valueOf(paramMap.get("forumPostId").toString());
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			
			StoreUp storeup=storeupManager.getStoreupByUserIdAndForumPostId(forumPostId,userId);
			if(null == storeup){
				storeupManager.addStoreupForumpost(forumPostId, userId);
			}else{
				resData.setStatus(ExceptionConstants.followException.isFollowed.errorCode);
				resData.setMessage(ExceptionConstants.followException.isFollowed.errorMessage);
			}
		}else{
			resData.setStatus(ExceptionConstants.followException.followSuccess.errorCode);
			resData.setMessage(ExceptionConstants.followException.followSuccess.errorMessage);
		}
		return resData;
	}
	
	
	
	
	
	
}
