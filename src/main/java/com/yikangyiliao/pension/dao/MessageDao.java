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
    
    /**
     * @author liushuaic
     * @date 2016-09-14 13:07
     * @desc 查询某一个用户下的，某一些分类信息  page
     * */
    List<Message> getMessageByMessageGroupAndUserIdPage(Map<String,Object> paramMap);
    
    /**
	 * @author houyt
	 * @serialData 2016/09/12/18:05
	 * @param paramMap
	 * @desc 根据登录用户ID查询他的动态/系统 消息的未读数量
	 * @return
	 */
    Message getMessageUnreadNumberByUserId(Message message);
    
    
    /**
	 * @author houyt
	 * @serialData 2016/09/13 10:28
	 * @param paramMap
	 * @desc 通过用户标识和未读标识标记所有未读消息状态为已读
	 * @return
	 */
    void setAllMessageAsRead(Long userId);
    
}