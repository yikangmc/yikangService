package com.yikangyiliao.pension.manager;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.dao.QuestionAnswersCommentDao;
import com.yikangyiliao.pension.entity.QuestionAnswersComment;

@Component
public class QuestionAnswerComentManager {

	@Autowired
	private QuestionAnswersCommentDao answersCommentDao;
	
	private Logger logger=LoggerFactory.getLogger(QuestionAnswerComentManager.class);
	
	/**
	 * @author houyantao
	 * @date 2016-09-09 17:42
	 * 添加 评论信息
	 * @param answersComment
	 */
	public void insertSelective(QuestionAnswersComment answersComment){
		answersCommentDao.insertSelective(answersComment);
	}
	
	
	/**
	 * @author houyantao
	 * @date 2016-09-09 17:42
	 * 获取解答评论列表
	 * @param map
	 * @return
	 */
	public List<QuestionAnswersComment> getQuestionAnswersCommentListByUserIdAndQuestionAnswerId(Map map){
		return answersCommentDao.getQuestionAnswersCommentListByUserIdAndQuestionAnswerIdPage(map);
	}
	
	/**
	 * 通过主键获取评论信息
	 * @param questionAnswerCommentId
	 * @return
	 */
	public QuestionAnswersComment selectByPrimaryKey(Long questionAnswerCommentId){
		return answersCommentDao.selectByPrimaryKey(questionAnswerCommentId);
	}
}
