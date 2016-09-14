package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UserConfigrationDao;
import com.yikangyiliao.pension.entity.UserConfigration;

@Component
public class UserConfigrationManager {
	
	@Autowired
	private UserConfigrationDao userConfigrationDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-20 14:17
	 * @desc 修改通知设置
	 * **/
	public int updateUserConfigration(Integer systemAlert,Integer dynamicAlert,Long userId){
		UserConfigration uc=new UserConfigration();
		uc.setDynamicAlert(dynamicAlert.byteValue());
		uc.setSystemAlert(systemAlert.byteValue());
		uc.setUserId(userId);
		return userConfigrationDao.updateByUseridSelective(uc);
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-20 14:51
	 * @desc 获取某一个用户的消息通知配置
	 * **/
	public UserConfigration getUserConfigration(Long userId){
		return userConfigrationDao.getUserConfigrationByUserId(userId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-07 20:25
	 * @desc 添加用户配置
	 * */
	public int insertSelective(Integer systemAlert,Integer dynamicAlert,Long userId){
		UserConfigration uc=new UserConfigration();
		uc.setDynamicAlert(dynamicAlert.byteValue());
		uc.setSystemAlert(systemAlert.byteValue());
		uc.setUserId(userId);
		return userConfigrationDao.insertSelective(uc);
	} 
	
	/**
     * @author houyt
     * @date 2016-09-14 10:43
     * @desc 获取所有用户配置
     * @return
     */
	public List<UserConfigration> selectAllUserConfigration(){
		return userConfigrationDao.selectAllUserConfigration();
	}

}
