package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.CommonProblem;
import com.yikangyiliao.pension.entity.CommonProblemKey;

public interface CommonProblemDao {
    int deleteByPrimaryKey(CommonProblemKey key);

    int insert(CommonProblem record);

    int insertSelective(CommonProblem record);

    CommonProblem selectByPrimaryKey(CommonProblemKey key);

    int updateByPrimaryKeySelective(CommonProblem record);

    int updateByPrimaryKey(CommonProblem record);
}