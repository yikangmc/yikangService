package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.Location;

public interface LocationDao {
    int deleteByPrimaryKey(Long locationId);

    int insert(Location record);

    int insertSelective(Location record);

    Location selectByPrimaryKey(Long locationId);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);
    
    /**
     * @author liushuaic
     * @date 2015/10/19 14:26
     * @desc 获取城市信息 by 县编码
     * **/
    Location getCityByDistrictCode(String administrativeCode);
    
    /**
     * @author liushuaic
     * @date 2015/10/19 14:27
     * @desc 获取省信息
     * **/
    Location getProvenceByCityCode(String administrativeCode);
    
    
    /**
     * @author liushuaic
     * @date 2015/10/19 15:09
     * */
    Location getLocationByAdministrativeCode(String administrativeCode);
}