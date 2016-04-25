package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Device;

public interface DeviceDao {
    int deleteByPrimaryKey(Long device_id);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Long device_id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
    
    
    /**
     * @author liushuaic
     * @date 2015/10/13 14:56
     * 修改设备为当前不用的。
     * ***/
    int updateDeviceIsUsedIs0ByUserId(Long userId);
    
    
    
    /**
     * @author liushuaic
     * @date 2015/10/13 15:37
     * 查询某一个用户，正在使用的设备
     * 
     * **/
    Device getIsUsedDeviceByUserId(Long userId);
    
}