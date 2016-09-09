package com.yikangyiliao.pension.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yikangyiliao.base.utils.MatchHtmlElementAttrValue;
import com.yikangyiliao.base.utils.ParamMapUtils;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.page.PageParameter;
import com.yikangyiliao.pension.common.response.ResponseMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.entity.Question;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.manager.IntegralManager;
import com.yikangyiliao.pension.manager.JobManager;
import com.yikangyiliao.pension.manager.QuestionAnswerManager;
import com.yikangyiliao.pension.manager.QuestionManager;
import com.yikangyiliao.pension.manager.UserManager;

@Service(value="questionService")
public class QuestionService {
	
	@Autowired
	private QuestionManager questionManager;
	
	@Autowired
	private QuestionAnswerManager questionAnswerManager;
	
	@Autowired
	private UserManager userManager;
	
	
	@Autowired
	private JobManager jobManager;
	
	@Autowired
	private IntegralManager integralManager;
	
	
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
			integralManager.insertIntegralAddScoreIsONCEJob("CCTW",userId);
			integralManager.insertIntegralAddScoreIsUsualJob("TGWT",Byte.valueOf("2"),userId);
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
	public ResponseMessage<Integer> updateQuestionStar(Map<String,Object> paramMap){
		ResponseMessage<Integer> resData=new ResponseMessage<Integer>();
		if(
			paramMap.containsKey("questionAnswerId")
			&& paramMap.containsKey("userId")
		){
			Long questionAnswerId=Long.valueOf(paramMap.get("questionAnswerId").toString());
			Long userId=Long.valueOf(paramMap.get("userId").toString());
			int isStar=questionAnswerManager.updateQustionAnswerStar(questionAnswerId, userId);
			resData.setData(isStar);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
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
			&& paramMap.containsKey("detailContent")
			&& paramMap.containsKey("htmlDetailContent")
			&& paramMap.containsKey("userId")
		){
			Long questionId=Long.valueOf(paramMap.get("questionId").toString());
			Long createUserId=Long.valueOf(paramMap.get("userId").toString());
			String detailContent=paramMap.get("detailContent").toString();
			String htmlDetailContent=paramMap.get("htmlDetailContent").toString();
			String[] images=new String[0];
			
			String content=detailContent.length()>100?detailContent.substring(0,100):detailContent;
			
			List<String> imageArray=MatchHtmlElementAttrValue.getImgSrc(htmlDetailContent);
			images=imageArray.toArray(images);
			
			QuestionAnswer questionAnswer=questionAnswerManager.insertSelective(questionId, content,detailContent,htmlDetailContent, createUserId,images);
			
			//推送信息
			OperationMessage operationMessage=new OperationMessage();
			operationMessage.setContent(questionAnswer.getQuestionAnswerId()+"");  //设置问题id
			operationMessage.setContentType(2+"");    //设置分类id
			OperationMessageQueue.putQuestionAnswerMessage(operationMessage);
			
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
		if(
				paramMap.containsKey("taglibId")
			&&  paramMap.containsKey("page")
		){
			
			Map<String,Object> resultMap=new HashMap<String,Object>();
			PageParameter page=new PageParameter();
			if(paramMap.containsKey("page")){
				int currentPage=Integer.valueOf(paramMap.get("page").toString());
				page.setCurrentPage(currentPage);
			}
			Long taglibId=Long.valueOf(paramMap.get("taglibId").toString());
			List<Question> questions=questionManager.getQuestionByTaglibid(taglibId,page);
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
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", userId);
			List<Question> questions=questionManager.getQuestionByCreateUserId(map);
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
	public ResponseMessage<List<Question>> getQuestionByCreateUserIdPage(Map<String,Object> paramMap){
		ResponseMessage<List<Question>> resData=new ResponseMessage<List<Question>>();
		if(paramMap.containsKey("serverUserId")&&paramMap.containsKey("page")){
			Long userId=Long.valueOf(paramMap.get("serverUserId").toString());
			Integer currentPage = Integer.valueOf(paramMap.get("page").toString());
			PageParameter pageParameter = new PageParameter();
			Map<String, Object> map = new HashMap<String, Object>();
			pageParameter.setCurrentPage(currentPage);
			map.put("page", pageParameter);
			map.put("userId", userId);
			List<Question> questions=questionManager.getQuestionByCreateUserIdPage(map);
			resData.setData(questions);
		}else{
			resData.setStatus(ExceptionConstants.parameterException.parameterException.errorCode);
			resData.setMessage(ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return resData;
	}
	
	

	
}
