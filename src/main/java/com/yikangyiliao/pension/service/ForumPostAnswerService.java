package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.base.utils.LogUtils;
import com.yikangyiliao.pension.common.page.PageParameter;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.ForumPostsAnswer;
import com.yikangyiliao.pension.manager.ForumPostsAnswerManager;

@Service(value = "forumPostAnswerService")
public class ForumPostAnswerService {

	@Autowired
	private ForumPostsAnswerManager forumPostsAnswerManager;

	
	private static Logger LOG=LoggerFactory.getLogger(ForumPostAnswerService.class.getName());
	
	
	/**
	 * @author liushuaic
	 * @date 2016-09-28 14:08
	 * @desc 获取文章回复列表 page
	 */
	public ResponseMessage<List<ForumPostsAnswer>> getForumPostsAnswerList(Map<String, Object> paramMap) {

		ResponseMessage<List<ForumPostsAnswer>> resData = new ResponseMessage<List<ForumPostsAnswer>>();

		try {
			if (paramMap.containsKey("forumPostId") && paramMap.containsKey("page")) {
				
				int page=Integer.valueOf(paramMap.get("page").toString());
				PageParameter pageParam=new PageParameter();
				pageParam.setCurrentPage(page);
				Long forumPostId=Long.valueOf(paramMap.get("forumPostId").toString());
				List<ForumPostsAnswer> data=forumPostsAnswerManager.getForumPostsAnswerListPage(forumPostId, pageParam);
				resData.setData(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(LogUtils.getErrorStr(ForumPostAnswerService.class.getName(), "getForumPostsAnswerList", e.getMessage()));
		}

		return resData;

	}

}
