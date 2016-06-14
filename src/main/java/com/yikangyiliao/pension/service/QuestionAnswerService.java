package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.manager.QuestionAnswerManager;

@Service(value="questionAnswerService")
public class QuestionAnswerService {
	
	@Autowired
	private QuestionAnswerManager questionAnswerManager;
	
	public ResponseMessage<List<QuestionAnswer>> getIsRecommendQuestionAnswer(Map<String,Object> paramMap){
		ResponseMessage<List<QuestionAnswer>> questionAnswers=new ResponseMessage<List<QuestionAnswer>>();
		
		
		
		return questionAnswers;
		
	}
	

}
