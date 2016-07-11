package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UserServiceInfoDao;
import com.yikangyiliao.pension.entity.UserServiceInfo;

@Component
public class UserServiceInfoManager {

	
	@Autowired
	private UserServiceInfoDao userServiceInfoDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2016-03-21 18:38
	 * @desc 提交用户修改职位的申请
	 * **/
	public int submitUpdateUserPosition(Long userId,Long userPostion){
		
		Map<String,Object> paramData=new HashMap<String,Object>();
		
		return userServiceInfoDao.submitUpdateUserPosition(paramData);
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-31 14:55
	 * @desc 获取我支持的用户
	 * 
	 * */
	public List<UserServiceInfo> getMyFollowUser(Long createUserId){
		return userServiceInfoDao.getMyFollowUser(createUserId);
	}
	
	  
    /**
     * @author liushuaic
     * @date 2016/07/09 11:10
     * @dsec 查询某一个员工的信息，根据 serverUserId 
     * */
    public UserServiceInfo getUserServiceInfoByServerUserId(Long userId){
    	return userServiceInfoDao.getUserServiceInfoByServerUserId(userId);
    }
	
}
