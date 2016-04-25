package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.SeniorLivingCondition;

public interface SeniorLivingConditionDao {
    int deleteByPrimaryKey(Long slcId);

    int insert(SeniorLivingCondition record);

    int insertSelective(SeniorLivingCondition record);

    SeniorLivingCondition selectByPrimaryKey(Long slcId);

    int updateByPrimaryKeySelective(SeniorLivingCondition record);

    int updateByPrimaryKey(SeniorLivingCondition record);
}