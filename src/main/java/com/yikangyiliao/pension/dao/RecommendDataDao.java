package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.RecommendData;

public interface RecommendDataDao{
    int deleteByPrimaryKey(Long recommendDataId);

    int insert(RecommendData record);

    int insertSelective(RecommendData record);

    RecommendData selectByPrimaryKey(Long recommendDataId);

    int updateByPrimaryKeySelective(RecommendData record);

    int updateByPrimaryKey(RecommendData record);
}