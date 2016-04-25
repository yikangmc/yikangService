package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.AppointmentOrderDao;
import com.yikangyiliao.pension.entity.AppointmentOrder;
import com.yikangyiliao.pension.entity.AppointmentOrderServiceModel;

@Component
public class AppointmentOrderManager {
	
	@Autowired
	private AppointmentOrderDao appointmentOrderDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/08 14:55
	 * 添加订单
	 * 
	 * */
	public int insertSelective(AppointmentOrder record){
		return appointmentOrderDao.insertSelective(record);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/08 15:04
	 * 修改定单状态为：进行中
	 * **/
	public int updateAppointmentOrderStatusIsWorking(Long appointmentOrderId){

		Map<String,Object> param=new HashMap<String, Object>();
		param.put("orderStatus", 1);
		param.put("appointmentOrderId", appointmentOrderId);
		return appointmentOrderDao.updateAppointmentOrderStatus(param);
		
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/10/08 15:04
	 * 修改定单状态为：已完成
	 * **/
	public int updateAppointmentOrderStatusIsFinish(Long appointmentOrderId){

		Map<String,Object> param=new HashMap<String, Object>();
		param.put("orderStatus", 2);
		param.put("appointmentOrderId", appointmentOrderId);
		return appointmentOrderDao.updateAppointmentOrderStatus(param);
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/08 15:55
	 * 修改定单状态为：已评价
	 * 
	 * */
	public int updateAppointmentOrderStatusIsEvaluated(Long appointmentOrderId){
		Map<String,Object> param=new HashMap<String, Object>();
		param.put("orderStatus", 3);
		param.put("appointmentOrderId", appointmentOrderId);
		return appointmentOrderDao.updateAppointmentOrderStatus(param);
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/09 18:22
	 * @desc 查询用户信息根据 预约单号
	 * */
	public Map<String,Object> getUserServiceInfoByOrderId(Long orderId){
		return appointmentOrderDao.getUserServiceInfoByOrderId(orderId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/10/10 14:13
	 * 获取某一个定单的信息
	 * */
	public AppointmentOrder getAppointmentOrderByOrderId(Long appointmentOrderId){
		return appointmentOrderDao.selectByPrimaryKey(appointmentOrderId);
	}
	
	
	/**
     * @author liushuaic
     * @date 2015/11/18 17:36
     * @desc 查询的我工作日程
     * **/
	public List<Map<String,Object>> getServicerScheduleByServiceUserId(Integer serviceDetailStatus,Long serviceUserId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("serviceUserId", serviceUserId);
		paramData.put("serviceDetailStatus", serviceDetailStatus);
		return appointmentOrderDao.getServicerScheduleByServiceUserId(paramData);
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016/01/29 18:23
	 * @desc 获取某一个用户的定单列表
	 * */
	public List<AppointmentOrderServiceModel> getAppointmentOrderListPageByUserId(Map<String, Object> paramData){
		return appointmentOrderDao.getAppointmentOrderListPageByUserId(paramData);
	}
	
}
