package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.SocialParticipation;
import com.yikangyiliao.pension.entity.SocialParticipationKey;

public interface SocialParticipationDao {
    int deleteByPrimaryKey(SocialParticipationKey key);

    int insert(SocialParticipation record);

    int insertSelective(SocialParticipation record);

    SocialParticipation selectByPrimaryKey(SocialParticipationKey key);

    int updateByPrimaryKeySelective(SocialParticipation record);

    int updateByPrimaryKey(SocialParticipation record);
}