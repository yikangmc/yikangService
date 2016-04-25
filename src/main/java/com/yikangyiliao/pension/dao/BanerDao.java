package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Baner;

public interface BanerDao {
    int deleteByPrimaryKey(Long banerId);

    int insert(Baner record);

    int insertSelective(Baner record);

    Baner selectByPrimaryKey(Long banerId);

    int updateByPrimaryKeySelective(Baner record);

    int updateByPrimaryKey(Baner record);
}