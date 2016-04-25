package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.GenerateNumber;

public interface GenerateNumberDao {
    int deleteByPrimaryKey(Long gnid);

    int insert(GenerateNumber record);

    int insertSelective(GenerateNumber record);

    GenerateNumber selectByPrimaryKey(Long gnid);

    int updateByPrimaryKeySelective(GenerateNumber record);

    int updateByPrimaryKey(GenerateNumber record);
    
    /**
     * @author liushuaic
     * @date 2015/07/31 21:09
     * 查询某一个表分类中的最大编号
     * **/
    Integer selectMaxOrderNumberByGenerateTable(String tableName);
}