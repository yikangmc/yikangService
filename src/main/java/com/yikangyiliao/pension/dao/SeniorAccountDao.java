package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yikangyiliao.pension.entity.SeniorAccount;

public interface SeniorAccountDao {
    int deleteByPrimaryKey(Long seniorId);

    int insert(SeniorAccount record);

    int insertSelective(SeniorAccount record);

    SeniorAccount selectByPrimaryKey(Long seniorId);

    int updateByPrimaryKeySelective(SeniorAccount record);

    int updateByPrimaryKey(SeniorAccount record);
    
    
    /**
     * @author liushuaic
     * @date 2015/07/30 18:50
     * @desc 查询某一个用户下的所有的 老人信息
     * 
     * */
    List<SeniorAccount> getSeniorAccountByUserId(@Param("userId") Long userId);
    
    
    
    /**
     * @author liushuaic
     * @date 2015/07/30 18:50
     * @desc 查询某一个创建人下的所有的 老人信息
     * 
     * */
    List<SeniorAccount> getSeniorAccountByCreateUserId(@Param("userId") Long userId);
    
    
    /**
     * 
     * @author liushuaic
     * @date 2015/11/17 16:38
     * @desc 查询某个用户的推荐换则
     * 
     * **/
    List<Map<String,Object>> getSeniorAccountInfoByInvitationUserId(Map<String,Object> paramData);
    
    
}