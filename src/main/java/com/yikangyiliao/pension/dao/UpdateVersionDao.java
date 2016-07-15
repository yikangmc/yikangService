package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.UpdateVersion;

public interface UpdateVersionDao {
    int deleteByPrimaryKey(Long updateVersionId);

    int insert(UpdateVersion record);

    int insertSelective(UpdateVersion record);

    UpdateVersion selectByPrimaryKey(Long updateVersionId);

    int updateByPrimaryKeySelective(UpdateVersion record);

    int updateByPrimaryKey(UpdateVersion record);
}