package com.yikangyiliao.pension.dao;

import java.util.Map;

import com.yikangyiliao.pension.entity.Area;

public interface AreaDao {
    int deleteByPrimaryKey(Long areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Long areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    
    /**
     * @author liushuaic
     * @date 2015/08/27 15:25
     * @desc 查询所有城市
     * */
    Map<String,Object> getAreaCityDistrict();
    
}