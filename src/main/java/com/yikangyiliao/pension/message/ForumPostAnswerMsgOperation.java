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
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.ForumPostsAnswer;
import com.yikangyiliao.pension.entity.UserConfigration;
import com.yikangyiliao.pension.entity.UserInfo;
import com.yikangyiliao.pension.manager.FormPostManager;
import com.yikangyiliao.pension.manager.ForumPostsAnswerManager;
import com.yikangyiliao.pension.manager.MessageManager;
import com.yikangyiliao.pension.manager.UserManager;

@Component(value="forumPostAnswerMsgOperation")
public class ForumPostAnswerMsgOperation implements Runnable{
	
	@Autowired
	private ForumPostsAnswerManager forumPostsAnswerManager;
	
	@Autowired
	private FormPostManager formPostManager;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private MessageManager messageManager;
	
	
	private static Logger LOG=LoggerFactory.getLogger(ForumPostAnswerMsgOperation.class);
	

	public void run() {
		while(true){
			
			OperationMessage operationMessage=OperationMessageQueue.takeForumPostsAnswer();
			if(null != operationMessage){
				Long forumPostAnswerId=Long.valueOf(operationMessage.getContent());
				ForumPostsAnswer forumPostsAnswer=forumPostsAnswerManager.getForumpostsAnswerByAnswerId(forumPostAnswerId);
				Long formPostId=forumPostsAnswer.getFormPostId();
				
				// 查询出创建人信息
				UserInfo createAnswerUserInfo=userManager.getUserInfoByUserId(forumPostsAnswer.getCreateUserId());
				
				FormPosts fp=formPostManager.selectByPrimaryKey(formPostId);
				UserInfo userInfo=userManager.getUserServiceInfoByForumPostId(fp.getForumPostId());
				
				String subForumPostTitle=fp.getTitle().length()>20?fp.getTitle().substring(0,20):fp.getTitle();
				String title="";
				
				// 帖子评论
				Byte contentGroup=Byte.valueOf("3");
				//判断是否为文章
				if(fp.getForumPostGroup().equals(Byte.valueOf("1"))){
					contentGroup=Byte.valueOf("6");
					 title="佳友 “" +createAnswerUserInfo.getUserName()+"” 评论了你的专家说 “"+subForumPostTitle+"” ";
				}else{
					 title="佳友 “" +createAnswerUserInfo.getUserName()+"” 评论了你的帖子 “"+ (fp.getContent().length()>20?fp.getContent().substring(0,20):fp.getContent())+"”";
				}
				//添加  文章回答的 动态信息 
				messageManager.insertDynamicFollowMessage(createAnswerUserInfo.getUserId(), fp.getCreateUserId(), title, title, fp.getForumPostId(), contentGroup);
				//判断被评论的用户是否开启了消息推送 0未开启，1已开启
				if(null!=UserConfigrationsCache.get(String.valueOf(fp.getCreateUserId()))){
					UserConfigration userConfigration = (UserConfigration) UserConfigrationsCache.get(String.valueOf(fp.getCreateUserId()));
					if(userConfigration.getDynamicAlert()==1){
						try{
							Message<String> messages=new Message<String>();
							messages.setAlias(userInfo.getPushAlias());
							messages.setContent(title);
							messages.setMessageCategroy(0);
							MessageQueue.put(messages);
						}catch(Exception e){
							e.printStackTrace();
							LOG.error(LogUtils.getErrorStr(this.getClass().getName(), "run:90","推送异常:"+e.getMessage()));
						}
					}
				}
			}
		}
	}

}
