package com.yikangyiliao.pension.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.base.utils.messageUtil.im.Message;
import com.yikangyiliao.base.utils.messageUtil.im.MessageQueue;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.entity.Question;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.entity.QuestionAnswersComment;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.MessageManager;
import com.yikangyiliao.pension.manager.QuestionAnswerComentManager;
import com.yikangyiliao.pension.manager.QuestionAnswerManager;
import com.yikangyiliao.pension.manager.QuestionManager;
import com.yikangyiliao.pension.manager.UserManager;

@Component(value="questionAnswerCommentOperation")
public class QuestionAnswerCommentOperation implements Runnable{
	
	
	@Autowired
	private QuestionManager questionManager;
	

	@Autowired
	private QuestionAnswerManager questionAnswerManager;
	
	@Autowired
	private QuestionAnswerComentManager questionAnswerCommentOperation;


	@Autowired
	private UserManager userManager;
	
	
	@Autowired
	private MessageManager messageManager;
	
	
	public void run() {

		while(true){
			try{
				OperationMessage operationMessage=OperationMessageQueue.takeQuestionAnswersComment();
				
				//questionAnswerCommentID
				Long questionAnswerCommentID=Long.valueOf(operationMessage.getContent());
				QuestionAnswersComment questionAnswersComment = questionAnswerCommentOperation.selectByPrimaryKey(questionAnswerCommentID);
				Long  questionAnswerId = questionAnswersComment.getQuestionAnswerId();
				QuestionAnswer questionAnswer=questionAnswerManager.getQuestionAnswerByQuestionAnswerId(null,questionAnswerId);
				UserServiceInfo answerUser=userManager.getUserServiceInfoByUserIdTwo(questionAnswer.getCreateUserId());
				Long answerUserId=answerUser.getUserId();
				
				UserServiceInfo commentUser = userManager.getUserServiceInfoByUserIdTwo(questionAnswersComment.getCreateUserId());
				Long commentUserId = commentUser.getUserId();
				
				Question question=questionManager.getQuestionByQuestionId(questionAnswer.getQuestionId());
				Long toUserId=questionAnswersComment.getToUserId();
				
				User toUser=userManager.getUserByUserId(toUserId);
				
				String subTitle=question.getTitle().length()>20?question.getTitle().substring(0,20):question.getTitle();
				//评论的评论
				if("2".equals(questionAnswersComment.getAnswerTo().toString())){
					subTitle=questionAnswersComment.getContent().length()>20?questionAnswersComment.getContent().substring(0,20):questionAnswersComment.getContent();
					String alertTitle="“"+commentUser.getUserName()+"”回复了你 “"+subTitle+"”";
					String alertContent="“"+commentUser.getUserName()+"”回复了你 “"+subTitle+"”";
					System.err.println(alertContent);
					Message<String> message=new Message<String>();
					message.setAlias(toUser.getPushAlias());
					message.setContent(alertTitle);
					message.setMessageCategroy(0);
					MessageQueue.put(message);
					messageManager.insertDynamicFollowMessage(commentUserId, answerUserId, alertTitle,alertContent,questionAnswerId,Byte.valueOf("1"));
				}else{//评论的解答
					String alertTitle="“"+answerUser.getUserName()+"”评论了你对问题 “"+subTitle+"”的回答";
					String alertContent="“"+answerUser.getUserName()+"”评论了你对问题 “"+subTitle+"”的回答";
					System.err.println(alertContent);
					Message<String> message=new Message<String>();
					message.setAlias(toUser.getPushAlias());
					message.setContent(alertTitle);
					message.setMessageCategroy(0);
					MessageQueue.put(message);
					messageManager.insertDynamicFollowMessage(commentUserId, answerUserId, alertTitle,alertContent,questionAnswerId,Byte.valueOf("1"));
				}
			}catch(Exception  e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
}
