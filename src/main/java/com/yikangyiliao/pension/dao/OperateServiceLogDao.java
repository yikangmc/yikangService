package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.OperateServiceLog;

public interface OperateServiceLogDao {
    int deleteByPrimaryKey(Long operateServiceLogId);

    int insert(OperateServiceLog record);

    int insertSelective(OperateServiceLog record);

    OperateServiceLog selectByPrimaryKey(Long operateServiceLogId);

    int updateByPrimaryKeySelective(OperateServiceLog record);

    int updateByPrimaryKeyWithBLOBs(OperateServiceLog record);

    int updateByPrimaryKey(OperateServiceLog record);
}