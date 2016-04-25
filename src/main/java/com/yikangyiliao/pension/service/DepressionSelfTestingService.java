package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.manager.DepressionSelfTestingManager;




/**
 * 
 * @author liushuaic
 * 抑郁自测
 * 
 * */
@Service(value="depressionSelfTestingService")
public class DepressionSelfTestingService {

	
	@Autowired
	private DepressionSelfTestingManager depressionSelftTestingManager;
	
	
	public Map<String,Object> getTable(Map<String,Object> paramData){
		Map<String,Object> rtnMap=new HashMap<String, Object>();
		
		Map<String,Object> data=depressionSelftTestingManager.getQuestionsAndAnswersByTableName();

		rtnMap.put("data", data);
		rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		
		return rtnMap;
		
	}
	
}
