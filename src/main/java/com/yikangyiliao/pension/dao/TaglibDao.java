package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Taglib;

public interface TaglibDao {
    int deleteByPrimaryKey(Long taglibId);

    int insert(Taglib record);

    int insertSelective(Taglib record);

    Taglib selectByPrimaryKey(Long taglibId);

    int updateByPrimaryKeySelective(Taglib record);

    int updateByPrimaryKey(Taglib record);
}