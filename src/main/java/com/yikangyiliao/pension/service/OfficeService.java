package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Office;
import com.yikangyiliao.pension.manager.OfficeManager;

@Service(value="officeService")
public class OfficeService {

	@Autowired
	private OfficeManager officeManager;
	
	
	
	public ResponseMessage getOffice(Map<String,Object> paramData){
		ResponseMessage responseMessage=new ResponseMessage();
		
		try{
			List<Office> data=officeManager.getOffices();
			responseMessage.setData(data);
			responseMessage.setStatus(ExceptionConstants.responseSuccess.responseSuccess.code);
			responseMessage.setMessage(ExceptionConstants.responseSuccess.responseSuccess.message);
		}catch(Exception e){
			responseMessage.setStatus(ExceptionConstants.systemException.systemException.errorCode);
			responseMessage.setMessage(ExceptionConstants.systemException.systemException.errorMessage);
		}
		
		return responseMessage;
	}
	
	
	
}
