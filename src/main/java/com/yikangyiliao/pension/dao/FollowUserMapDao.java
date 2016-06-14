package com.yikangyiliao.pension.dao;

import java.util.Map;

import com.yikangyiliao.pension.entity.FollowUserMap;

public interface FollowUserMapDao {
    int deleteByPrimaryKey(Long followUserMapsId);

    int insert(FollowUserMap record);

    int insertSelective(FollowUserMap record);

    FollowUserMap selectByPrimaryKey(Long followUserMapsId);

    int updateByPrimaryKeySelective(FollowUserMap record);

    int updateByPrimaryKey(FollowUserMap record);
    
    /**
     * @author liushuaic
     * @date 2016-06-06 20:31
     * @desc 删除我关注的用户
     * ***/
    int deleteMyFollowUser(Map<String,Object> paramMap);
    
    
    /**
     * @author liushuaic
     * @date 2016-06-08 10:18
     * @desc 获取我关注的某一个用户的记录
     * **/
    FollowUserMap getMyFollowUserByUserIdAndFolloUserId(Map<String,Object> paramMap);
}