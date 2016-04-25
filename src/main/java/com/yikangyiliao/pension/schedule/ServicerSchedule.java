package com.yikangyiliao.pension.schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.entity.ServiceSchedule;
import com.yikangyiliao.pension.entity.ServiceScheduleDetail;
import com.yikangyiliao.pension.entity.TimeQuantum;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.ServiceScheduleManager;
import com.yikangyiliao.pension.manager.TimeQuantumManager;
import com.yikangyiliao.pension.manager.UserManager;

/**
 * @author liushuaic
 * @date 2015/09/17 10:54 
 * 服务人员定时任务表
 * 生动生成，下一天的工作内容
 * 后期自己定义工作时间，
 * 1.判断是否已经生成。
 * 2.如果生成，就不在生成。
 * 3.如果没有，就生成记录。
 * **/

@Component(value="servicerScheudle")
public class ServicerSchedule {
	
	@Autowired
	private ServiceScheduleManager serviceScheduleManager;
	
	
	@Autowired
	private TimeQuantumManager timeQuantumManager;

	
	@Autowired
	private UserManager userManager;
	
	
	/**
	 * @author liushuaic
	 * @throws ParseException 
	 * @date  2015/09/17 11:04
	 * 为评估服务人员生成 每天的，可服务时间段
	 * 
	 * */
	public void GenerateServiceSchedulDetailForServicerPingGu() throws ParseException{
		
		List<UserServiceInfo> userServiceInfoList= userManager.getPingGuServiceAll();
		List<TimeQuantum> timeQuantumList=timeQuantumManager.getAllTimeQuantum();
		
		Calendar currentCalendar=Calendar.getInstance();
		Date currentDateTime=currentCalendar.getTime();
		
		Calendar cl=Calendar.getInstance();
		int year=currentCalendar.get(Calendar.YEAR);
		int month=currentCalendar.get(Calendar.MONTH);
		int date=currentCalendar.get(Calendar.DATE);
		cl.set(year,month,date,0, 0, 0);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
		
		String str=sdf.format(cl.getTime());
		//　格式为：　2015-09-18 00:00:00.0　　用于在保存服务时间时
		Date currentDate=sdf2.parse(str);
		
		if(null != userServiceInfoList){
			
			// 工作日程
			ServiceSchedule serviceSchedule=new ServiceSchedule();
			serviceSchedule.setCreateTime(currentDateTime.getTime());
			serviceSchedule.setUpdateTime(currentDateTime.getTime());
			serviceSchedule.setServiceDate(currentDate);
			serviceSchedule.setServiceYear(year);
			serviceSchedule.setServiceMonth(month+1);
			serviceSchedule.setServcieDay(date);
			
			// 工作日程详情
			ServiceScheduleDetail serviceScheduleDetail=new ServiceScheduleDetail();
			serviceScheduleDetail.setCreateTime(currentDateTime.getTime());
			serviceScheduleDetail.setUpdateTime(currentDateTime.getTime());
			//  -1 为系统添加
			serviceScheduleDetail.setCreateUserId(-1l);
			
			
			Map<String,Object> paramMap=new HashMap<String,Object>();
			paramMap.put("serviceDate", currentDate);
			
			for(UserServiceInfo userServiceInfo:userServiceInfoList){
				
				
				Long userId=userServiceInfo.getUserId();
				
				paramMap.put("serviceUserId", userId);
				//TODO 可以把userId 用in 一起查询出来。可以 做个优化
				ServiceSchedule serviceScheduleForIf=serviceScheduleManager.getServiceSchedule(paramMap);
				
				if(null == serviceScheduleForIf){
					serviceSchedule.setServiceUserId(userId);
					serviceSchedule.setIsCanSelected((byte)1);
					serviceSchedule.setServiceScheduleId(null);// 设置id 为null 不然会插入上一次的。
					serviceSchedule.setCreateUserId(-1l);
					
					serviceScheduleManager.insertServiceSchduleSelective(serviceSchedule);
					serviceScheduleDetail.setServiceScheduleId(serviceSchedule.getServiceScheduleId());
					
					//TODO 可以把timeQuantumIds 做成一个集合一起 保存
					for(TimeQuantum timeQuantum:timeQuantumList){
						serviceScheduleDetail.setServiceScheduleDetailId(null);
						serviceScheduleDetail.setTimeQuantumId(timeQuantum.getTimeQuantumId());
						serviceScheduleManager.insertServiceScheduleDetail(serviceScheduleDetail);
					}
				}

			}
		}
	}


	public ServiceScheduleManager getServiceScheduleManager() {
		return serviceScheduleManager;
	}


	public void setServiceScheduleManager(ServiceScheduleManager serviceScheduleManager) {
		this.serviceScheduleManager = serviceScheduleManager;
	}


	public TimeQuantumManager getTimeQuantumManager() {
		return timeQuantumManager;
	}


	public void setTimeQuantumManager(TimeQuantumManager timeQuantumManager) {
		this.timeQuantumManager = timeQuantumManager;
	}


	public UserManager getUserManager() {
		return userManager;
	}


	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
}
