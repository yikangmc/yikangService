package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.Activety;
import com.yikangyiliao.pension.entity.UserActivetyList;
import com.yikangyiliao.pension.entity.UserInfo;

public interface UserActivetyListDao {
    int deleteByPrimaryKey(Long userActivetyListId);

    int insert(UserActivetyList record);

    int insertSelective(UserActivetyList record);

    UserActivetyList selectByPrimaryKey(Long userActivetyListId);

    int updateByPrimaryKeySelective(UserActivetyList record);

    int updateByPrimaryKey(UserActivetyList record);
    

    
    
    /**
     * @author liushuaic
     * @date 2016-05-13 11:31
     * @desc 获取某一个活动的所有参与人员
     * **/
    List<UserInfo> getUserInfoListByActivetyId(Long activityId);
    

    /**
     * @author liushuaic
     * @date 2016-05-23 15:12
     * @desc 获取我参与的活动
     * **/
    List<Activety> getMyActivetyByUserId(Long userId);
}