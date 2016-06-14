package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.UserInfo;

public interface UserInfoDao {
    int deleteByPrimaryKey(Long userInfoId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userInfoId);

    int updateByPrimaryKeySelective(UserInfo record);
    
    /**
     * @author liushuaic
     * @date 2016-06-08 15:58
     * @desc 修改用户信息
     * */
    int updateByUserIdSelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    
    /**
     * @author liushuaic
     * @date 2015/09/07 13:41
     * @param userId 用户id
     * 
     * 获取某一个用户信息，根据用户id
     * **/
    UserInfo getUserInfoByUserId(Long userId);
    
    
    /**
     * @author liushuaic
     * @date 2016-06-12 13:31
     * @desc 查询某一个标签的所有的关注人员
     * */
    List<UserInfo> getUserInfoListByTaglibId(Long taglibId);
}