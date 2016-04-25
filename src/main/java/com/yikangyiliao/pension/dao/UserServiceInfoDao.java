package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.UserServiceInfo;

public interface UserServiceInfoDao {
    int deleteByPrimaryKey(Long userServiceInfoId);

    int insert(UserServiceInfo record);

    int insertSelective(UserServiceInfo record);

    UserServiceInfo selectByPrimaryKey(Long userServiceInfoId);

    int updateByPrimaryKeySelective(UserServiceInfo record);

    int updateByPrimaryKey(UserServiceInfo record);
    
    /**
     * @author liushuaic
     * @date 2015/08/28 11:59
     * @dsec 查询某一个员工的信息，根据 用户id 
     * */
    Map<String,Object> getUserServiceInfoByUserId(Long userIds);
    
    /**
     * @author liushuaic
     * @date 2015/03/14 11:58
     * @dsec 查询某一个员工的信息，根据 用户id 
     * */
    UserServiceInfo getUserServiceInfoByUserIdTwo(Long userIds);
    
    
    
    /**
     * 
     * @author liushuaic
     * @date 2015/09/17 14:46
     * @desc 获取所有评估师
     * */
    List<UserServiceInfo> getPingGuServiceAll();
    
    
    
    /**
     * @author liushuaic
     * @date 2015/10/14 19:59
     * @desc 获取评估师，根据评估师id
     * **/
    Map<String,Object> getPingGuServicerByUserId(Long userId);
    
    
    /**
     * @author liushuaic
     * @date 2015/1126 16:23
     * @desc
     *  修改用户信息， 根据 userId 
     * */
    int updateServiceInfoByUserId(UserServiceInfo record);
    
    /**
     * @author liushuaic
     * @date 2015/11/27 11:29
     * @desc 
     * 清空用户信息
     * **/
    int updateUserServiceInfoIsEmptyByUserId(long userId);
    
    
    
    /**
     * @author liushuaic
     * @date 2016-03-21 18:30
     * @desc 提交用户修改职位的申请
     * 
     * **/
    int submitUpdateUserPosition(Map<String,Object> paramData);
    
    
    /**
     * @author liushuaic
     * @date 2016-03-25 14:41
     * @desc 修改职位的审核状态
     * 
     * */
    int updateUserPositionAuditStatusByStatusAndUserId(Map<String,Object> paramData);
    
    /**
     * @author liushuaic
     * @date 2016-03-25 14:41
     * @desc 修改职位的审核状态
     * 
     * */
    int updateUserPositionStatusCheckePass(Map<String,Object> paramData);
    
    
}