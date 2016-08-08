package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ThreePartAccount;

public interface ThreePartAccountDao {
    int deleteByPrimaryKey(Long threePartAccountId);

    int insert(ThreePartAccount record);

    int insertSelective(ThreePartAccount record);

    ThreePartAccount selectByPrimaryKey(Long threePartAccountId);

    int updateByPrimaryKeySelective(ThreePartAccount record);

    int updateByPrimaryKeyWithBLOBs(ThreePartAccount record);

    int updateByPrimaryKey(ThreePartAccount record);
}