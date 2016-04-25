package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SurveyTableDao;



@Component
public class OldManCommonQuestionManager {
	
	
	@Autowired
	private SurveyTableDao surveyTableDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/12 16:41
	 * 老年人常见问题
	 * */
	public Map<String,Object> getQuestionsAndAnswersByTableName(){
		return surveyTableDao.getQuestionsAndAnswersByTableName("老年人常见问题");
	}

}
