package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ActivetyTaglibMap;

public interface ActivetyTaglibMapDao {
    int deleteByPrimaryKey(Long activetyTaglibMapId);

    int insert(ActivetyTaglibMap record);

    int insertSelective(ActivetyTaglibMap record);

    ActivetyTaglibMap selectByPrimaryKey(Long activetyTaglibMapId);

    int updateByPrimaryKeySelective(ActivetyTaglibMap record);

    int updateByPrimaryKey(ActivetyTaglibMap record);
}