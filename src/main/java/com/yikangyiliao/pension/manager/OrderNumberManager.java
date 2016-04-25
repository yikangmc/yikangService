package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.OrderNumberDao;
import com.yikangyiliao.pension.entity.OrderNumber;

@Component
public class OrderNumberManager {
	
	@Autowired
	private OrderNumberDao orderNumberDao;
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016/1/13 18:45
	 * @desc 添加定单编号
	 * 
	 * */
	public int insertSelective(OrderNumber record){
		return orderNumberDao.insert(record);
	}
	
	

}
