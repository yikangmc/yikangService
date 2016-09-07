package com.yikangyiliao.pension.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.QuestionAnswersCommentDao;
import com.yikangyiliao.pension.entity.QuestionAnswersComment;

@Component
public class QuestionAnswerComentManager {

	@Autowired
	private QuestionAnswersCommentDao answersCommentDao;
	
	public int insertSelective(QuestionAnswersComment answersComment){
		return answersCommentDao.insertSelective(answersComment);
	}
	
	public List<QuestionAnswersComment> getQuestionAnswersCommentListByUserIdAndQuestionAnswerId(Map map){
		return answersCommentDao.getQuestionAnswersCommentListByUserIdAndQuestionAnswerIdPage(map);
	}
}
