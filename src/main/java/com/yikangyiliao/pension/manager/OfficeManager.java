package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.OfficeDao;
import com.yikangyiliao.pension.entity.Office;

@Component
public class OfficeManager {
	
	@Autowired
	private OfficeDao officeDao;
	
	
	
	/**
     * @author liushuaic
     * @date 2016-03-17 10:37
     * @desc 获取所有科室
     * */
    public List<Office> getOffices(){
    	return officeDao.getOffices();
    }
    
    
    /**
     * @author liushuaic
     * @date 2016-03-17 11:53
     * @desc 获取某一个科室
     * **/
    public Office getOffice(Long officeId){
    	return officeDao.selectByPrimaryKey(officeId);
    }
    
    
    
    
    
    
}
