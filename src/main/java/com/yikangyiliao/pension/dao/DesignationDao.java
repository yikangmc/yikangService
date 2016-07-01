package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.Designation;

public interface DesignationDao {
    int deleteByPrimaryKey(Long designationId);

    int insert(Designation record);

    int insertSelective(Designation record);

    Designation selectByPrimaryKey(Long designationId);

    int updateByPrimaryKeySelective(Designation record);

    int updateByPrimaryKey(Designation record);
    
    
    /**
     * @author liushuaic
     * @date 2016-07-01 11:41
     * @desc 查询用户番号
     **/
    List<Designation> getDesignations();
    
    
}