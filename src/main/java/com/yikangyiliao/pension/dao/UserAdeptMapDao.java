package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.UserAdeptMap;

public interface UserAdeptMapDao {
    int deleteByPrimaryKey(Long userAdeptMapId);

    int insert(UserAdeptMap record);

    int insertSelective(UserAdeptMap record);

    UserAdeptMap selectByPrimaryKey(Long userAdeptMapId);

    int updateByPrimaryKeySelective(UserAdeptMap record);

    int updateByPrimaryKey(UserAdeptMap record);
    
    
    /**
     * @author liushuaic
     * @date 2016-03-23 16:52
     * @desc 删除用户的擅长 by  用户id
     * **/
    int deleteUserAdeptAllByUserId(Long userId);
}