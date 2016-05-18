package com.yikangyiliao.pension.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.base.utils.DateUtils;
import com.yikangyiliao.base.utils.ParamMapUtils;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
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
	 * @desc 添加活动
	 * **/
	public ResponseMessage<Activety> insertActivety(Map<String,Object> paramMap){
		ResponseMessage<Activety> resData=new ResponseMessage<Activety>();
		if(
			   paramMap.containsKey("title")
			&& paramMap.containsKey("content")
			&& paramMap.containsKey("startTime")
			&& paramMap.containsKey("endTime")
			&& paramMap.containsKey("entryStartTime")
			&& paramMap.containsKey("entryEndTime")
			&& paramMap.containsKey("mapPositionAddress")
			&& paramMap.containsKey("detailAddress")
			&& paramMap.containsKey("districtCode")
			&& paramMap.containsKey("lng")
			&& paramMap.containsKey("lat")
			&& paramMap.containsKey("personNumber")
			&& paramMap.containsKey("cost")
			&& paramMap.containsKey("taglibs")
			&& paramMap.containsKey("activetyMode")
		 ){
			String title=paramMap.get("title").toString();
			String content=paramMap.get("content").toString();
			
			Date startTime = null;
			try {
				startTime = DateUtils.formateDateTime(paramMap.get("startTime").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date endTime=null;
			try {
				endTime = DateUtils.formateDateTime(paramMap.get("endTime").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Date entryStartTime=null;
			try {
				entryStartTime=DateUtils.formateDateTime(paramMap.get("entryStartTime").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date entryEndTime=null;
			try {
				entryEndTime=DateUtils.formateDateTime(paramMap.get("entryEndTime").toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String mapPositionAddress=paramMap.get("mapPositionAddress").toString();
			String detailAddress=paramMap.get("detailAddress").toString();
			String districtCode=paramMap.get("districtCode").toString();
			//获取经度
			Double lng=Double.valueOf(paramMap.get("lng").toString());
			//纬度
			Double lat=Double.valueOf(paramMap.get("lat").toString());
			
			Integer personNumber=Integer.valueOf(paramMap.get("personNumber").toString());
			Double cost=Double.valueOf(paramMap.get("cost").toString());
			List taglibs=(List)paramMap.get("taglibs");
			Long[] taglibIds=ParamMapUtils.converObjectArrayToLong(taglibs);
			
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			
			Byte activetyMode=Byte.valueOf(paramMap.get("activetyMode").toString());
			
			
			
			String recommendPicUrl="";
			if(paramMap.containsKey("recommendPicUrl")){
				recommendPicUrl=paramMap.get("recommendPicUrl").toString();
			}
			
			activetyManager.insertActivety(title,content,startTime,endTime,entryStartTime,entryEndTime,lng,lat,personNumber,cost,taglibIds,mapPositionAddress,detailAddress,districtCode,userId,activetyMode,recommendPicUrl);
			
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-17 18:33
	 * @desc 添加我参与的活动
	 * **/
	public ResponseMessage<String> insertMyAcitivety(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(paramMap.containsKey("activetyId")){
			
		}
		
		return resData;
		
	}
	
}
