package com.yikangyiliao.pension.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yikangyiliao.base.utils.ParamMapUtils;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.entity.Question;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.manager.QuestionAnswerManager;
import com.yikangyiliao.pension.manager.QuestionManager;

@Service(value="questionService")
public class QuestionService {
	
	@Autowired
	private QuestionManager questionManager;
	
	@Autowired
	private QuestionAnswerManager questionAnswerManager;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-09 17:00
	 * @desc 发布问题
	 * 
	 * **/
	public ResponseMessage<String> insertQuestion(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		if(
				paramMap.containsKey("title")
				&&paramMap.containsKey("content")
				&&paramMap.containsKey("taglibIds")
				&&paramMap.containsKey("images")
			){
				
			String title=paramMap.get("title").toString();
			String content=paramMap.get("content").toString();
			List taglibIds=(List)paramMap.get("taglibIds");
			Long[] tagIds=ParamMapUtils.converObjectArrayToLong(taglibIds);
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			List imagesArray=(List)paramMap.get("images");
			String[] images=ParamMapUtils.converObjectArrayToString(imagesArray);
			
			questionManager.insertQuestion(title, content, tagIds, userId,images);
			
		}else{
			
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
			
		}
		
		return resData;
	}
	
	/**
	 * 
	 * @author liushuaic
	 * @date 2016-05-09 17:02
	 * @desc 问题 支持与取消
	 * 
	 * */
	public ResponseMessage<String> updateQuestionStar(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		if(
			paramMap.containsKey("questionAnswerId")
			&& paramMap.containsKey("userId")
		){
			Long questionAnswerId=Long.valueOf(paramMap.get("questionAnswerId").toString());
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			questionAnswerManager.updateQustionAnswerStar(questionAnswerId, userId);
		}
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-10 16:30
	 * @desc 添加问题回复
	 * */
	public ResponseMessage<String> addQuestionAnswer(Map<String,Object> paramMap){
		ResponseMessage<String> resData=new ResponseMessage<String>();
		
		if(
			paramMap.containsKey("questionId")
			&& paramMap.containsKey("content")
		){
			Long questionId=Long.valueOf(paramMap.get("questionId").toString());
			Long createUserId=Long.valueOf(paramMap.get("userId").toString());
			String content=paramMap.get("paramMap").toString();
			
			questionAnswerManager.insertSelective(questionId, content, createUserId);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-11 14:29
	 * @desc 查询问题详情
	 * **/
	public ResponseMessage<Question> getQuestionDetailByQuestionId(Map<String,Object> paramMap){
		ResponseMessage<Question> resData=new ResponseMessage<Question>();
		if(paramMap.containsKey("questionId")){
			
			Long questionId=Long.valueOf(paramMap.get("questionId").toString());
			Long userId=null;
			if(paramMap.containsKey("userId") && (!StringUtils.isEmpty(paramMap.get("userId")))){
				userId=Long.valueOf(paramMap.get("userId").toString());
			}
			Question question=questionManager.getQuestionDetailByQuestionId(questionId,userId);
			resData.setData(question);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		
		return resData;
	}
	/**
	 * @author liushuaic
	 * @date 2016-06-07 14:29
	 * @desc 获取热门回复
	 * **/
	public ResponseMessage<List<QuestionAnswer>> getHotQuestionAnswer(Map<String,Object> paramMap){
		ResponseMessage<List<QuestionAnswer>> resData=new ResponseMessage<List<QuestionAnswer>>();
		Long userId=null;
		if(paramMap.containsKey("userId")){
			 userId=Long.valueOf(paramMap.get("userId").toString());
		}
		List<QuestionAnswer> questionAnswers=questionManager.getHotQuestionAnswer(userId);
		resData.setData(questionAnswers);
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-19 16:20
	 * @desc 获取某一个标签下的所有问题
	 * **/
	public ResponseMessage<List<Question>> getQuestionsByTaglibId(Map<String,Object> paramMap){
		ResponseMessage<List<Question>> resData=new ResponseMessage<List<Question>>();
		if(paramMap.containsKey("taglibId")){
			Long taglibId=Long.valueOf(paramMap.get("taglibId").toString());
			List<Question> questions=questionManager.getQuestionByTaglibid(taglibId);
			resData.setData(questions);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return resData;
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-07 11:26
	 * @desc 获取某一个用户创建的问题列表
	 * **/
	public ResponseMessage<List<Question>> getQuestionByCreateUserId(Map<String,Object> paramMap){
		ResponseMessage<List<Question>> resData=new ResponseMessage<List<Question>>();
		if(paramMap.containsKey("userId")){
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			List<Question> questions=questionManager.getQuestionByCreateUserId(userId);
			resData.setData(questions);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return resData;
	}

	
}
