package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Activety;

public interface ActivetyDao {
    int deleteByPrimaryKey(Long activetyId);

    int insert(Activety record);

    int insertSelective(Activety record);

    Activety selectByPrimaryKey(Long activetyId);

    int updateByPrimaryKeySelective(Activety record);

    int updateByPrimaryKey(Activety record);
}