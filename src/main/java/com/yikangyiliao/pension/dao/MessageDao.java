package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Message;

public interface MessageDao {
    int deleteByPrimaryKey(Long messagesId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long messagesId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}