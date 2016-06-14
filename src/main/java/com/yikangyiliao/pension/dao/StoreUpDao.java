package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.Message;
import com.yikangyiliao.pension.entity.StoreUp;

public interface StoreUpDao {
    int deleteByPrimaryKey(Long storeUpsId);

    int insert(StoreUp record);

    int insertSelective(StoreUp record);

    StoreUp selectByPrimaryKey(Long storeUpsId);

    int updateByPrimaryKeySelective(StoreUp record);

    int updateByPrimaryKey(StoreUp record);
    
    
    /**
     * @author liushuaic
     * @date 2016-05-25 14:57
     * @desc 删除我收藏的文章
     * ***/
    int deleteForumPostByUserIdAndForumPostId(Map<String,Object> paramMap);
    
    
    
    /**
     * @author liushuaic
     * @date 2016-05-25 15:05
     * @desc 获取用户的消息列表
     * **/
    List<StoreUp> getStoreupByUserId(Map<String,Object> paramMap);
    
    
    /**
     *@author liushuaic
     *@date 2016-06-13 16:02
     *@desc 根据用户id 与文章id 获取某一个收藏
     * */
    StoreUp getStoreupByUserIdAndForumPostId(Map<String,Object> paramMap);
    
    
}