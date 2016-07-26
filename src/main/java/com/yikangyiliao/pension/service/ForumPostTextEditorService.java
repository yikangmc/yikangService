package com.yikangyiliao.pension.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.ForumPostTxtEditor;
import com.yikangyiliao.pension.manager.ForumPostTextEditorManager;

@Service(value="forumPostTextEditorService")
public class ForumPostTextEditorService {
	
	@Autowired
	private ForumPostTextEditorManager forumPostTextEditorManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-07-19 18:33
	 * */
	public ResponseMessage<String> updateForumPostTxtEditorOwnUserIdByUniqueCode(Map<String,Object> paramMap){
		
		ResponseMessage<String> responseMessage=new ResponseMessage<String>();
		if(
			paramMap.containsKey("userId")
			&&  paramMap.containsKey("uniqueCode")
			&&  paramMap.containsKey("editorType")
		){
			Byte editorType=Byte.valueOf(paramMap.get("editorType").toString());
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			String uniqueCode=paramMap.get("uniqueCode").toString();
			int row=forumPostTextEditorManager.updateForumPostTxtEditorOwnUserIdEditorTypeByUniqueCode(userId,editorType, uniqueCode);
			if(row==0){
				responseMessage.setStatus(ExceptionConstants.forumPostTextEditException.unquieCodeIsOverdue.errorCode);
				responseMessage.setMessage(ExceptionConstants.forumPostTextEditException.unquieCodeIsOverdue.errorMessage);
			}
		}else{
			responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return responseMessage;
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016
	 * **/
	public  ResponseMessage<String> insertForumPostText(Map<String,Object> paramMap){
		
		ResponseMessage<String> responseMessage=new ResponseMessage<String>();
		
		if(
			paramMap.containsKey("uniqueCode")
		){
			
			String uniqueCode=paramMap.get("uniqueCode").toString();
			forumPostTextEditorManager.insertSelective(uniqueCode);
			
			
		}else{
			responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return responseMessage;
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-07-22 14:09
	 * @desc 根据唯一码获取一个未过期的记录
	 * */
	public ResponseMessage<ForumPostTxtEditor> getForumPostTextByUniqueCode(Map<String,Object> paramMap){

		ResponseMessage<ForumPostTxtEditor> responseMessage=new ResponseMessage<ForumPostTxtEditor>();
		
		if(
			paramMap.containsKey("uniqueCode")
		){
			
			String uniqueCode=paramMap.get("uniqueCode").toString();
			ForumPostTxtEditor forumPostTxtEditor=forumPostTextEditorManager.getForumPostTxtEditorByUniquecode(uniqueCode);
			responseMessage.setData(forumPostTxtEditor);
		}else{
			responseMessage.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			responseMessage.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return responseMessage;
	}
	
	

}
