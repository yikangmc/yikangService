package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.pathologicalSign;

public interface pathologicalSignDao {
    int deleteByPrimaryKey(Long pathologicalId);

    int insert(pathologicalSign record);

    int insertSelective(pathologicalSign record);

    pathologicalSign selectByPrimaryKey(Long pathologicalId);

    int updateByPrimaryKeySelective(pathologicalSign record);

    int updateByPrimaryKey(pathologicalSign record);
}