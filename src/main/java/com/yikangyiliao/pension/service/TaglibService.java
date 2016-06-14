package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.manager.TaglibManager;

@Service(value="taglibService")
public class TaglibService {

	
	@Autowired
	private TaglibManager taglibManager;
	
	
	private Logger logger=LoggerFactory.getLogger(TaglibService.class);
	
	/**
	 * @author liushuaic
	 * @date 2016-05-11 17:23
	 * @desc 获取推荐的2级列表
	 * */
	public ResponseMessage<List<Taglib>> getRecommendTaglib(Map<String,Object> paramMap){
		
		ResponseMessage<List<Taglib>> resData=new ResponseMessage<List<Taglib>>();
		
		List<Taglib> taglibs=taglibManager.getRecommendTaglib();
		
		resData.setData(taglibs); 
		
		return resData;
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-12 14:44
	 * @desc 获取一级标签列表
	 * */
	public ResponseMessage<List<Taglib>> getFristTaglib(Map<String,Object> paramMap){
		ResponseMessage<List<Taglib>> resData=new ResponseMessage<List<Taglib>>();
		
		List<Taglib> taglibs=taglibManager.getFristTaglib();
		resData.setData(taglibs);
		
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-12 14:46
	 * @desc 获取二级标签列表
	 * **/
	public ResponseMessage<List<Taglib>> getSecondTaglibByParentId(Map<String,Object> paramMap){
		
		ResponseMessage<List<Taglib>> resData=new ResponseMessage<List<Taglib>>();
		
		if(paramMap.containsKey("parentId")){
			
			Long parentId=Long.valueOf(paramMap.get("parentId").toString());
			
			Long userId=null;
			if(paramMap.containsKey("userId")){
				userId=Long.valueOf(paramMap.get("userId").toString());
			}
			
			List<Taglib> tags= taglibManager.getSecondTaglibByParentId(parentId,userId);
			resData.setData(tags);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
	}
	
	 /**
     * @author liushuaic
     * @date 2016-05-19 16:03
     * @desc 获取所有的标签
     * */
	public ResponseMessage<List<Taglib>> getAllTag(Map<String,Object> paramMap){
		
		ResponseMessage<List<Taglib>> resData=new ResponseMessage<List<Taglib>>();
		try{
			Long userId=null;
			if(paramMap.containsKey("userId")){
				userId=Long.valueOf(paramMap.get("userId").toString());
			}
			List<Taglib> data=taglibManager.getAllTag(userId);
			resData.setData(data);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-31 17:13
	 * @desc 获取我关注的标签
	 * */
	public ResponseMessage<List<Taglib>> getMyWatchTaglibsByUserid(Map<String,Object> paramData){
		ResponseMessage<List<Taglib>> resData=new ResponseMessage<List<Taglib>>();
		try{
			if(paramData.containsKey("userId") && !StringUtils.isEmpty(paramData.get("userId"))){
				Long userId=Long.valueOf(paramData.get("userId").toString());
				taglibManager.getMyWatchTaglibsByUserid(userId);
			}else{
				resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
				resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
			}

		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-01 14:11
	 * @desc 获取所有的二级标签
	 * **/
	public ResponseMessage<List<Taglib>> getSecondAllTaglib(Map<String,Object> paramData){
		ResponseMessage<List<Taglib>> resData=new ResponseMessage<List<Taglib>>();
		List<Taglib> data=taglibManager.getSecondAllTaglib();
		resData.setData(data);
		return resData;
	}
	
	
}
