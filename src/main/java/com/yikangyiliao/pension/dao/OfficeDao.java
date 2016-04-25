package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.Office;

public interface OfficeDao {
    int deleteByPrimaryKey(Long officeId);

    int insert(Office record);

    int insertSelective(Office record);

    Office selectByPrimaryKey(Long officeId);

    int updateByPrimaryKeySelective(Office record);

    int updateByPrimaryKey(Office record);
    
    /**
     * @author liushuaic
     * @date 2016-03-17 10:37
     * @desc 获取所有科室
     * */
    List<Office> getOffices();
}