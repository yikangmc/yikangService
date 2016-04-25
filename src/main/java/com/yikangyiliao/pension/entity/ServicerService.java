package com.yikangyiliao.pension.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.manager.UserManager;

/**
 * @author liushuaic
 * @date 2015/10/14 19:11
 * @desc 服务人员service
 * 
 * 
 * **/

@Service(value="servicerService")
public class ServicerService {
	
	
	
	@Autowired
	private UserManager userManager;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/14 19:52
	 * 获取有空闲时间的评估师
	 * **/
	public Map<String,Object> getAssessmentService(Map<String,Object> paramData){
		
		Map<String,Object> rtnMap=new HashMap<String,Object>();
		
		if(
			null != paramData.get("districtCode")
			&& null != paramData.get("mapPositionAddress")
			&& null != paramData.get("detailAddress")
			&& null != paramData.get("serviceDate")
			&& null != paramData.get("custumerTimeQuantumId")
		){
			
			Map<String,Object> pingGuData=userManager.getPingGuServicerByUserId(18l);
			
			
			if(pingGuData==null ){
				rtnMap.put("status", ExceptionConstants.servicerException.servicerNoBady.errorCode);
				rtnMap.put("message", ExceptionConstants.servicerException.servicerNoBady.errorMessage);
			}else{
				rtnMap.put("data", pingGuData);
				rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}
			

		}else{
			rtnMap.put( "status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put( "message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnMap;
	}

}
