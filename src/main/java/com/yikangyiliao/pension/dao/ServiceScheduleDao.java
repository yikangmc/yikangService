package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.ServiceSchedule;

public interface ServiceScheduleDao {
    int deleteByPrimaryKey(Long serviceScheduleId);

    int insert(ServiceSchedule record);

    int insertSelective(ServiceSchedule record);

    ServiceSchedule selectByPrimaryKey(Long serviceScheduleId);

    int updateByPrimaryKeySelective(ServiceSchedule record);

    int updateByPrimaryKey(ServiceSchedule record);
    
    
    
    /**
     * @author liushuaic
     * @date 2015/09/17 13:52
     * 
     * **/
    
    ServiceSchedule getServiceSchedule(Map<String,Object> param);
    
    
    /**
     * @author liushuaic
     * @date 2015/09/17 14:12
     * 获取某年某月的，已经确定的日程
     * 
     * **/
    List<ServiceSchedule> getServiceScheduleByServiceYearAndServiceMonth(Map<String,Object> param);
    
    
    /**
     * @author liushuaic
     * @date 2015/09/18 14:15
     * 修改某一天的，工作计划计划，是否已经选择 
     * @param serviceScheduleId
     * @param updateTime
     * **/
    void updateIsCanSelected1ByServiceScheduleId(Map<String,Object> param);
    
    
    
    /**
     *  @author liushuaic
     *  @date 2015/09/18 14:15
     *  修改某一天的，工作计划计划，是否已经选择 
     *  
     * */
    void updateIsCanSelected1ByServiceUserIdAndServiceDate(Map<String,Object> param);
    
    
}