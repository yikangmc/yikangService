package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UserActivetyListDao;
import com.yikangyiliao.pension.entity.UserActivetyList;

@Component
public class UserActivetyListManager {
	
	@Autowired
	private UserActivetyListDao userActivetyListDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-17 18:54
	 * @desc 添加我的活动
	 * 
	 * **/
	public int insertUserActivetyList(Long activetyId,Long userId){
		
		UserActivetyList ual=new UserActivetyList();
		
		ual.setActivetyId(activetyId);
		ual.setAuditStatus(Byte.valueOf("0"));
		ual.setPayStatus(Byte.valueOf("0"));
		ual.setUserId(userId);
		
		return userActivetyListDao.insertSelective(ual);
		
	}
	
	
	

}
