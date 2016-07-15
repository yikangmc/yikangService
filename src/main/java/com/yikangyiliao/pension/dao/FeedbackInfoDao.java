package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.FeedbackInfo;

public interface FeedbackInfoDao {
    int deleteByPrimaryKey(Long feedbackInfoId);

    int insert(FeedbackInfo record);

    int insertSelective(FeedbackInfo record);

    FeedbackInfo selectByPrimaryKey(Long feedbackInfoId);

    int updateByPrimaryKeySelective(FeedbackInfo record);

    int updateByPrimaryKey(FeedbackInfo record);
}