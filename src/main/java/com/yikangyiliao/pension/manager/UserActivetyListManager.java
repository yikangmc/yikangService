package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UserActivetyListDao;
import com.yikangyiliao.pension.entity.Activety;
import com.yikangyiliao.pension.entity.UserActivetyList;
import com.yikangyiliao.pension.entity.UserInfo;

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
		
		Date currentDate= Calendar.getInstance().getTime();
		
		UserActivetyList ual=new UserActivetyList();
		
		ual.setActivetyId(activetyId);
		ual.setAuditStatus(Byte.valueOf("0"));
		ual.setPayStatus(Byte.valueOf("0"));
		ual.setUserId(userId);
		ual.setCreateTime(currentDate);
		ual.setUpdateTime(currentDate);
		
		return userActivetyListDao.insertSelective(ual);
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-23 15:14
	 * @desc 查询我参与的活动
	 * */
	public List<Activety> getMyActivetyByUserId(Map map){
		return  userActivetyListDao.getMyActivetyByUserId(map);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-23 15:14
	 * @desc 查询我参与的活动
	 * */
	public List<Activety> getMyActivetyByUserIdPage(Map map){
		return  userActivetyListDao.getMyActivetyByUserIdPage(map);
	}

}
