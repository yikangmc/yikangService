package com.yikangyiliao.pension.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.base.cache.UserConfigrationsCache;
import com.yikangyiliao.base.utils.LogUtils;
import com.yikangyiliao.base.utils.messageUtil.im.Message;
import com.yikangyiliao.base.utils.messageUtil.im.MessageQueue;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.entity.Question;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.entity.QuestionAnswersComment;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserConfigration;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.manager.MessageManager;
import com.yikangyiliao.pension.manager.QuestionAnswerComentManager;
import com.yikangyiliao.pension.manager.QuestionAnswerManager;
import com.yikangyiliao.pension.manager.QuestionManager;
import com.yikangyiliao.pension.manager.UserManager;

@Component(value="questionAnswerCommentOperation")
public class QuestionAnswerCommentOperation implements Runnable{
	
	private Logger log = LoggerFactory.getLogger(getClass());
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
				
				User toAnswerUser = userManager.getUserByUserId(answerUserId);
				
				String subTitle=question.getTitle().length()>20?question.getTitle().substring(0,20):question.getTitle();
				//评论的评论
				if("2".equals(questionAnswersComment.getAnswerTo().toString())){
					subTitle=questionAnswersComment.getContent().length()>20?questionAnswersComment.getContent().substring(0,20):questionAnswersComment.getContent();
					String alertTitle="“"+commentUser.getUserName()+"”回复了你 “"+subTitle+"”";
					String alertContent="“"+commentUser.getUserName()+"”回复了你 “"+subTitle+"”";
					messageManager.insertDynamicFollowMessage(commentUserId, toUserId, alertTitle,alertContent,questionAnswerId,Byte.valueOf("9"));
					//判断被评论的用户是否开启了消息推送 0未开启，1已开启
					if(null!=UserConfigrationsCache.get(String.valueOf(toUserId))){
						UserConfigration userConfigration = (UserConfigration) UserConfigrationsCache.get(String.valueOf(toUserId));
						if(userConfigration.getDynamicAlert()==1){
							Message<String> message=new Message<String>();
							message.setAlias(toUser.getPushAlias());
							message.setContent(alertTitle);
							message.setMessageCategroy(0);
							MessageQueue.put(message);
						}
					}else{
						log.error(LogUtils.getErrorStr(QuestionAnswer.class.getName(), "run", ""));
					}
				}else{//评论的解答
					String alertTitle="“"+commentUser.getUserName()+"”评论了你对问题 “"+subTitle+"”的回答";
					String alertContent="“"+commentUser.getUserName()+"”评论了你对问题 “"+subTitle+"”的回答";
					messageManager.insertDynamicFollowMessage(commentUserId, answerUserId, alertTitle,alertContent,questionAnswerId,Byte.valueOf("8"));
					//判断被评论的用户是否开启了消息推送 0未开启，1已开启
					if(null!=UserConfigrationsCache.get(String.valueOf(answerUserId))){
						UserConfigration userConfigration = (UserConfigration) UserConfigrationsCache.get(String.valueOf(answerUserId));
						if(userConfigration.getDynamicAlert()==1){
							try {
								Message<String> message=new Message<String>();
								message.setAlias(toAnswerUser.getPushAlias());
								message.setContent(alertTitle);
								message.setMessageCategroy(0);
								MessageQueue.put(message);
							} catch (Exception e) {
								e.printStackTrace();
								log.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:107", "极光推送异常:"+e.getMessage()));
							}
						}
					}else{
						log.error(LogUtils.getErrorStr(QuestionAnswer.class.getName(), "run", "用户缓存没有加载 ！"));
					}
				}
			}catch(Exception  e){
				e.printStackTrace();
				log.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:114", "exception:"+e.getMessage()));
			}
			
		}
		
	}
	
	
	
	
	
}
