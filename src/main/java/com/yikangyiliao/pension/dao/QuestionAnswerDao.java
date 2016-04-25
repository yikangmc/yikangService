package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.QuestionAnswer;

public interface QuestionAnswerDao {
    int deleteByPrimaryKey(Long questionAnswerId);

    int insert(QuestionAnswer record);

    int insertSelective(QuestionAnswer record);

    QuestionAnswer selectByPrimaryKey(Long questionAnswerId);

    int updateByPrimaryKeySelective(QuestionAnswer record);

    int updateByPrimaryKey(QuestionAnswer record);
}