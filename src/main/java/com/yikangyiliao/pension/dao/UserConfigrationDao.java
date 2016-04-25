package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.UserConfigration;

public interface UserConfigrationDao {
    int deleteByPrimaryKey(Long userConfigrationsId);

    int insert(UserConfigration record);

    int insertSelective(UserConfigration record);

    UserConfigration selectByPrimaryKey(Long userConfigrationsId);

    int updateByPrimaryKeySelective(UserConfigration record);

    int updateByPrimaryKey(UserConfigration record);
}