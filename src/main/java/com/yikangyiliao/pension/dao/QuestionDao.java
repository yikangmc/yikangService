package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Question;

public interface QuestionDao {
    int deleteByPrimaryKey(Long questionId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Long questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}