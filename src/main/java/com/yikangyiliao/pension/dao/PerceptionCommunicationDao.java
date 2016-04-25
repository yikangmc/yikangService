package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.PerceptionCommunication;
import com.yikangyiliao.pension.entity.PerceptionCommunicationKey;

public interface PerceptionCommunicationDao {
    int deleteByPrimaryKey(PerceptionCommunicationKey key);

    int insert(PerceptionCommunication record);

    int insertSelective(PerceptionCommunication record);

    PerceptionCommunication selectByPrimaryKey(PerceptionCommunicationKey key);

    int updateByPrimaryKeySelective(PerceptionCommunication record);

    int updateByPrimaryKey(PerceptionCommunication record);
}