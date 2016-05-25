package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.UserConfigration;

public interface UserConfigrationDao {
    int deleteByPrimaryKey(Long userConfigrationsId);

    int insert(UserConfigration record);

    int insertSelective(UserConfigration record);

    UserConfigration selectByPrimaryKey(Long userConfigrationsId);

    int updateByPrimaryKeySelective(UserConfigration record);

    int updateByPrimaryKey(UserConfigration record);
    
    
    /**
     * 
     * @author liushuaic
     * @date 2016-05-20 11:25
     * @desc 获取某一个用户的配置
     * 
     * **/
    UserConfigration getUserConfigrationByUserId(Long userId);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-20 11:40
     * @desc 修改用户配置
     * */
    int updateByUseridSelective(UserConfigration uc);
    
}