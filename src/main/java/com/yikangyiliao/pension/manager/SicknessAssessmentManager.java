package com.yikangyiliao.pension.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SurveyTableDao;


@Component
public class SicknessAssessmentManager {

	@Autowired
	private SurveyTableDao surveyTableDao;
	
	
	public Map<String,Object> getSicknessAssessment(){
		return surveyTableDao.getQuestionCrosswiseByTableNameTwo("疾病评估");
	}
	
		
	 /**
	  * @author liushuaic
	  * @date 2015/08/06
	  * 查询生活护理评估表的，评估项
	  * **/
	 public  List<Map<String,Object>> getQuestionCrosswiseByTableName(){
	 	return surveyTableDao.getQuestionCrosswiseByTableName("疾病评估");
	 }
	 
	 
}
