package com.yikangyiliao.pension.dao;

import java.util.List;

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
    
    
    /**
     * @author liushuaic
     * @date 2016-05-24 15:19
     * @desc 查询某一个标签下的所有问题
     * **/
    List<Question> getQuestionByTaglibid(Long taglibId);
    
    
    
    /**
     * @author liushuaic
     * @date 2016-06-07 11:22
     * @desc 获取某一个用户创建的所有问题
     * **/
    List<Question> getQuestionByCreateUserId(Long userId);
    
    
    
}