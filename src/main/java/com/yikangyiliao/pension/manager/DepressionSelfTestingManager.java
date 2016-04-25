package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SurveyTableDao;

@Component
public class DepressionSelfTestingManager {

	
	@Autowired
	private SurveyTableDao surveyTableDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/12 16:41
	 * 抑郁自测
	 * */
	public Map<String,Object> getQuestionsAndAnswersByTableName(){
		return surveyTableDao.getQuestionsAndAnswersByTableName("抑郁自测评估表");
	}
	
}
