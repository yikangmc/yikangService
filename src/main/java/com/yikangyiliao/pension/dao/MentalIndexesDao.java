package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.MentalIndexes;
import com.yikangyiliao.pension.entity.MentalIndexesKey;

public interface MentalIndexesDao {
    int deleteByPrimaryKey(MentalIndexesKey key);

    int insert(MentalIndexes record);

    int insertSelective(MentalIndexes record);

    MentalIndexes selectByPrimaryKey(MentalIndexesKey key);

    int updateByPrimaryKeySelective(MentalIndexes record);

    int updateByPrimaryKey(MentalIndexes record);
}