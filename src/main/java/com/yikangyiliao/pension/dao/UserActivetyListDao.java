package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.UserActivetyList;

public interface UserActivetyListDao {
    int deleteByPrimaryKey(Long userActivetyListId);

    int insert(UserActivetyList record);

    int insertSelective(UserActivetyList record);

    UserActivetyList selectByPrimaryKey(Long userActivetyListId);

    int updateByPrimaryKeySelective(UserActivetyList record);

    int updateByPrimaryKey(UserActivetyList record);
}