package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.TimeQuantum;

public interface TimeQuantumDao {
    int deleteByPrimaryKey(Long timeQuantumId);

    int insert(TimeQuantum record);

    int insertSelective(TimeQuantum record);

    TimeQuantum selectByPrimaryKey(Long timeQuantumId);

    int updateByPrimaryKeySelective(TimeQuantum record);

    int updateByPrimaryKey(TimeQuantum record);
    
    
    /**
     * 
     * @author liushuaic
     * @date 2015/09/18 18:12
     * @desc 获取所有的时间段
     * 
     * 
     * **/
    List<TimeQuantum> getAllTimeQuantum();
    
    
    /**
     * 
     * @author liushuaic
     * @date 2015/10/09 14:53
     * @desc 查询某一个服务时间内的，可用时间
     * 
     * */
    List<Map<String,Object>> getTimeQuantumsForCustomer(Map<String,Object> param);
    
    
}