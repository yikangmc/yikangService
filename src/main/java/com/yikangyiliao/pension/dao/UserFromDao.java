package com.yikangyiliao.pension.dao;

import java.util.Map;

import com.yikangyiliao.pension.entity.UserFrom;

public interface UserFromDao {
    int deleteByPrimaryKey(Long userFromId);

    int insert(UserFrom record);

    int insertSelective(UserFrom record);

    UserFrom selectByPrimaryKey(Long userFromId);
    
    /**
     * @author liushuaic
     * @date 2015/11/17 15:55
     * @desc 查询用户来源 根据 userId
     * */
    UserFrom selectByUserId(Long userId);

    int updateByPrimaryKeySelective(UserFrom record);

    int updateByPrimaryKey(UserFrom record);
    
    /**
     * @author liushuaic
     * @date 2015/11/17 15:46
     * @desc  修改定单状态 
     * */
    int updateUserStatusByUserId(Map<String,Object> paramData);
}