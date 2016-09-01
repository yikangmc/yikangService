package com.yikangyiliao.pension.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.base.cache.SimpleCache;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.manager.FormPostManager;

/**
 * @author liushuaic
 * @date 2016-08-31 15:43
 * @desc 推荐数据更新任务
 **/
@Component(value="recommendDataSchedule")
public class RecommendDataSchedule {
	
	@Autowired
	private FormPostManager formPostManager;
	
	private Logger logger=LoggerFactory.getLogger(getClass());

	/**
	 * 
	 * @author liushuaic
	 * @date 2016-08-31 17:05
	 * @desc 重新加载数据
	 * 
	 * **/
	public void reloadRecommendForumPostData() {
		try {
			List<FormPosts> datas=formPostManager.getFormPostsALL();
			SimpleCache.put("formPosts", datas);
		} catch (Exception e) {
			logger.error("RecommendDataSchedule --> reloadRecommendForumPostData --> message:"+e.getMessage());
		}
	}

}
