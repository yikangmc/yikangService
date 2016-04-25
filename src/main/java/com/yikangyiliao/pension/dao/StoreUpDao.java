package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.StoreUp;

public interface StoreUpDao {
    int deleteByPrimaryKey(Long storeUpsId);

    int insert(StoreUp record);

    int insertSelective(StoreUp record);

    StoreUp selectByPrimaryKey(Long storeUpsId);

    int updateByPrimaryKeySelective(StoreUp record);

    int updateByPrimaryKey(StoreUp record);
}