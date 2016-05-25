package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.Message;

public interface MessageDao {
    int deleteByPrimaryKey(Long messagesId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long messagesId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    /**
     * @author liushuaic
     * @date 2016-05-25 14:04
     * **/
    List<Message> getMessageByToUserId(Long toUserId);
}