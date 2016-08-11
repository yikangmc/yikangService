package com.yikangyiliao.pension.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.UpdateVersion;
import com.yikangyiliao.pension.manager.UpdateVersionManager;

@Service(value = "updateVersionService")
public class UpdateVersionService {
	
	@Autowired
	private UpdateVersionManager updateVersionManager;
	
	private Logger logger=LoggerFactory.getLogger(UpdateVersionService.class);
	
	public ResponseMessage<UpdateVersion> selectUpdateVersionById(Map<String, Object> mobilePhoneType){
		ResponseMessage<UpdateVersion> rDate = new ResponseMessage<UpdateVersion>();
		UpdateVersion updateVersion = updateVersionManager.getUpdateVersionByMobilePhoneType(mobilePhoneType);
		rDate.setData(updateVersion);
		return rDate;
	}
	
}
