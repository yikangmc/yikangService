package com.yikangyiliao.pension.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.TimeQuantumDao;
import com.yikangyiliao.pension.entity.TimeQuantum;

@Component
public class TimeQuantumManager {

	@Autowired
	private TimeQuantumDao timeQuantumDao;
	
	
	
	/**
     * 
     * @author liushuaic
     * @date 2015/09/18 18:12
     * @desc 获取所有的时间段
     * 
     * **/
	public List<TimeQuantum> getAllTimeQuantum(){
		return timeQuantumDao.getAllTimeQuantum();
	}
	
	
    /**
     * 
     * @author liushuaic
     * @date 2015/10/09 14:53
     * @desc 查询某一个服务时间内的，可用时间
     * 
     * */
	public List<Map<String,Object>> getTimeQuantumsForCustomer(Map<String,Object> param){
		return timeQuantumDao.getTimeQuantumsForCustomer(param);
    }
	
	
	/**
	 * @author liushuaic
	 * @date 2015/10/13 16:19
	 * 查询某一个时间段，根据id
	 * **/
	public TimeQuantum getTimeQuantumsById(Long timeQuantumId){
		return timeQuantumDao.selectByPrimaryKey(timeQuantumId);
	}
	
}
