package com.yikangyiliao.pension.manager;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SurveyScoreDetailDao;


@Component
public class SurveyScoreDetailManager {

	
	@Autowired
	private SurveyScoreDetailDao surveyScoreDetailDao;
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/08/14 16:02
	 * 删除某一个表评测表下所有答案详情
	 * 
	 * */
	public int deleteSurveyScoreDetailBySurveyScoreId(Long surveyScoreId){
	    return surveyScoreDetailDao.deleteSurveyScoreDetailBySurveyScoreId(surveyScoreId);
	}
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/08/14 16:02
	 * 删除某一个表评测表下的 某一个问题的所有答案详情
	 *  @param surveyScoreId
 		@param quetionId
	 * */
	public int deleteSurveyScoreDetailBySurveyScoreIdAndQuestionId(Map<String,Object> paramData){
	    return surveyScoreDetailDao.deleteSurveyScoreDetailBySurveyScoreIdAndQuestionId(paramData);
	}
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/08/14 16:02
	 * 删除某一个表评测表下的 某一个问题的所有答案详情
	 *  @param surveyScoreId
 		@param quetionId
	 * */
	public int deleteSurveyScoreDetailBySurveyScoreIdAndQuestionCrosswiseId(Map<String,Object> paramData){
		return surveyScoreDetailDao.deleteSurveyScoreDetailBySurveyScoreIdAndQuestionCrosswiseId(paramData);
	}
}
