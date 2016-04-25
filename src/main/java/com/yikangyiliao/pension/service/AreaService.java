package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.manager.AreaManager;


@Service(value="areaService")
public class AreaService {
	
	@Autowired
	private AreaManager areaManager;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:44 
	 * 修改用户信息
	 * **/
	public Map<String,Object> updateUser(Map<String,Object> paramData){
		Map<String,Object> rtnData=new HashMap<String,Object>();
			
			areaManager.getAreaCityDistrict();
			rtnData.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
			rtnData.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
		
		return rtnData;
	}

}
