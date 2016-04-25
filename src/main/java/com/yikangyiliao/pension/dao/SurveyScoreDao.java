package com.yikangyiliao.pension.dao;

import java.util.Map;

import com.yikangyiliao.pension.entity.SurveyScore;

public interface SurveyScoreDao {
    int deleteByPrimaryKey(Long sureyScoreId);

    int insert(SurveyScore record);

    int insertSelective(SurveyScore record);

    SurveyScore selectByPrimaryKey(Long sureyScoreId);

    int updateByPrimaryKeySelective(SurveyScore record);

    int updateByPrimaryKey(SurveyScore record);
    
    /**
     * @author liushuaic
     * @date 2015/08/06
     * 根据 档案袋id 与 查询表id， 查询出某一个表的总评分
     * */
    SurveyScore getSureyScoreByAssessmentIdAndSureyTableId(Map<String,Object> paramData);
    
    
    /**
     * @author liushuaic
     * @date 2015/08/07 11：23
     * 修改某一人问卷的总得分
     * @param surveyScoreId 某一个问卷的总评分
     * **/
    int updateTotalBySurveyScoreId(Long surveyScoreId);
}