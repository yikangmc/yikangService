package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.FollowUserMap;

public interface FollowUserMapDao {
    int deleteByPrimaryKey(Long followUserMapsId);

    int insert(FollowUserMap record);

    int insertSelective(FollowUserMap record);

    FollowUserMap selectByPrimaryKey(Long followUserMapsId);

    int updateByPrimaryKeySelective(FollowUserMap record);

    int updateByPrimaryKey(FollowUserMap record);
}