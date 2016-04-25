package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Answer;

public interface AnswerDao {
    int deleteByPrimaryKey(Long answerId);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Long answerId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
}