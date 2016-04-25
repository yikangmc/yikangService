package com.yikangyiliao.pension.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ServiceScheduleDetailDao;

@Component
public class ServiceScheduleDetailManager {

	@Autowired
	private ServiceScheduleDetailDao serviceScheduleDetailDao;
	
	
	
	/**
     * @author liushuaic
     * @date 2015/09/17 13:52
     * 查询某一天的工作计划的内容
     * **/
   public List<Map<String,Object>> getServiceScheduleDetailByServiceScheduleId(Long serviceScheduleId){
    	return serviceScheduleDetailDao.getServiceScheduleDetailByServiceScheduleId(serviceScheduleId);
    }
   
   
	
	
}
