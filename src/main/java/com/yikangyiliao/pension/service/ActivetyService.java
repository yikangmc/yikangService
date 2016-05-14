package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Activety;
import com.yikangyiliao.pension.manager.ActivetyManager;

@Service(value="activetyService")
public class ActivetyService {

	@Autowired
	private ActivetyManager activetyManager;
	
	
	/**
     * @author liushuaic
     * @date 2016-05-13 10:19
     * @desc 获取所有活动
     * **/
	public ResponseMessage<List<Activety>> getActivetys(Map<String,Object> paramMap){
		ResponseMessage<List<Activety>> resData=new ResponseMessage<List<Activety>>(); 
		List<Activety> data=activetyManager.getActivetys();
		resData.setData(data);
		return resData;
		 
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-13 16:19
	 * @desc 获取某一个活动
	 * **/
	public ResponseMessage<Activety> getActivetyByActivetyId(Map<String,Object> paramMap){
		ResponseMessage<Activety> resData=new ResponseMessage<Activety>(); 
		if(paramMap.containsKey("activetyId")){
			Long activetyId=Long.valueOf(paramMap.get("paramMap").toString());
			Activety activety=activetyManager.getActivetysDetailById(activetyId);
			resData.setData(activety);
		}
		return resData;
	}
	
	/**
	 * @author liushuaic
	 * @date 
	 * **/
	public ResponseMessage<Activety> insertActivety(Map<String,Object> paramMap){
		ResponseMessage<Activety> resData=new ResponseMessage<Activety>();
		if(
			   paramMap.containsKey("title")
			&& paramMap.containsKey("content")
			&& paramMap.containsKey("startTime")
			&& paramMap.containsKey("endTime")
			&& paramMap.containsKey("mapPositionAddress")
			&& paramMap.containsKey("detailAddress")
			&& paramMap.containsKey("districtCode")
			&& paramMap.containsKey("personNumber")
			&& paramMap.containsKey("cost")
			&& paramMap.containsKey("taglibs")
		 ){
			
			
			
			
		}
		
		
		return resData;
	}
	
	
}
