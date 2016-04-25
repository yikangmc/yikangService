package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.manager.SicknessAssessmentManager;



/**
 * @author liushuaic
 * @date 2015/08/07 19:31
 * @desc 疾病评估
 * 
 * **/

@Service(value="sicknessAssessmentService")
public class SicknessAssessmentService {

	
	private Logger logger =Logger.getLogger(SicknessAssessmentService.class);
	
	
	@Autowired
	private SicknessAssessmentManager sicknessAssessmentManager;
	
	
	public Map<String, Object> getTable(Map<String, Object> paramData) {
		Map<String, Object> rtnData = new HashMap<String, Object>();
		try {
			
			List<Map<String,Object>> data=sicknessAssessmentManager.getQuestionCrosswiseByTableName();
			System.out.println(new ObjectMapper().writeValueAsString(data));
			rtnData.put("data", data);
			rtnData.put("status",
					ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message",
					ExceptionConstants.responseSuccess.responseSuccess.message);

		} catch (Exception e) {
			rtnData.put("status",ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message",ExceptionConstants.systemException.systemException.errorMessage);
			e.printStackTrace();
			logger.error(e);
		}
		return rtnData;
	}

	
}
