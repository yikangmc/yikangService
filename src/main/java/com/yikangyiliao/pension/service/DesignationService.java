package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Designation;
import com.yikangyiliao.pension.manager.DesignationManager;

@Service(value="designationService")
public class DesignationService {
	
	@Autowired
	private DesignationManager designationManager;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-07-01 13:53
	 * @desc 获取别番号列表
	 * **/
	public ResponseMessage<List<Designation>> getDesignations(Map<String,Object> paramMap){
		ResponseMessage<List<Designation>> resData=new ResponseMessage<List<Designation>>();
		List<Designation> data=designationManager.getDesignations();
		resData.setData(data);
		return resData;
	}
	

}
