package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.Adept;

public interface AdeptDao {
    int deleteByPrimaryKey(Long adeptId);

    int insert(Adept record);

    int insertSelective(Adept record);

    Adept selectByPrimaryKey(Long adeptId);

    int updateByPrimaryKeySelective(Adept record);

    int updateByPrimaryKey(Adept record);
    
    
    

    /**
     * 
     * @author liushuaic
     * @date 2016-03-16 17:32
     * @desc 获取擅长列表
     * 
     * ***/
    List<Adept> getAdeptsByType(Long type);
    
    
    /**
     * @author liushuaic
     * @date 2016-03-24 15:06
     * @desc 获取我的擅长列表
     * **/
    List<Adept> getAdeptsByTypeAndUserId(Map<String,Object> paramData);
    
    
    /**
     * @author liushuaic
     * @date 2016-03-31 18:28
     * @desc 查询我的所有的擅长
     * */
    List<Adept> getAdeptsByUserId(Long userId);
    
}