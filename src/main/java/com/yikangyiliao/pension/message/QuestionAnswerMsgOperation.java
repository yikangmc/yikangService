package com.yikangyiliao.pension.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.base.utils.messageUtil.im.Message;
import com.yikangyiliao.base.utils.messageUtil.im.MessageQueue;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.entity.Question;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.MessageManager;
import com.yikangyiliao.pension.manager.QuestionAnswerManager;
import com.yikangyiliao.pension.manager.QuestionManager;
import com.yikangyiliao.pension.manager.UserManager;

@Component(value="questionAnswerMsgOperation")
public class QuestionAnswerMsgOperation implements Runnable{
	
	
	@Autowired
	private QuestionManager questionManager;
	

	@Autowired
	private QuestionAnswerManager questionAnswerManager;


	@Autowired
	private UserManager userManager;
	
	
	@Autowired
	private MessageManager messageManager;
	
	
	public void run() {

		while(true){
			try{
				OperationMessage operationMessage=OperationMessageQueue.getQuestionAnswerMessage();
				
				
				Long questionId=Long.valueOf(operationMessage.getContent());
				QuestionAnswer questionAnswer=questionAnswerManager.getQuestionAnswerByQuestionAnswerId(null,questionId);
				UserServiceInfo answerUser=userManager.getUserServiceInfoByUserIdTwo(questionAnswer.getCreateUserId());
				Long answerUserId=answerUser.getUserId();
				
				Question question=questionManager.getQuestionByQuestionId(questionAnswer.getQuestionId());
				Long questionCreateUserId=question.getCreateUserId();
				
				User questionUser=userManager.getUserByUserId(questionCreateUserId);
				
				String subTitle=question.getTitle().length()>20?question.getTitle().substring(0,20):question.getTitle();
				
				String alertTitle="“"+answerUser.getUserName()+"” 回答了你的问题 “"+subTitle+"”";
				String alertContent="“"+answerUser.getUserName()+"” 回答了你的问题 “"+subTitle+"”";
				
				Message<String> message=new Message<String>();
				message.setAlias(questionUser.getPushAlias());
				message.setContent(alertTitle);
				message.setMessageCategroy(0);
				MessageQueue.put(message);
				messageManager.insertDynamicFollowMessage(answerUserId, questionCreateUserId, alertTitle,alertContent,questionId,Byte.valueOf("1"));
			}catch(Exception  e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
}
