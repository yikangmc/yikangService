package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.DailyIndexes;
import com.yikangyiliao.pension.entity.DailyIndexesKey;

public interface DailyIndexesDao {
    int deleteByPrimaryKey(DailyIndexesKey key);

    int insert(DailyIndexes record);

    int insertSelective(DailyIndexes record);

    DailyIndexes selectByPrimaryKey(DailyIndexesKey key);

    int updateByPrimaryKeySelective(DailyIndexes record);

    int updateByPrimaryKey(DailyIndexes record);
}