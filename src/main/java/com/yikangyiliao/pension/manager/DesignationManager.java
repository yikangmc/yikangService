package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.DesignationDao;
import com.yikangyiliao.pension.entity.Designation;

@Component
public class DesignationManager {
	
	@Autowired
	private DesignationDao designationDao;
	
	/**
     * @author liushuaic
     * @date 2016-07-01 11:41
     * @desc 查询用户番号
     **/
	public List<Designation> getDesignations(){
		return designationDao.getDesignations();
	}
	
	

}
