package com.yikangyiliao.pension.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.base.utils.AliasFactory;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.entity.Device;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserDeviceTab;
import com.yikangyiliao.pension.manager.DeviceManager;
import com.yikangyiliao.pension.manager.UserManager;



@Service(value="deviceService")
public class DeviceService {

	
	@Autowired
	private DeviceManager deviceManager;
	
	@Autowired
	private UserManager userManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/26 16:53 
	 *  添加设备
	 *  deviceType  设备类型
	 *  deviceCode  设备编码
	 *  codeType	编码类型
	 *  
	 * **/
	//TODO 设备注册失败，犹豫userId 没有不能没有 在拦截器自动设置 userId
	public Map<String,Object> saveDevice(Map<String,Object> paramData){
		Map<String,Object> rtnData=new HashMap<String,Object>();
		if(
			paramData.containsKey("deviceType")
			&&paramData.containsKey("deviceCode")
			&&paramData.containsKey("codeType")
			){
			
			Long currentDateTime=Calendar.getInstance().getTimeInMillis();
			
			String deviceType=paramData.get("deviceType").toString();
			String deviceCode=paramData.get("deviceCode").toString();
			String codeType=paramData.get("codeType").toString();
			
			String userId=paramData.get("userId").toString();
			
			// 修改之前的设备为不 使用的
			deviceManager.updateDeviceIsUsedIs0ByUserId(Long.valueOf(userId));
			
			Device device=new Device();
			device.setCodeType(codeType);
			device.setDeviceType(Byte.valueOf(deviceType));
			device.setDeviceCode(deviceCode);
			device.setCreateTime(currentDateTime);
			device.setUpdateTime(currentDateTime);
			device.setIsUsed((byte)1); //设置为当前使用的
			device.setPushAlias(AliasFactory.generateAliasByUser(userId));//设置设备别名
			deviceManager.insertDeviceSelective(device);
			
			
			
			UserDeviceTab userDeviceTab=new UserDeviceTab();
			userDeviceTab.setCreateTime(currentDateTime);
			userDeviceTab.setUpdateTime(currentDateTime);
			userDeviceTab.setUserId(Long.valueOf(userId));
			userDeviceTab.setDeviceId(device.getDeviceId());
			
			
			
			deviceManager.insertUserDeviceSelective(userDeviceTab);
			
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnData.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnData.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnData;
	}
	
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/09/16 10:49
	 * @desc 获取用户的设备别名
	 * 
	 * **/
	public Map<String,Object> getAliasByUser(Map<String,Object> paramData){
		
		Map<String,Object> rtnData=new HashMap<String,Object>();
		
		if(null != paramData.get("userId")){
			String userId=paramData.get("userId").toString();
			
			Map<String,String> dataMap=new HashMap<String,String>();
			
			//Device device=deviceManager.getIsUsedDeviceByUserId(Long.valueOf(userId));
			User user=userManager.getUserByUserId(Long.valueOf(userId));
			
			if(null != user){
				dataMap.put("alias", user.getPushAlias());
			}
			
			rtnData.put("data", dataMap);
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnData.put("status", ExceptionConstants.systemException.systemException.errorCode);
			rtnData.put("message",ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return rtnData;
		
	}
	
	
	
}
