package com.yikangyiliao.pension.dao;

import java.util.List;

import com.yikangyiliao.pension.entity.Baner;

public interface BanerDao {
    int deleteByPrimaryKey(Long banerId);

    int insert(Baner record);

    int insertSelective(Baner record);

    Baner selectByPrimaryKey(Long banerId);

    int updateByPrimaryKeySelective(Baner record);

    int updateByPrimaryKey(Baner record);
    
    
    /**
     * 
     * @author liushuaic
     * @date 2016-04-25 14:24
     * @desc 查询baner列表
     * 
     * **/
    List<Baner> getBanerList();
    
    /**
     * @author liushuaic
     * @date 2016-05-27 14:01
     * @desc 获取活动baner
     * 
     * **/
    List<Baner> getActivetyBaner();
    
    
    /**
     * @author liushuaic
     * @date 2016-06-06 19:06
     * @desc 发现baner
     * */
    List<Baner> getSearchActivetyBanner();
    
}