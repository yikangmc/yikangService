package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.manager.TaglibManager;

@Service(value="taglibService")
public class TaglibService {

	
	@Autowired
	private TaglibManager taglibManager;
	
	
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
			
			List<Taglib> tags= taglibManager.getSecondTaglibByParentId(parentId);
			
			resData.setData(tags);
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
		List<Taglib> data=taglibManager.getAllTag();
		resData.setData(data);
		return resData;
	}
	
	
}
