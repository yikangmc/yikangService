package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.SurveyTable;

public interface SurveyTableDao {
    int deleteByPrimaryKey(Long surveyTableId);

    int insert(SurveyTable record);

    int insertSelective(SurveyTable record);

    SurveyTable selectByPrimaryKey(Long surveyTableId);

    int updateByPrimaryKeySelective(SurveyTable record);

    int updateByPrimaryKey(SurveyTable record);
    
    
    /**
     * @author liushuaic
     * @date 2015/08/06
     * 
     * **/
    List<Map<String,Object>> getQuestionCrosswiseByTableName(String tableName);
    
    
    /**
     * @author liushuaic
     * @date 2015/08/06
     * 
     * **/
    Map<String,Object> getQuestionCrosswiseByTableNameTwo(String tableName);
    
    
    
    /**
     * @author liushuaic
     * @date	2015/08/12 11:47
     * @desc 根据某一个表，查询出所有的问题及答案
     * */
    Map<String,Object> getQuestionsAndAnswersByTableName(String tableName);
    
    
    /**
     * @author liushuaic
     * @date 2015/08/18 17:44
     * @desc 获取某一个表中的某一个老人 评估状态 
     * **/
    List<Map<String,Object>> getTableListByAssessmentId(Long assessmentId);
    
    
    /**
     * @author liushuaic
     * @date 2015/08/19 15:20
     * @param assessmentId 档案袋id
     * @param surveyTableId 表id
｀     * */
    Map<String,Object> getQuestionsAndAnswersIsCheck(Map<String,Object> paramData);
    
    /**
     * @author liushuaic
     * @date 2015/08/20 14:20
     * @param assessmentId 档案袋id
     * @param surveyTableId 表id
     * @param questionCrosswiseId 问题分类id
｀     * */
    Map<String,Object> getQuestionAndAnswersIsCheckTwo(Map<String,Object> paramData);
    
    /**
     * @author liushuaic
     * @date 2015/08/24 11:54
     * @param assessmentId 档案袋id
     * @param surveyTableId 表id
     * 查询某一个表，所有问题， 所有答案
     * */
    Map<String,Object> getQuestionAndAnswersIsCheckThree(Map<String,Object> paramData);
    
}