package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.CustumerTimeQuantum;

public interface CustumerTimeQuantumDao {
    int deleteByPrimaryKey(Long custumerTimeQuantumId);

    int insert(CustumerTimeQuantum record);

    int insertSelective(CustumerTimeQuantum record);

    CustumerTimeQuantum selectByPrimaryKey(Long custumerTimeQuantumId);

    int updateByPrimaryKeySelective(CustumerTimeQuantum record);

    int updateByPrimaryKey(CustumerTimeQuantum record);
}