package com.yikangyiliao.pension.dao;

import java.util.List;
import java.util.Map;

import com.yikangyiliao.pension.entity.Message;

public interface MessageDao {
    int deleteByPrimaryKey(Long messagesId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long messagesId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    /**
     * @author liushuaic
     * @date 2016-05-25 14:04
     * **/
    List<Message> getMessageByToUserId(Long toUserId);

    
    /**
     * @author liushuaic
     * @date 2016-06-07 09:56
     * @desc 查询某一个用户下的，某一些分类的信息
     * */
    List<Message> getMessageByMessageGroupAndUserId(Map<String,Object> paramMap);
    
}