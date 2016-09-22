package com.yikangyiliao.pension.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.base.utils.LogUtils;
import com.yikangyiliao.base.utils.messageUtil.im.Message;
import com.yikangyiliao.base.utils.messageUtil.im.MessageQueue;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.entity.Question;
import com.yikangyiliao.pension.entity.QuestionAnswer;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.entity.UserConfigration;
import com.yikangyiliao.pension.manager.MessageManager;
import com.yikangyiliao.pension.manager.QuestionAnswerManager;
import com.yikangyiliao.pension.manager.QuestionManager;
import com.yikangyiliao.pension.manager.UserConfigrationManager;
import com.yikangyiliao.pension.manager.UserManager;


/**
 * 
 * @author liushuaic
 * @date 2016-09-13 15:41
 * @desc  推送信息处理类
 * 
 * **/
@Component(value="questionStarOperation")
public class QuestionStarOperation implements Runnable{

	
	@Autowired
	private MessageManager messageManager;
	
	@Autowired
	private QuestionAnswerManager questionAnswerManager;
	
	@Autowired
	private QuestionManager questionManager;
	
	@Autowired
	private UserConfigrationManager userConfigrationManager;
	
	
	@Autowired
	private UserManager userManager;
	
	private static Logger LOG=LoggerFactory.getLogger(QuestionStarOperation.class);
	
	
	public void run() {
		
		while(true){
			
			try{
				
				OperationMessage operationMessage=OperationMessageQueue.takeQuestionAnswerStarMessage();
				String[] contentStrArray=operationMessage.getContent().split("-");
				Long questionAnswerId=Long.valueOf(contentStrArray[0]);
				Long fromUserId=Long.valueOf(contentStrArray[1]);
				
				QuestionAnswer questionAnswer=questionAnswerManager.selectiveByQuestionAnswerId(questionAnswerId);
				if(null != questionAnswer){
					Question question=questionManager.getQuestionByQuestionId(questionAnswer.getQuestionId());
					Long toUserId=questionAnswer.getCreateUserId();
					UserConfigration userConfigration= userConfigrationManager.getUserConfigration(toUserId);
					String title="有新的用户支持了，你在 “"+question.getTitle()+"” 的回答";
					// 判断用户是否打开了动态通知
					if(null == userConfigration || userConfigration.getDynamicAlert().equals(1)){
						try{
							User user=userManager.getUserByUserId(toUserId);
							Message<String> message=new Message<String>();
							message.setAlias(user.getPushAlias());
							message.setContent(title);
							message.setMessageCategroy(0);
							MessageQueue.put(message);
						}catch(Exception e){
							e.printStackTrace();
							LOG.error(LogUtils.getErrorStr(this.getClass().getName(), "run:82","极光推送异常:"+e.getMessage()));
						}
					}
					messageManager.insertQuestionAnswerStarMessage(fromUserId, toUserId, title, title, questionAnswerId);
				}
						
			}catch(Exception e){
				e.printStackTrace();
				LOG.error(LogUtils.getErrorStr(this.getClass().getName(), "run:90","exception:"+e.getMessage()));
			}
			
		}
		
	}
	
	

}
