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
	
	public void insertSelective(QuestionAnswersComment answersComment,Long questionAnswerId){
		answersCommentDao.insertSelective(answersComment);
		try{
			OperationMessage operationMessage=new OperationMessage();
			operationMessage.setContent(String.valueOf(questionAnswerId));
			operationMessage.setContentType("2");
			OperationMessageQueue.putQuestionAnswersCommentQueue(operationMessage);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("推送发生异常!");
		}
	}
	
	public List<QuestionAnswersComment> getQuestionAnswersCommentListByUserIdAndQuestionAnswerId(Map map){
		return answersCommentDao.getQuestionAnswersCommentListByUserIdAndQuestionAnswerIdPage(map);
	}
}
