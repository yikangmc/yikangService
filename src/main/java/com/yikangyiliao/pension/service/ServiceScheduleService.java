package com.yikangyiliao.pension.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.entity.ServiceSchedule;
import com.yikangyiliao.pension.entity.ServiceScheduleDetail;
import com.yikangyiliao.pension.entity.TimeQuantum;
import com.yikangyiliao.pension.manager.ServiceScheduleManager;
import com.yikangyiliao.pension.manager.TimeQuantumManager;

@Service("serviceScheduleService")
public class ServiceScheduleService {

	
	@Autowired
	private ServiceScheduleManager serviceScheduleManager;
	
	@Autowired
	private TimeQuantumManager timeQuantumManager;
	
	/**
	 * @author liushuaic
	 * @date 2015/09/17 15:50
	 * 查询某一个月的所有日期 
	 * 1.查询出某一个月内的，所有的记录
	 * 2.没有记录的，自动进行补全，可以添加记录
	 * 3.在用户点进入第二个页面时，如果那天没有 id 就需要，在方法中返回所有的 时间段，并设置没有选中
	 * 
	 * **/
	public Map<String,Object> getScheduleListByMonth(Map<String,Object> param){
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		
		
		if(
			null != param.get("year") &&  
			null != param.get("month")	
			){
			SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd");
			
			String year=param.get("year").toString();
			String month=param.get("month").toString();
			String userId=param.get("userId").toString();
			
			Integer yearInt=Integer.valueOf(year);
			Integer monthInt=Integer.valueOf(month);
			Long 	userIdLon	= Long.valueOf(userId);
			
			List<ServiceSchedule> scheduleList=serviceScheduleManager.getDayListByMonth(yearInt,monthInt,userIdLon);
			Calendar cl=Calendar.getInstance();
			cl.set(Calendar.YEAR,yearInt);
			cl.set(Calendar.MONTH,monthInt-1);
			int d=cl.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			List<ServiceSchedule> serviceSchedules=new ArrayList<ServiceSchedule>();
			
			for(int i=1;i<=d;i++){
				ServiceSchedule serviceSchedule=null;
				//查找出，那天的对象，跳出并在集合中移除，以减少循环次数
				for(int j=0;j<scheduleList.size();j++){
					int serviceDay=scheduleList.get(j).getServcieDay();
					if(i==serviceDay){
						serviceSchedule=scheduleList.get(j);
						serviceSchedule.setIsCanSelected(Byte.valueOf("1"));
						serviceSchedule.setServiceDateStr(sdf.format(serviceSchedule.getServiceDate()));
						scheduleList.remove(j);
						break;
					}
				}
				if(null == serviceSchedule){
					serviceSchedule=new ServiceSchedule();
					cl.set(Calendar.DATE,i);
					serviceSchedule.setServiceDate(cl.getTime());
					serviceSchedule.setServiceDateStr(sdf.format(cl.getTime()));
					serviceSchedule.setServcieDay(i);
					serviceSchedule.setServiceMonth(monthInt);
					serviceSchedule.setServiceYear(yearInt);
					// 0 表示是可以选择的
					serviceSchedule.setIsCanSelected((byte)isCanSubmit(cl.getTime()));  
					
				}
				serviceSchedules.add(serviceSchedule);
			}
			rtnMap.put("data", serviceSchedules);
			rtnMap.put("status",ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message",ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnMap.put( "status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put( "message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return rtnMap;
	}
	
	/**
	 * @author liushuaic
	 * @throws ParseException 
	 * @date 2015/09/17 18:49
	 * 获取某一天的具体工作内容
	 * **/
	public Map<String,Object> getServiceScheduleDetail(Map<String,Object> paramData) throws ParseException{
		Map<String,Object> rtnMap=new HashMap<String,Object>();

		SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		System.out.println("接收到请求的时间："+sdf2.format(new Date()));
		if(
			null != paramData.get("serviceDate") 
			){
			String userId=paramData.get("userId").toString();
			String serviceDate=paramData.get("serviceDate").toString();
			
			Map<String,Object> queryParam=new HashMap<String,Object>();
			
			queryParam.put("userId", userId);
			queryParam.put("serviceDate", serviceDate);
		
			Map<String,Object> rtnData=new HashMap<String,Object>();
			List<Map<String,Object>> data=serviceScheduleManager.getServiceScheduleDetailByUserIdAndSelectDate(queryParam);
			
			rtnData.put("data", data);
			
			//TODO 业务方法判断是否可以提交
			boolean haveDetail=false;
			for(Map<String,Object> detail:data){
				if(detail.containsKey("serviceScheduleDetailId")){
					haveDetail=true;
					break;
				}
			}
			if(haveDetail){
				rtnData.put("isCanSubmit", 1);
			}else{
				rtnData.put("isCanSubmit", isCanSubmitForDetail(sdf.parse(serviceDate)));
			}
			
			rtnMap.put("data", rtnData);
			rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message",ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnMap.put("status",  ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}

		

		System.out.println("查询并返回结果的时间的时间："+sdf2.format(new Date()));
		return rtnMap;
	}
	
	/**
	 * @author liushuaic
	 * @throws ParseException 
	 * @date 2015/09/17 18:58
	 * 添加某一天的工作时间
	 * 1.判断这天是否可以 提交
	 * 2.删除之前的数据 根据 时间，UserId
	 * 3.添加新的数据 修改 serviceSchedule 中的 isCanSelected 为1是已经做了选中  判断serviceSchedule 是否存在，存在修改，不存在添加
	 * 4.添加serviceScheduleDetail
	 * **/
	public Map<String,Object> insertServiceScheduleDetail(Map<String,Object> paramData) throws ParseException{
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		
		
		if(	
				null != paramData.get("serviceDate") && 
				null != paramData.get("timeQuantumIds")
			){
			
			String userId=paramData.get("userId").toString();
			String serviceDate=paramData.get("serviceDate").toString();
			
			List timeQuantumIds=(ArrayList)paramData.get("timeQuantumIds");
			
			paramData.put("serviceUserId", userId);
			
			Calendar cl=Calendar.getInstance();
			Long currentDateTime=cl.getTimeInMillis();
			
			
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date submitDate=sdf.parse(serviceDate);
			Calendar ca= Calendar.getInstance();
			ca.setTime(submitDate);
			
			ServiceSchedule serviceSchedule=serviceScheduleManager.getServiceSchedule(paramData);
			if(null != serviceSchedule){
				serviceScheduleManager.updateServiceScheduleIsCanSelected1(serviceSchedule.getServiceScheduleId());
			}else{
				serviceSchedule=new ServiceSchedule();
				serviceSchedule.setCreateTime(currentDateTime);
				serviceSchedule.setUpdateTime(currentDateTime);
				serviceSchedule.setIsCanSelected(Byte.valueOf("1"));
				serviceSchedule.setCreateUserId(Long.valueOf(userId));
				serviceSchedule.setServiceUserId(Long.valueOf(userId));
				serviceSchedule.setServiceYear(ca.get(Calendar.YEAR));
				serviceSchedule.setServiceMonth(ca.get(Calendar.MONTH)+1);
				serviceSchedule.setServcieDay(ca.get(Calendar.DAY_OF_MONTH));
				serviceSchedule.setServiceDate(sdf.parse(serviceDate));
				serviceScheduleManager.insertServiceSchduleSelective(serviceSchedule);
			}
			ServiceScheduleDetail serviceScheduleDetail=new ServiceScheduleDetail();
			serviceScheduleDetail.setCreateTime(currentDateTime);
			serviceScheduleDetail.setUpdateTime(currentDateTime);
			serviceScheduleDetail.setServiceScheduleId(serviceSchedule.getServiceScheduleId());
			serviceScheduleDetail.setCreateUserId(Long.valueOf(userId));
			for(int i=0;i<timeQuantumIds.size();i++){
				serviceScheduleDetail.setTimeQuantumId(Long.valueOf(timeQuantumIds.get(i).toString()));
				serviceScheduleManager.insertServiceScheduleDetail(serviceScheduleDetail);
			}
			
			rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message",ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnMap.put( "status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put( "message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return rtnMap;
		
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date  2015/09/18 17:58
	 * 
	 * 逻辑：
	 * 1，2，3，4，5，6，7
	 * 今天为4号
	 * 1，2号做了选择 那么是不能在提交的
	 * 3号没有做选择，也是不能提交的
	 * 4，5，6，也是不能提交的 必选要大于 今天 3天时间
	 * 7是可以修改的
	 * 是否可以提交本次操作
	 * @param  某个日期内的 工作日程数量
	 * @param  某个日期的   创建时间
	 * 
	 * 在有前端，如果某一个时间段被选中，后台服务人员，也是不能选的。
	 * 1443697809002
	 * 1442920221106
	 * 
	 * **/
	public int isCanSubmit(Date dataCreateDate){
		
		Date currentDateTime=Calendar.getInstance().getTime();
		long diff = dataCreateDate.getTime() - currentDateTime.getTime();
		//long days = diff / (1000 * 60 * 60 * 24);
		if(diff<=0){
			return 2;
		}
		
		return 0;
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/22 19:35 
	 * @desc 是否可以提交
	 * */
	public int isCanSubmitForDetail(Date dataCreateDate){
		
		Date currentDateTime=Calendar.getInstance().getTime();
		long diff = dataCreateDate.getTime() - currentDateTime.getTime();
	//	long days = diff / (1000 * 60 * 60 * 24);
		if(diff<=0){
			return 1;
		}
		
		return 0;
		
	}
 	
	/**
	 * @author liushuaic
	 * @date 2015/09/30 10:21
	 * 查询某一天的，可用服务时间
	 * 已经选择过的，不能在次选择
	 * @param selectDate 选择的时间
	 * @return 
	 */
	
	public Map<String,Object> getServiceDateBySelectDate(Map<String,Object> paramData){
		Map<String,Object> rtnMap=new HashMap<String, Object>();
		if(null != paramData.get("selectDate")){
			
			List<TimeQuantum> timeQuantums=timeQuantumManager.getAllTimeQuantum();
			for(TimeQuantum TimeQuantum:timeQuantums){
				
			}
			rtnMap.put("timeQuantums", timeQuantums);
			rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message",ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnMap.put( "status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put( "message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return rtnMap;
	}
	
	
	
	
}
