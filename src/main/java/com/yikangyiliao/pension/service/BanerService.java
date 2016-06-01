package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Baner;
import com.yikangyiliao.pension.manager.BanerManager;

@Service(value="banerService")
public class BanerService {
	
	
	@Autowired
	private BanerManager banerManager;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-04-25 14:57
	 * @desc 获取首页baner列表
	 * **/
	public ResponseMessage<List<Baner>> getBanerList(Map<String,Object> paramData){
		
		ResponseMessage<List<Baner>> responseMessage=new ResponseMessage<List<Baner>>();
		
		try{
			List<Baner> baners=banerManager.getBanerList();
			responseMessage.setData(baners);
		}catch(Exception e){
			e.printStackTrace();
			responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return responseMessage;
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-27 14:34
	 * @desc 获取活动baner
	 * **/
	public ResponseMessage<List<Baner>>  getActivetyBaner(Map<String,Object> paramData){
		ResponseMessage<List<Baner>> responseMessage=new ResponseMessage<List<Baner>>();
		List<Baner> baners=banerManager.getActivetyBaner();
		responseMessage.setData(baners);
		return responseMessage;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-01 11:28
	 * @desc 获取发现搜索banner
	 * 
	 * **/
	public ResponseMessage<List<Baner>> getSearchActivetyBanner(){
		ResponseMessage<List<Baner>> responseMessage=new ResponseMessage<List<Baner>>();
		
		
		
		return responseMessage;
	}

}
