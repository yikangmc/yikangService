package com.yikangyiliao.pension.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.page.PageParameter;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.entity.QuestionAnswersComment;
import com.yikangyiliao.pension.manager.QuestionAnswerComentManager;

@Service(value="questionAnswerComent")
public class QuestionAnswerComentService {


	private Logger logger=LoggerFactory.getLogger(QuestionAnswerComentService.class);
	@Autowired
	private QuestionAnswerComentManager answerComentManager;
	/**
	 * @author houyantao
	 * @date 2016-09-09 17:42
	 * @desc 添加解答评论
	 * */
	public ResponseMessage<String> addQuestionAnswersCommentDetail(Map<String,Object> paramMap){
		ResponseMessage<String> data=new ResponseMessage<String>();
		if(
				paramMap.containsKey("content")
				&& paramMap.containsKey("question_answer_id")
				//&& paramMap.containsKey("userId")
			){
			//评论者ID
			Long userId = Long.valueOf(paramMap.get("userId").toString());
			String content = paramMap.get("content").toString();
			Long questionAnswerId = Long.valueOf(paramMap.get("question_answer_id").toString());
			QuestionAnswersComment answersComment = new QuestionAnswersComment();
			answersComment.setCreateUserId(userId);
			answersComment.setQuestionAnswerId(questionAnswerId);
			answersComment.setContent(content);
			//被评论者ID
			if(paramMap.containsKey("to_userId")&&null!=paramMap.get("to_userId")&&!"".equals(paramMap.get("to_userId"))){
				Long to_userId = Long.valueOf(paramMap.get("to_userId").toString());
				answersComment.setToUserId(to_userId);
				answersComment.setAnswerTo(Byte.valueOf("2"));
			}else{
				answersComment.setAnswerTo(Byte.valueOf("1"));
			}
			answersComment.setCreateTime(new Date());
			answerComentManager.insertSelective(answersComment);
			try{
				OperationMessage operationMessage=new OperationMessage();
				operationMessage.setContent(String.valueOf(answersComment.getQuestionAnswersCommentId()));
				operationMessage.setContentType("2");
				OperationMessageQueue.putQuestionAnswersCommentQueue(operationMessage);
			}catch(Exception e){
				e.printStackTrace();
				logger.error("推送发生异常!");
			}

		}else{
			data.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			data.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return data;
	}
	
	
	/**
	 * @author houyantao
	 * @date 2016-09-09 17:42
	 * @desc 获取解答评论列表
	 * */
	public ResponseMessage<List<QuestionAnswersComment>> getQuestionAnswersCommentDetail(Map<String,Object> paramMap){
		ResponseMessage<List<QuestionAnswersComment>> data=new ResponseMessage<List<QuestionAnswersComment>>();
		if(
				paramMap.containsKey("question_answer_id")
				&& paramMap.containsKey("userId")
				&& paramMap.containsKey("page")
			){
			Long questionAnswerId = Long.valueOf(paramMap.get("question_answer_id").toString());
			Long userId = Long.valueOf(paramMap.get("userId").toString());
			Integer currentPage = Integer.valueOf(paramMap.get("page").toString());
			Map<String,Object> map = new HashMap<String, Object>();
			PageParameter page = new PageParameter();
			page.setCurrentPage(currentPage);
			map.put("page", page);
			map.put("questionAnswerId", questionAnswerId);
			List<QuestionAnswersComment> questionAnswersComments = answerComentManager.getQuestionAnswersCommentListByUserIdAndQuestionAnswerId(map);
			data.setData(questionAnswersComments);
		}else{
			data.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			data.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return data;
	}
}
