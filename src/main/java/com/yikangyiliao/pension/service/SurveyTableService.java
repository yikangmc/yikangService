package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.manager.SurveyTableManager;

@Service("surveyTableService")
public class SurveyTableService {

	@Autowired
	private SurveyTableManager surveyTableManager;

	/**
	 * @author liushuaic
	 * @date 2015/08/18 17:47 获取一个表列表 中表的评估状态
	 * */
	public Map<String, Object> getTableList(Map<String, Object> paramData) {

		Map<String, Object> rtnMap = new HashMap<String, Object>();

		if (paramData.containsKey("assessmentId")) {

			String assessmentId = paramData.get("assessmentId").toString();

			 List<Map<String,Object>> data = surveyTableManager
					.getTableList(Long.valueOf(assessmentId));

			rtnMap.put("data", data);
			rtnMap.put("status",
					ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message",
					ExceptionConstants.responseSuccess.responseSuccess.message);
		} else {
			rtnMap.put(
					"status",
					ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put(
					"message",
					ExceptionConstants.parameterException.parameterException.errorMessage);
		}

		return rtnMap;
	}

	/**
	 * @author liushuaic
	 * @date 2015/08/18 18:29
	 * @desc 查询某一个用户的， 某一个档案代的，某一个表的 所有问题，及答案，及 ，答案是否选中
	 * @param assessmentId
	 * @param surveyTableId
	 * 
	 * **/
	public Map<String, Object> getQuestionsAndAnswersIsCheck(
			Map<String, Object> paramData) {

		Map<String, Object> rtnMap = new HashMap<String, Object>();

		if (paramData.containsKey("assessmentId")
				&& paramData.containsKey("surveyTableId")) {

			Map<String, Object> data = surveyTableManager
					.getQuestionsAndAnswersIsCheck(paramData);

			rtnMap.put("data", data);
			rtnMap.put("status",ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message",ExceptionConstants.responseSuccess.responseSuccess.message);
		} else {
			rtnMap.put("status",ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message",ExceptionConstants.parameterException.parameterException.errorMessage);
		}

		return rtnMap;
	}

	/**
	 * @author liushuaic
	 * @date 2015/08/18 18:29
	 * @desc 查询某一个用户的， 某一个档案代的，某一个表的 所有问题，及答案，及 ，答案是否选中
	 * @param assessmentId
	 * @param surveyTableId
	 * @param questionCrosswiseId 问题分类id
	 * **/
	public Map<String, Object> getQuestionAndAnswersIsCheckTwo(Map<String, Object> paramData) {

		Map<String, Object> rtnMap = new HashMap<String, Object>();

		if (paramData.containsKey("assessmentId")
				&& paramData.containsKey("surveyTableId")
				&& paramData.containsKey("questionCrosswiseId")) {

			Map<String, Object> data =surveyTableManager.getQuestionAndAnswersIsCheckTwo(paramData);

			rtnMap.put("data", data);
			rtnMap.put("status",ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message",ExceptionConstants.responseSuccess.responseSuccess.message);
		} else {
			rtnMap.put( "status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put( "message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}

		return rtnMap;
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/18 18:29
	 * @desc 查询某一个用户的， 某一个档案代的，某一个表的 所有问题，及答案，及 ，答案是否选中
	 * @param assessmentId
	 * @param surveyTableId
	 * @param questionCrosswiseId 问题分类id
	 * **/
	public Map<String, Object> getQuestionAndAnswersIsCheckThree(Map<String, Object> paramData) {

		Map<String, Object> rtnMap = new HashMap<String, Object>();

		if (
				paramData.containsKey("assessmentId")
				&& paramData.containsKey("surveyTableId")
			) {

			Map<String, Object> data =surveyTableManager.getQuestionAndAnswersIsCheckThree(paramData);

			rtnMap.put("data", data);
			rtnMap.put("status",ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message",ExceptionConstants.responseSuccess.responseSuccess.message);
		} else {
			rtnMap.put( "status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put( "message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}

		return rtnMap;
	}

}
