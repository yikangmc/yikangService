package com.yikangyiliao.pension.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.ActivetyCommentDao;
import com.yikangyiliao.pension.entity.ActivetyComment;

@Component
public class ActivetyCommentManager {
	
	@Autowired
	private  ActivetyCommentDao activetyCommentDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-18 16:21
	 * @desc 添加活动评论
	 * */
	public int insertActivetyComment(Long activetyId,String content,Long userId){
		
		Date currentDateTime=Calendar.getInstance().getTime();
		
		ActivetyComment activetyComment=new ActivetyComment();
		activetyComment.setActivetyId(activetyId);
		activetyComment.setContent(content);
		activetyComment.setCreateTime(currentDateTime);
		activetyComment.setUpdateTime(currentDateTime);
		activetyComment.setCreateUserId(userId);
		
		return activetyCommentDao.insertSelective(activetyComment);
	}
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-18 18:06
	 * @desc 获取文章的活动的评论列表
	 * ***/
	public List<ActivetyComment> getActivetyCommentList(Long activetyId){
		return activetyCommentDao.getActivetyCommentByActivetyId(activetyId);
	}
	
	

}
