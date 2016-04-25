package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.yikangyiliao.pension.dao.ServiceScheduleDao;
import com.yikangyiliao.pension.dao.ServiceScheduleDetailDao;
import com.yikangyiliao.pension.entity.ServiceSchedule;
import com.yikangyiliao.pension.entity.ServiceScheduleDetail;

@Component
public class ServiceScheduleManager {
	
	@Autowired
	private ServiceScheduleDao serviceScheduleDao;
	
	@Autowired
	private ServiceScheduleDetailDao serviceScheduleDetailDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/16 17:46
	 * @param year 年
	 * @param month 月
	 * @param userId 用户id
	 * 
	 * **/
	public List<ServiceSchedule> getDayListByMonth(Integer year,Integer month,Long userId){
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("serviceYear", year);
		param.put("serviceMonth", month);
		param.put("userId", userId);
		return serviceScheduleDao.getServiceScheduleByServiceYearAndServiceMonth(param);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/17 15:28
	 * 获取某一天计划的，详细内容
	 * 
	 * **/
	public	List<Map<String,Object>> getServiceScheduleDetailByServiceScheduleId(Long  srviceScheduleId){
		return serviceScheduleDetailDao.getServiceScheduleDetailByServiceScheduleId(srviceScheduleId);
	}

	/**
	 * @author liushuaic
	 * @date 2015/09/16 17:57
	 * 添加可用时间详情
	 * **/
	public int  insertServiceScheduleDetail(ServiceScheduleDetail record){
		
		return serviceScheduleDetailDao.insertSelective(record);
		
	}
	
	
	 
    /**
     * @author liushuaic
     * @date 2015/09/17 18:36
     * 查询某一天的工作计划的内容
     * @param serviceDate 
     * @param serviceUserId
     * **/
	public List<Map<String,Object>> getServiceScheduleDetailByUserIdAndSelectDate(Map<String,Object> paramData){
    	return serviceScheduleDetailDao.getServiceScheduleDetailByUserIdAndSelectDate(paramData);
    }
	
	
    /**
     * @author liushuaic
     * @date 2015/09/17 18:36
     * 查询某一天的工作记录
     * @param serviceDate 
     * @param serviceUserId
     * **/
	public ServiceSchedule getServiceSchedule(Map<String,Object> param){
		return serviceScheduleDao.getServiceSchedule(param);
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/18 18:36
	 * 修改某一天的，工作计划计划，是否已经选择 
	 * @param serviceScheduleId
     * @param updateTime
	 * */
	public void updateServiceScheduleIsCanSelected1(Long serviceScheduleId){
		Map<String,Object> param=new HashMap<String, Object>();
		param.put("serviceScheduleId", serviceScheduleId);
		param.put("updateTime", Calendar.getInstance().getTime().getTime());
		serviceScheduleDao.updateIsCanSelected1ByServiceScheduleId(param);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/18
	 * 添加ServiceSchdule
	 * **/
	public int insertServiceSchduleSelective(ServiceSchedule serviceSchedule){
		return serviceScheduleDao.insertSelective(serviceSchedule);
	}
}
