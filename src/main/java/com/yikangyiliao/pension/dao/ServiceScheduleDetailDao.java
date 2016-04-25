package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.ServiceScheduleDetail;

public interface ServiceScheduleDetailDao {
    int deleteByPrimaryKey(Long serviceScheduleDetailId);

    int insert(ServiceScheduleDetail record);

    int insertSelective(ServiceScheduleDetail record);

    ServiceScheduleDetail selectByPrimaryKey(Long serviceScheduleDetailId);

    int updateByPrimaryKeySelective(ServiceScheduleDetail record);

    int updateByPrimaryKey(ServiceScheduleDetail record);
    

    /**
     * @author liushuaic
     * @date 2015/09/17 13:52
     * 查询某一天的工作计划的内容
     * **/
    List<Map<String,Object>> getServiceScheduleDetailByServiceScheduleId(Long serviceScheduleId);
    
    
    /**
     * @author liushuaic
     * @date 2015/09/17 18:36
     * 查询某一天的工作计划的内容
     * @param serviceDate
     * @param serviceScheduleId
     * @param serviceUserId
     * **/
    List<Map<String,Object>> getServiceScheduleDetailByUserIdAndSelectDate(Map<String,Object> paramData);
}