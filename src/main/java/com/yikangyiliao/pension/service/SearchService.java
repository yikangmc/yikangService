package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.manager.TaglibManager;

@Service(value="searchService")
public class SearchService {
	
	@Autowired
	private TaglibManager taglibManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-04-26 14:23
	 * @desc 获取标签列表
	 * **/
	public ResponseMessage<List<Taglib>> getTaglibList(Map<String,Object> paramData){
		
		ResponseMessage<List<Taglib>> responseMessage=new ResponseMessage<List<Taglib>>();
		
		try{
			
			if(paramData.containsKey("tagName")){
				String tagName=paramData.get("tagName").toString();
				List<Taglib>  taglibs=taglibManager.getTaglibs(tagName);
				responseMessage.setData(taglibs);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return responseMessage;
		
	}
	

}
