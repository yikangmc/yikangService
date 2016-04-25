package com.yikangyiliao.pension.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.SeniorAccountDao;
import com.yikangyiliao.pension.entity.SeniorAccount;
import com.yikangyiliao.pension.entity.UserInfo;


/**
 * @author liushuaic
 * @Date 2015/08/13 14:43
 * **/
@Component
public class SeniorAccountManager {
	
	@Autowired
	private SeniorAccountDao seniorAccountDao;
	
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2015/08/13 14:44
	 * 获取某一个患者，根据患者id
	 * 
	 * */
	public SeniorAccount selectByPrimaryKey(Long seniorId){
		return seniorAccountDao.selectByPrimaryKey(seniorId);
	}

	
	/**
	 * @author liushuaic
	 * @date 2015/08/13 15:48
	 * @desc 添加患者
	 * */
	public int insertSelective(SeniorAccount record){
		return seniorAccountDao.insert(record);
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/12/28 17:35
	 * @desc 获取某一个创建人下的所有患者
	 * **/
	public List<SeniorAccount> getSeniorAccountByCreateUserId(Long userId){
		return seniorAccountDao.getSeniorAccountByCreateUserId(userId);
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016/03/18 16:35
	 * @desc 获取某一个创建人下的所有患者
	 * **/
//	public List<UserInfo> getMyinvitationUserByUserId(Long userId){
//		return seniorAccountDao.getMyinvitationUserByUserId(userId);
//	}
	
	
	
	/**
     * @author liushuaic
     * @date 2015/11/17 16:38
     * @desc 查询某个用户的推荐换则
     * **/
    public List<Map<String,Object>> getSeniorAccountInfoByInvitationUserId(Integer userStatus,Long userId){
    	
    	Map<String,Object> paramData=new HashMap<String,Object>();
    	paramData.put("userId", userId);
    	paramData.put("userStatus", userStatus);
    	
    	return seniorAccountDao.getSeniorAccountInfoByInvitationUserId(paramData);
    }
	
}
