package com.yikangyiliao.pension.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.base.utils.messageUtil.im.Message;
import com.yikangyiliao.base.utils.messageUtil.im.MessageQueue;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.User;
import com.yikangyiliao.pension.manager.FormPostManager;
import com.yikangyiliao.pension.manager.UserManager;

/**
 * @author liushuaic
 * @date 2016-06-13 11:08
 * @desc 文章支持操作业务
 * ***/
@Component(value="forumPostStarOperation")
public class ForumPostStarOperation implements Runnable{
	
	@Autowired
	private FormPostManager formPostManager;
	
	@Autowired
	private UserManager userManager;
	
	private static Logger log=LoggerFactory.getLogger(ForumPostStarOperation.class);

	
	public void run() {
		
		while(true){
			try{
				OperationMessage operationMessage=OperationMessageQueue.takeForumPostStarMessage();
				
				if(null != operationMessage){
					
					String forumPostId=operationMessage.getContent();
					FormPosts formPosts=formPostManager.selectByPrimaryKey(Long.valueOf(forumPostId));
					
					Long userId=formPosts.getCreateUserId();
					User user=userManager.getUserByUserId(userId);
					
					String pushAlias=user.getPushAlias();
					
					try{
						Message message=new Message();
						message.setAlias(pushAlias);
						message.setContent("文章有新的支持了! "+formPosts.getTitle());
						MessageQueue messageQueue=new MessageQueue();
						messageQueue.put(message);
					}catch(Exception e){
						e.printStackTrace();
						log.error(e.getMessage());
					}
					
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	

}
