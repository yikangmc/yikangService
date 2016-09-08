package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.page.PageParameter;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.manager.QuestionAnswerManager;

@Service(value="questionAnswerService")
public class QuestionAnswerService {
	
	@Autowired
	private QuestionAnswerManager questionAnswerManager;
	
	public ResponseMessage<List<QuestionAnswer>> getIsRecommendQuestionAnswer(Map<String,Object> paramMap){
		ResponseMessage<List<QuestionAnswer>> questionAnswers=new ResponseMessage<List<QuestionAnswer>>();
		
//		questionAnswerManager.get
		
		return questionAnswers;
		
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-15 17:18
	 * @desc 我的回答
	 * */
	public ResponseMessage<List<QuestionAnswer>> getQuestionAnswerByCreateUserId(Map<String,Object> paramMap){
		ResponseMessage<List<QuestionAnswer>> questionAnswers=new ResponseMessage<List<QuestionAnswer>>();
		Long userId=Long.valueOf(paramMap.get("userId").toString());
		List<QuestionAnswer> questionAnswersArray=questionAnswerManager.getQuestionAnswerListByCreateUserId(userId);
		questionAnswers.setData(questionAnswersArray);
		return questionAnswers;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-15 17:18
	 * @desc 查询某一个人的所有回答
	 * */
	public ResponseMessage<List<QuestionAnswer>> getQuestionAnswerByServerUserId(Map<String,Object> paramMap){
		ResponseMessage<List<QuestionAnswer>> questionAnswers=new ResponseMessage<List<QuestionAnswer>>();
		Long userId=Long.valueOf(paramMap.get("serverUserId").toString());
		PageParameter page=new PageParameter();
		if(paramMap.containsKey("page")){
			int currentPage=Integer.valueOf(paramMap.get("page").toString());
			page.setCurrentPage(currentPage);
		}
		List<QuestionAnswer> questionAnswersArray=questionAnswerManager.getQuestionAnswerListByCreateUserIdPage(userId, page);
		questionAnswers.setData(questionAnswersArray);
		return questionAnswers;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-28 17:42
	 * @desc 获取回复详情
	 * */
	public ResponseMessage<QuestionAnswer> getQuestionAnswerDetail(Map<String,Object> paramMap){
		ResponseMessage<QuestionAnswer> data=new ResponseMessage<QuestionAnswer>();
		if(paramMap.containsKey("questionAnswerId")){
			Long questionAnswerId=Long.valueOf(paramMap.get("questionAnswerId").toString());
			Long userId=null;
			if(paramMap.containsKey("userId")){
				userId=Long.valueOf(paramMap.get("userId").toString());
			}
			QuestionAnswer questionAnswer=questionAnswerManager.getQuestionAnswerByQuestionAnswerId(userId,questionAnswerId);
			data.setData(questionAnswer);
		}else{
			data.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			data.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return data;
	}

}
