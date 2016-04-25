package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.manager.TimeQuantumManager;

@Service(value="timeQuantumService")
public class TimeQuantumService {

	@Autowired
	private TimeQuantumManager timeQuantumManager;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/09 15:33
	 * 获取可以 预约的列表
	 * **/
	public Map<String,Object> getTimeQuantumsForCustomer(Map<String,Object> param){
		
		Map<String,Object> rtnMap=new HashMap<String, Object>();
		
		if(null != param.get("serviceDate")){
			List<Map<String,Object>> data= timeQuantumManager.getTimeQuantumsForCustomer(param);
			rtnMap.put("data", data);
			rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		}else{
			rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		
		return rtnMap;
		
	}
	
}
