package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Question;

public interface QuestionDao {
    int deleteByPrimaryKey(Long questionId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Long questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-11 11:49
     * @desc 查询某一个问题的详情
     * **/
    Question getQuestionDetailByQuestionId(Long questionId);
}