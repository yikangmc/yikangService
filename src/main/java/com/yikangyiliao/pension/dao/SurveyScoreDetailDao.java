package com.yikangyiliao.pension.dao;

import java.util.Map;

import com.yikangyiliao.pension.entity.SurveyScoreDetail;

public interface SurveyScoreDetailDao {
    int deleteByPrimaryKey(Long surveyScoreDetailId);

    int insert(SurveyScoreDetail record);

    int insertSelective(SurveyScoreDetail record);

    SurveyScoreDetail selectByPrimaryKey(Long surveyScoreDetailId);

    int updateByPrimaryKeySelective(SurveyScoreDetail record);

    int updateByPrimaryKey(SurveyScoreDetail record);
    
    
    /**
     * @author liushuaic
     * @date 2015/08/14 15:49 
     * */
    int deleteSurveyScoreDetailBySurveyScoreId(Long surveyScoreId);
    
    /**
     * @author liushuaic
     * @date 2015/08/14 15:49 
     * */
    int deleteSurveyScoreDetailBySurveyScoreIdAndQuestionId(Map<String,Object> paramData);
    
    /**
     * @author liushuaic
     * @date 2015/08/24 18:13
     * */
    int deleteSurveyScoreDetailBySurveyScoreIdAndQuestionCrosswiseId(Map<String,Object> paramData);
}