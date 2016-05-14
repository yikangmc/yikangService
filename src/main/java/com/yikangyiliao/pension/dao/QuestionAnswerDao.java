package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.QuestionAnswer;

public interface QuestionAnswerDao {
    int deleteByPrimaryKey(Long questionAnswerId);

    int insert(QuestionAnswer record);

    int insertSelective(QuestionAnswer record);

    QuestionAnswer selectByPrimaryKey(Long questionAnswerId);

    int updateByPrimaryKeySelective(QuestionAnswer record);

    int updateByPrimaryKey(QuestionAnswer record);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-10 15:44
     * @desc 添加问题支持
     * */
    int updateQuestionAnsweStartup(Long questionAnswerId);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-10 15:47
     * @desc 取消回答的支持
     * */
    int updateQuestionAnswerdown(Long questionAnswerId);
}