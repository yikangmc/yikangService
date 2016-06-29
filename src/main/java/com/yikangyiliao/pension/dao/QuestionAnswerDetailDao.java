package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.QuestionAnswerDetail;

public interface QuestionAnswerDetailDao {
    int deleteByPrimaryKey(Long questionAnswerDetailId);

    int insert(QuestionAnswerDetail record);

    int insertSelective(QuestionAnswerDetail record);

    QuestionAnswerDetail selectByPrimaryKey(Long questionAnswerDetailId);

    int updateByPrimaryKeySelective(QuestionAnswerDetail record);

    int updateByPrimaryKey(QuestionAnswerDetail record);
}