package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.OrderNumber;

public interface OrderNumberDao {
    int deleteByPrimaryKey(Long orderNumberId);

    int insert(OrderNumber record);

    int insertSelective(OrderNumber record);

    OrderNumber selectByPrimaryKey(Long orderNumberId);

    int updateByPrimaryKeySelective(OrderNumber record);

    int updateByPrimaryKey(OrderNumber record);
}