package com.yikangyiliao.pension.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yikangyiliao.pension.entity.QuestionAnswerStartList;

public interface QuestionAnswerStartListDao {
    int deleteByPrimaryKey(Long questionAnswerStartListId);

    int insert(QuestionAnswerStartList record);

    int insertSelective(QuestionAnswerStartList record);

    QuestionAnswerStartList selectByPrimaryKey(Long questionAnswerStartListId);

    int updateByPrimaryKeySelective(QuestionAnswerStartList record);

    int updateByPrimaryKey(QuestionAnswerStartList record);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-10 11:02
     * @desc 获取某一条记录
     ***/
    QuestionAnswerStartList getRowByQuestionAnswerIdAndCreateUserId(Long questionAnswerId,Long createUserId);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-10 14:18
     * @desc 删除某一个支持记录
     * @param questionAnswerId
     * @param createUserId
     * */
    int deleteQuestionAnswerStartListByQuestionAnswerIdAndCreateUserId(@Param("questionAnswerId")Long questionAnswerId,@Param("createUserId")Long createUserId);
    
    
    
    
}