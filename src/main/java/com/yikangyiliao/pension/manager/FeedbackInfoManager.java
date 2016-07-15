package com.yikangyiliao.pension.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.FeedbackInfoDao;
import com.yikangyiliao.pension.entity.FeedbackInfo;

@Component
public class FeedbackInfoManager {
	@Autowired
	private FeedbackInfoDao feedbackInfoDao;
	
	/**
	 * 插入用户反馈信息
	 * @param info
	 * @return
	 */
	public int insertFeedbackData(FeedbackInfo info){
		return feedbackInfoDao.insert(info);
	}
}
