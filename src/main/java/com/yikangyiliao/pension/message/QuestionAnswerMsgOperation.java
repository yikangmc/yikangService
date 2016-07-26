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
	
	public void run() {

		while(true){
			try{
				OperationMessage operationMessage=OperationMessageQueue.getQuestionAnswerMessage();
				
				
				Long questionId=Long.valueOf(operationMessage.getContent());
				QuestionAnswer questionAnswer=questionAnswerManager.getQuestionAnswerByQuestionAnswerId(null,questionId);
				User answerUser=userManager.getUserByUserId(questionAnswer.getCreateUserId());
				
				
				Question question=questionManager.getQuestionByQuestionId(questionAnswer.getQuestionId());
				Long userId=question.getCreateUserId();
				
				User user=userManager.getUserByUserId(userId);
				Message<String> message=new Message<String>();
				message.setAlias(user.getPushAlias());
//				message.setContent("你的文章有新的回答了 "+questionAnswer.getContent());
				message.setContent(answerUser.getUserName()+" 回答了你的问题");
				MessageQueue.put(message);
			}catch(Exception  e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
}
