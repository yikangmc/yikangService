package com.yikangyiliao.pension.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yikangyiliao.base.utils.DateUtils;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.page.PageParameter;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.common.utils.GenreateNumberUtils;
import com.yikangyiliao.pension.common.utils.map.MapUtils;
import com.yikangyiliao.pension.common.utils.map.model.GeoCodeModel;
import com.yikangyiliao.pension.entity.AppointmentOrder;
import com.yikangyiliao.pension.entity.AppointmentOrderServiceModel;
import com.yikangyiliao.pension.entity.OrderServiceDetail;
import com.yikangyiliao.pension.entity.SeniorAccount;
import com.yikangyiliao.pension.entity.SeniorLivingCondition;
import com.yikangyiliao.pension.entity.TimeQuantum;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.AppointmentOrderManager;
import com.yikangyiliao.pension.manager.OrderServiceDetailManager;
import com.yikangyiliao.pension.manager.SeniorAccountManager;
import com.yikangyiliao.pension.manager.SeniorLivinConditionManager;
import com.yikangyiliao.pension.manager.TimeQuantumManager;
import com.yikangyiliao.pension.manager.UserFromManager;
import com.yikangyiliao.pension.schedule.PersonnelDistribution;

@Service(value="appointmentOrderService")
public class AppointmentOrderService {

	
	@Autowired
	private AppointmentOrderManager appointmentOrderManager;
	
	@Autowired
	private OrderServiceDetailManager orderServiceDetailManager;
	
	@Autowired
	private PersonnelDistribution personnelDistribution;
	
	@Autowired
	private TimeQuantumManager timeQuantumManager;
	
	@Autowired
	private GenreateNumberUtils genreateNumberUtils;
	
	@Autowired
	private SeniorAccountManager seniorAccountManager;
	
	@Autowired
	private SeniorLivinConditionManager seniorLivinConditionManager;
	
	
	@Autowired
	private UserFromManager userFromManager;
	
	
	public Map<String,Object> addPointmentOrder(Map<String,Object> param) throws ParseException, InterruptedException{
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		if(	
			 null != param.get("phoneNumber")
			&& null != param.get("nickName")
			&& null != param.get("appointmentDateTime")
			&& null != param.get("timeQuantumId")
			&& null != param.get("startTime")
			&& null != param.get("endTime")
			&& null != param.get("districtCode")
			&& null != param.get("detailAddress")
			&& null != param.get("mapPostionAddress")
			&& null != param.get("dataSource")
			&& null != param.get("dataGroup")
			&& null != param.get("linkUserName")
		){
			
				Long currentDateTimeMillis=Calendar.getInstance().getTimeInMillis();
				Date currentDate=Calendar.getInstance().getTime();
			
			
				AppointmentOrder appointmentOrder =new AppointmentOrder();
				
				 String parentLinkAddress	=  param.get("parentLinkAddress").toString();
				 String phoneNumber			=  param.get("phoneNumber").toString();
				 String myPhoneNumber		=  param.get("myPhoneNumber").toString();
				 String nickName			=  param.get("nickName").toString();
				 String appointmentDateTime	=  param.get("appointmentDateTime").toString();
				 String timeQuantumId		=  param.get("timeQuantumId").toString();
				 String districtCode		=  param.get("districtCode").toString();
				 String longitude			=  param.get("longitude").toString();
				 String latitude			=  param.get("latitude").toString();
				 String detailAddress		=  param.get("detailAddress").toString();
				 String mapPostionAddress	=  param.get("mapPostionAddress").toString();
				 String dataSource			=  param.get("dataSource").toString();
				 String dataGroup			=  param.get("dataGroup").toString();
				 String linkUserName		=  param.get("linkUserName").toString();
				
				
				 appointmentOrder.setParentLinkAddress(parentLinkAddress);
				 appointmentOrder.setPhoneNumber(phoneNumber);
				 appointmentOrder.setMyPhoneNumber(myPhoneNumber);
				 appointmentOrder.setNickName(nickName);
				 appointmentOrder.setAppointmentDateTime(DateUtils.getＭillisecond(appointmentDateTime));
				 appointmentOrder.setTimeQuanturmId(Long.valueOf(timeQuantumId));
				 appointmentOrder.setLinkUserName(linkUserName);
				 
				 TimeQuantum timeQuantum=timeQuantumManager.getTimeQuantumsById(Long.valueOf(timeQuantumId));
				 
				 
				 appointmentOrder.setStartTime(timeQuantum.getStartTime().toString());
				 appointmentOrder.setEndTime(timeQuantum.getEndTime().toString());
				 
				 
				//todo 
				 appointmentOrder.setProvenceCode("");
				 appointmentOrder.setCityCode("");
				 
				 
				 appointmentOrder.setDistrictCode(districtCode);
				 appointmentOrder.setLongitude(Double.valueOf(longitude));
				 appointmentOrder.setLatitude(Double.valueOf(latitude));
				 appointmentOrder.setDetailAddress(detailAddress);
				 appointmentOrder.setMapPostionAddress(mapPostionAddress);
				 appointmentOrder.setServiceCount(Integer.valueOf("1"));
				 appointmentOrder.setDataSource(Byte.valueOf(dataSource));
				 appointmentOrder.setDataGroup(Byte.valueOf(dataGroup));
				 appointmentOrder.setCreateTime(currentDateTimeMillis);
				 appointmentOrder.setUpdateTime(currentDateTimeMillis);
				 appointmentOrder.setOrderStatus(0);
				 appointmentOrder.setAssessmentId(-1l);
				 appointmentOrder.setOrderNumber("");
				 
				 
				 appointmentOrderManager.insertSelective(appointmentOrder);
				 
				 
				 OrderServiceDetail orderServiceDetail=new OrderServiceDetail();
				 orderServiceDetail.setOrderId(appointmentOrder.getAppointmentOrderId());
				 orderServiceDetail.setCreateTime(currentDateTimeMillis);
				 orderServiceDetail.setUpdateTime(currentDateTimeMillis);
				 orderServiceDetail.setCertainServiceUserStatus((byte)1);
				 orderServiceDetail.setServiceDetailStatus((byte)1);
				 orderServiceDetail.setTimeQuantumId(Long.valueOf(timeQuantumId));
				 orderServiceDetail.setAppointmentDate(appointmentDateTime);
				 orderServiceDetail.setServiceUserId(-1l);
				 orderServiceDetail.setServiceType((byte)0);
				 
				 orderServiceDetailManager.insertSelective(orderServiceDetail);
				 
				 personnelDistribution.orderIdsQueue.put(appointmentOrder.getAppointmentOrderId());
				 
				rtnMap.put("orderId", appointmentOrder.getAppointmentOrderId());
			 	rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			 	rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
		
		return rtnMap;
		
		
	}
	
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/15 10:16
	 * @desc 添加定单幷添加评估人员
	 * 
	 * **/
	public Map<String,Object> addPointmentOrderAndSubmitAssessment(Map<String,Object> param) throws ParseException, InterruptedException{
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		if(	
			 null != param.get("phoneNumber")
			&& null != param.get("appointmentDateTime")
			&& null != param.get("timeQuantumId")
			&& null != param.get("startTime")
			&& null != param.get("endTime")
			&& null != param.get("districtCode")
			&& null != param.get("detailAddress")
			&& null != param.get("mapPositionAddress")
			&& null != param.get("dataSource")
			&& null != param.get("dataGroup")
			&& null != param.get("linkUserName")
			&& null != param.get("serviceUserId")
		){
			
				
				 String serviceUserId		=  param.get("serviceUserId").toString();
				
				if(checkServicerTimeQuantum(Long.valueOf(serviceUserId))){
					Long currentDateTimeMillis=Calendar.getInstance().getTimeInMillis();
					Date currentDate=Calendar.getInstance().getTime();
				
				
					AppointmentOrder appointmentOrder =new AppointmentOrder();
					
					 String phoneNumber			=  param.get("phoneNumber").toString();
					 String appointmentDateTime	=  param.get("appointmentDateTime").toString();
					 String timeQuantumId		=  param.get("timeQuantumId").toString();
					 String districtCode		=  param.get("districtCode").toString();
					 String detailAddress		=  param.get("detailAddress").toString();
					 String mapPositionAddress	=  param.get("mapPositionAddress").toString();
					 String dataSource			=  param.get("dataSource").toString();
					 String dataGroup			=  param.get("dataGroup").toString();
					 String linkUserName		=  param.get("linkUserName").toString();
					 String userId				=  param.get("userId").toString();
					 
					 appointmentOrder.setParentLinkAddress("");
					 appointmentOrder.setPhoneNumber(phoneNumber);
					 appointmentOrder.setMyPhoneNumber("");
					 appointmentOrder.setNickName("");
					 appointmentOrder.setAppointmentDateTime(DateUtils.getＭillisecond(appointmentDateTime));
					 appointmentOrder.setTimeQuanturmId(Long.valueOf(timeQuantumId));
					 appointmentOrder.setLinkUserName(linkUserName);
					 
					 // 冗余数据设置的评估师 
					 appointmentOrder.setAssessmentId(Long.valueOf(serviceUserId));
					 
					 TimeQuantum timeQuantum=timeQuantumManager.getTimeQuantumsById(Long.valueOf(timeQuantumId));
					 appointmentOrder.setStartTime(timeQuantum.getStartTime().toString());
					 appointmentOrder.setEndTime(timeQuantum.getEndTime().toString());
					 
					 appointmentOrder.setProvenceCode("");
					 appointmentOrder.setCityCode("");
					 
					 
					 appointmentOrder.setDistrictCode(districtCode);
					 
					 
					 appointmentOrder.setDetailAddress(detailAddress);
					 appointmentOrder.setMapPostionAddress(mapPositionAddress);
					 appointmentOrder.setServiceCount(Integer.valueOf("1"));
					 appointmentOrder.setDataSource(Byte.valueOf(dataSource));
					 appointmentOrder.setDataGroup(Byte.valueOf(dataGroup));
					 appointmentOrder.setCreateTime(currentDateTimeMillis);
					 appointmentOrder.setUpdateTime(currentDateTimeMillis);
					 appointmentOrder.setOrderStatus(0);
					 
					 // 生成订单编号
					 appointmentOrder.setOrderNumber(genreateNumberUtils.generateAppointmentOrderNumber());
					 double log=0;
					 double lat=0;
					 //设置经纬度
					 try {
						 GeoCodeModel geoCodeModel=MapUtils.getGeoCodeModelByAddress(detailAddress, null);
						 if(null != geoCodeModel.getGeocodes() && geoCodeModel.getGeocodes().size()>0){
							 //  TODO 有可能模糊地址对应的有多个这个问题要修改
							 String lngLatStr=geoCodeModel.getGeocodes().get(0).getLocation();
							 String lngStr=lngLatStr.split(",")[0];
							 String latStr=lngLatStr.split(",")[1];
							 
							 log=Double.valueOf(lngStr);
							 lat=Double.valueOf(latStr);
							 
							 appointmentOrder.setLongitude(Double.valueOf(lngStr));
							 appointmentOrder.setLatitude(Double.valueOf(latStr));
						 }
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					 
					 
					 
					 appointmentOrder.setAddress("");
					
					 
					 appointmentOrderManager.insertSelective(appointmentOrder);
					 
					 
					 OrderServiceDetail orderServiceDetail=new OrderServiceDetail();
					 orderServiceDetail.setOrderId(appointmentOrder.getAppointmentOrderId());
					 orderServiceDetail.setCreateTime(currentDateTimeMillis);
					 orderServiceDetail.setUpdateTime(currentDateTimeMillis);
					 
					 orderServiceDetail.setCertainServiceUserStatus((byte)1);
					 orderServiceDetail.setServiceDetailStatus((byte)1);
					 
					 orderServiceDetail.setTimeQuantumId(Long.valueOf(timeQuantumId));
					 
					 
					 //设置服务预约时间
					 orderServiceDetail.setAppointmentDate(appointmentDateTime);
					 //设置真实上门服务时间
					 orderServiceDetail.setServiceDate(DateUtils.getDate(appointmentDateTime));
					 
					 // 设置服务人员的，服务id
					 orderServiceDetail.setServiceUserId(Long.valueOf(serviceUserId));
					 
					 
					 orderServiceDetail.setServiceType((byte)0);
					 
					 orderServiceDetail.setServiceRecord("");
					 
					 orderServiceDetailManager.insertSelective(orderServiceDetail);
					 
					 
					 
					 SeniorAccount seniorAccount=new SeniorAccount();
					 //设置创建用户
					 seniorAccount.setCreateUserId(Long.valueOf(userId));
					 seniorAccount.setCreateTime(currentDateTimeMillis);
					 seniorAccount.setPhoneNo(phoneNumber);
					 seniorAccount.setName(linkUserName); //设置患者名称
					 
					 seniorAccountManager.insertSelective(seniorAccount);
					 
					 SeniorLivingCondition seniorLivingCondition=new SeniorLivingCondition();
					 seniorLivingCondition.setLongitude(log);
					 seniorLivingCondition.setLatitude(lat);
					 seniorLivingCondition.setDistrict(districtCode);
					 
					 seniorLivinConditionManager.insertSelective(seniorLivingCondition);
					 
					 
					 
					 
					 
					 Map<String,Object> rtnData=new HashMap<String, Object>();
					 
					 rtnData.put("orderId", appointmentOrder.getAppointmentOrderId());
					 rtnMap.put("data",rtnData);
				 	 rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				 	 rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
				}else{
					// 服务人员，已经被选择
					rtnMap.put("status", ExceptionConstants.orderException.serviceUserHasBeenSelected.errorCode);
					rtnMap.put("message", ExceptionConstants.orderException.serviceUserHasBeenSelected.errorMessage);
				}
				 
			}else{
				rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
		
		return rtnMap;
		
		
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/15 11:00
	 * 确认服务人员的服务时间，是否有问题
	 * 
	 * **/
	public boolean checkServicerTimeQuantum(Long serviceUserId){
		
		
		//1.重新确定距离时间 ，是否合适 。查询出来，最新的一个订单的，服务地址与  客户最近的。员工
		//2.如果没有，定单，就是住址。计算，最近的距离
		
		
		return true;
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/09 15:46 
	 * 获取某一个，预约单的，评估师
	 * */
	public Map<String,Object> getServiceUserByOrderId(Map<String,Object> param){
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		
		if(null != param.get("orderId")){
			String orderId=param.get("orderId").toString();
			
			UserServiceInfo userServiceInfo=null;
			
			int i=0;
			while(i<6){
				try {
					
					OrderServiceDetail orderServiceDetail=orderServiceDetailManager.getEstimateOrderServiceDetailByOrderId(Long.valueOf(orderId));
					//判断是否，已经确定服务人员
					if(orderServiceDetail.getCertainServiceUserStatus()!=-1){
						break;
					}
					
					Thread.sleep(1000);
					i++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
			if(i==6){
			 	rtnMap.put("status", "001111");
			 	rtnMap.put("message", "没有分配到合适的联系人！");
			}else{
				rtnMap.put("serviceUser", userServiceInfo);
			 	rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			 	rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}
			

			
		}else{
			rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return rtnMap;
	
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/11/15 15:27
	 * @desc 保存反馈 ，并修改订单服务状态为
	 * */
	public Map<String,Object> saveFeedback(Map<String,Object> paramData){
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		if(	
			paramData.containsKey("orderServiceDetailId")
				){
			String feedback="";
			if(paramData.containsKey("feedback")){
				feedback=paramData.get("feedback").toString();
			}
			String orderId=paramData.get("orderServiceDetailId").toString();
			String userId=paramData.get("userId").toString();
			orderServiceDetailManager.updateFeedbackDetailStatus5FeedBackByOrderServiceDetailIdAndServiceUserId(
					feedback, Long.valueOf(userId), Long.valueOf(orderId));
		 	rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		 	rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnMap;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/11/16 11:09
	 * @desc 查询订单详情
	 * */
	public Map<String,Object> getOrderServiceDetailById(Map<String,Object> paramData){
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		
		if(  
			paramData.containsKey("orderServiceDetailId")
		 ){
			Long orderServiceDetailId=Long.valueOf(paramData.get("orderServiceDetailId").toString());
			Long serviceUserId=Long.valueOf(paramData.get("userId").toString());
			Map<String,Object> data=orderServiceDetailManager.getOrderServiceDetailByOrderServiceDetailIdAndUserId(orderServiceDetailId,serviceUserId);
			rtnMap.put("data", data);
		 	rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
		 	rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return rtnMap;
	}
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/11/18 18:44
	 * @desc 查询某一个用户的工作日程
	 * 
	 * */
	public Map<String,Object> getServicerScheduleByServiceUserId(Map<String,Object> paramData){
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		
		if(paramData.containsKey("serviceDetailStatus")){
			String serviceDetailStatus=paramData.get("serviceDetailStatus").toString();
			if(null != serviceDetailStatus &&
				(serviceDetailStatus.equals("-1")|| serviceDetailStatus.equals("0") ||serviceDetailStatus.equals("1"))){
				String userId=paramData.get("userId").toString();
				List<Map<String,Object>> rtnData=appointmentOrderManager.getServicerScheduleByServiceUserId(Integer.valueOf(serviceDetailStatus),Long.valueOf(userId));
				rtnMap.put("data",rtnData);
			 	rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			 	rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}else{
				rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
				rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
			}
		}else{
			rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
	
		
		return rtnMap;
		
	}
	
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-02-25 18:39
	 * 查询某一个用户下的所有订单
	 * */
	public ResponseMessage getAppointmentOrderListPageByUserId(Map<String,Object> paramData){
		ResponseMessage responseMessage=new ResponseMessage();
		
		try{
			if(paramData.containsKey("page")){
				PageParameter page=new PageParameter();
				paramData.put("page", page);
			}
			List<AppointmentOrderServiceModel> data=appointmentOrderManager.getAppointmentOrderListPageByUserId(paramData);
			responseMessage.setData(data);
			responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
			responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
			
		}catch(Exception e){
			e.printStackTrace();
			responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return responseMessage;
	}
	
	
	
	
	
	
	
	
}
