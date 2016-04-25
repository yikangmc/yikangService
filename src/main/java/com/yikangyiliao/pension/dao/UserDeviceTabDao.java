package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.UserDeviceTab;

public interface UserDeviceTabDao {
    int deleteByPrimaryKey(Long userDeviceTabId);

    int insert(UserDeviceTab record);

    int insertSelective(UserDeviceTab record);

    UserDeviceTab selectByPrimaryKey(Long userDeviceTabId);

    int updateByPrimaryKeySelective(UserDeviceTab record);

    int updateByPrimaryKey(UserDeviceTab record);
}