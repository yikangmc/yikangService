package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.LifeNursingAssessment;

public interface LifeNursingAssessmentDao {
    int deleteByPrimaryKey(Long lifeNursingId);

    int insert(LifeNursingAssessment record);

    int insertSelective(LifeNursingAssessment record);

    LifeNursingAssessment selectByPrimaryKey(Long lifeNursingId);

    int updateByPrimaryKeySelective(LifeNursingAssessment record);

    int updateByPrimaryKey(LifeNursingAssessment record);
}