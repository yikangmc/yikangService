package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.manager.DepressionAssessmentManager;


/**
 * @author liushuaic
 * @date 2015/08/12 16:58
 * 抑郁评估
 * */
@Service(value="depressionAssessmentService")
public class DepressionAssessmentService {
	
	
	
	@Autowired
	private DepressionAssessmentManager depressionAssessmentManager;
	
	
	public Map<String,Object> getTable(Map<String,Object> paramData){
		Map<String,Object> rtnMap=new HashMap<String, Object>();
		
		Map<String,Object> data=depressionAssessmentManager.getQuestionsAndAnswersByTableName();

		rtnMap.put("data", data);
		rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		
		return rtnMap;
		
	}

	
}
