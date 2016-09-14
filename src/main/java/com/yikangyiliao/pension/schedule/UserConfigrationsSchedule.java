package com.yikangyiliao.pension.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.base.cache.SimpleCache;
import com.yikangyiliao.base.cache.UserConfigrationsCache;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.UserConfigration;
import com.yikangyiliao.pension.manager.FormPostManager;
import com.yikangyiliao.pension.manager.UserConfigrationManager;

/**
 * @author houyt
 * @date 2016-09-14 10:43
 * @desc 动态消息开关任务
 **/
@Component(value="userConfigrationsSchedule")
public class UserConfigrationsSchedule {
	
	@Autowired
	private UserConfigrationManager userConfigrationManager;
	
	private Logger logger=LoggerFactory.getLogger(getClass());

	/**
	 * 
	 * @author houyt
	 * @date 2016-09-14 10:43
	 * @desc 重新加载数据
	 * 
	 * **/
	public void reloadUserConfigrationsData() {
		logger.info("UserConfigrationSchedule --> reloadUserConfigrationsData");
		try {
			UserConfigrationsCache.clear();
			List<UserConfigration> datas=userConfigrationManager.selectAllUserConfigration();
			for (UserConfigration userConfigration : datas) {
				UserConfigrationsCache.put(String.valueOf(userConfigration.getUserId()), userConfigration);
			}
		} catch (Exception e) {
			logger.error("UserConfigrationSchedule --> reloadUserConfigrationsData --> message:"+e.getMessage());
		}
	}

}
