package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.UserDao;
import com.yikangyiliao.pension.dao.UserInfoDao;
import com.yikangyiliao.pension.dao.UserServiceInfoDao;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserInfo;
import com.yikangyiliao.pension.entity.UserModel;
import com.yikangyiliao.pension.entity.UserServiceInfo;


@Component
public class UserManager {
	
	@Autowired
	private UserDao userDao;

	
	@Autowired
	private UserServiceInfoDao userServiceInfoDao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/12/04 11:28
	 * @desc 获取用户
	 * 
	 * **/
	public User getUserByUserId(Long userId){
		return userDao.selectByPrimaryKey(userId);
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:20
	 * @desc 添加用户信息
	 * **/
	public int insertUserSelective(User user){
		return userDao.insertSelective(user);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/08/25 17:24
	 * @desc 添加服务人员信息
	 * */
	public int insertUserServiceSelective(UserServiceInfo userServiceInfo){
		return userServiceInfoDao.insertSelective(userServiceInfo);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 查询某一个用户
	 * **/
	public User selectByPrimaryKey(Long userId){
		return userDao.selectByPrimaryKey(userId);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/26 11:09 修改用户信息
	 * */
	public int updateUser(User user){
		return userDao.updateByPrimaryKeySelective(user);
	}

	
	/**
	 * @author liushuaic
	 * @date 2015/08/27 19:13 
	 * 查询某一个用户
	 * */
	public User getUserByLoginName(String loginName){
		return userDao.getUserByLoginName(loginName);
	}
	
	 /**
     * @author liushuaic
     * @date 2015/08/28 11:59
     * @dsec 查询某一个员工的信息，根据 用户id 
     * */
	public Map<String,Object> getUserServiceInfoByUserId(Long userId){
		return userServiceInfoDao.getUserServiceInfoByUserId(userId);
	}
	
	 /**
     * @author liushuaic
     * @date 2016/03/14 11:58
     * @dsec 查询某一个员工的信息，根据 用户id 
     * */
	public UserServiceInfo getUserServiceInfoByUserIdTwo(Long userId){
		return userServiceInfoDao.getUserServiceInfoByUserIdTwo(userId);
	}
	
	
    /**
     * @author liushuaic
     * @date 2015/09/07 13:41
     * @param userId 用户id
     * 
     * 获取某一个用户信息，根据用户id
     * **/
	public UserInfo getUserInfoByUserId(Long userId){
		return userInfoDao.getUserInfoByUserId(userId);
	}


	 /**
     * 
     * @author liushuaic
     * @date 2015/09/17 14:46
     * @desc 获取所有评估师
     * */
	public List<UserServiceInfo> getPingGuServiceAll(){
    	return userServiceInfoDao.getPingGuServiceAll();
    }

	 /**
    * @author liushuaic
    * @date 2015/10/14 20:03 
    * @desc 获取某一个评估人员
    * */
	public Map<String,Object> getPingGuServicerByUserId(Long userId){
		return userServiceInfoDao.getPingGuServicerByUserId(userId);
	}
	
	
    /**
     * @author liushuaic
     * @date 2015/11/18 15:29
     * @desc 邀请码，是根据用户id 获取的
     * 添加用户邀请码
     * */
	public int updateInvitationCodeByUserId(String invitationCode,Long userId){
		Map<String,Object> paramData=new HashMap<String,Object>();
		paramData.put("invitationCode", invitationCode);
		paramData.put("userId", userId);
		return userDao.updateInvitationCodeByUserId(paramData);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/11/26 16:10
	 * @desc 修改用户信息
	 * 
	 * **/
	public int updateUserServiceInfo(UserServiceInfo userServiceInfo){
		return userServiceInfoDao.updateServiceInfoByUserId(userServiceInfo);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/11/27 11:32
	 * @desc 清空用户信息
	 * */
	public int  updateUserServiceInfoIsEmptyByUserId(Long userId){
		return userServiceInfoDao.updateUserServiceInfoIsEmptyByUserId(userId);
	}
	
	
    /**
     * @author liushuaic
     * @date 2015/12/21 11:12
     * @desc 修改用户密码
     * ***/
    public int updatePasswordByLoginName(String userName,String password){
    	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userName", userName);
    	paramData.put("password", password);
    	return userDao.updatePasswordByLoginName(paramData);
    }
    
    
    
    /**
     * @author liushuaic
     * @date 2016-02-25 16:11
     * @desc 获取我邀请的用户
     * 
     * ***/
    public List<UserModel> getInvationUserInfoByInvationUserId(Long userId,Integer userStatus){
    	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userId", userId);
    	paramData.put("userStatus", userStatus);
    	return userDao.getInvationUserInfoByInvationUserId(paramData);
    }
    
    
    /**
     * @author liushuaic
     * @date 2016-03-21 14:10
     * @desc 查询我邀请注册的所有用户
     * **/
    public Long getMyInvitionUserNumsByInvitionUserId(Long userId){
    	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userId", userId);
    	paramData.put("userStatus", -1);
    	return userDao.getInvationUserInfoNumsByInvationUserIdAndUserStatus(paramData);
    }
    
    
    /**
     * @author liushuaic
     * @date 2016-03-21 12:16
     * @desc 查询我邀请的服务中的用户
     * */
    public Long getServiceingUserNumsByInvitionUserId(Long userId){
    	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userId", userId);
    	paramData.put("userStatus", 1);
    	return userDao.getInvationUserInfoNumsByInvationUserIdAndUserStatus(paramData);
    }
    
    /**
     * @author liushuaic
     * @date 2016-03-21 12:16
     * @desc 查询我邀请的用户未消费的
     * */
    public Long getMyinvationUserNoPaying(Long userId){
    	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userId", userId);
    	paramData.put("userStatus", 0);
    	return userDao.getInvationUserInfoNumsByInvationUserIdAndUserStatus(paramData);
    }
    
    
    /**
     * @author liushuaic
     * @date 2016-03-21 12:20
     * @desc 查询服务完成的用户
     * **/
    public Long getServicedUserNumbsByInvitionUserId(Long userId){
    	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userId", userId);
    	paramData.put("userStatus", 2);
    	return userDao.getInvationUserInfoNumsByInvationUserIdAndUserStatus(paramData);
    }
    
    
    /**
     * @author liushuaic
     * @date 2016-03-21 11:38
     * @desc 查询我邀请的用户
     * ***/
    public  List<UserModel> getInvationUserInfoByInvationUserIdAndUserStatus(Long userId,Integer userStatus){
      	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userId", userId);
    	paramData.put("userStatus",userStatus);
    	return userDao.getInvationUserInfoByInvationUserIdAndUserStatus(paramData);
    }
    /**
     * @author liushuaic
     * @date 2016-03-24 19:27
     * @desc 提交信息用户的职位的申请
     * */
    public int submitUpdateUserPosition(Long userId,Long userPosition){
    	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userId",userId);
    	paramData.put("userPosition", userPosition);
    	return userServiceInfoDao.submitUpdateUserPosition(paramData);
    }
    
    /**
     * @author liushuaic
     * @date 2016-03-25 14:53
     * @desc 修改用户的职位状态为审核中
     * */
    public int updateUserPositionStatusChecking(Long userId){
    	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userId",userId);
    	paramData.put("positionAuditStatus", 1);
    	return userServiceInfoDao.updateUserPositionAuditStatusByStatusAndUserId(paramData);
    }
    
    /**
     * @author liushuaic
     * @date 2016-03-25 14:54
     * @desc  修改职位的审核状态为审核通过
     * **/
    public int updateUserPositionStatusCheckePass(Long userId){
    	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userId",userId);
    	paramData.put("positionAuditStatus", 2);
    	return userServiceInfoDao.updateUserPositionStatusCheckePass(paramData);
    }
}
