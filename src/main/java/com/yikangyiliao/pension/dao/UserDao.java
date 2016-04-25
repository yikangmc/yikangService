package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserModel;

public interface UserDao {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User getUserByLoginName(String userName);
    
    /**
     * @author liushuaic
     * @date 2015/11/18 15:29
     * @desc 邀请码，是根据用户id 获取的
     * 添加用户邀请码
     * */
    int updateInvitationCodeByUserId(Map<String,Object> paramData);
    
    
    /**
     * @author liushuaic
     * @date 2015/12/21 11:12
     * @desc 修改用户密码
     * ***/
    int updatePasswordByLoginName(Map<String,Object> paramData);
    
    
    /**
     * @author liushuaic
     * @date 2016-02-25 16:11
     * @desc 获取我邀请的用户
     * 
     * ***/
    List<UserModel> getInvationUserInfoByInvationUserId(Map<String,Object> paramData);
    
    
    /**
     * @author liushuaic
     * @date 2016-03-21 11:38
     * @desc 查询我邀请的用户
     * 
     * ***/
    List<UserModel> getInvationUserInfoByInvationUserIdAndUserStatus(Map<String,Object> paramData);
    /**
     * @author liushuaic
     * @date 2016-03-21 11:38
     * @desc 查询我邀请的用户
     * 
     * ***/
   Long getInvationUserInfoNumsByInvationUserIdAndUserStatus(Map<String,Object> paramData);
 
    
    
    
}