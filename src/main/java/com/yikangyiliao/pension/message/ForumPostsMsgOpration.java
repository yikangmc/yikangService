package com.yikangyiliao.pension.message;

import java.util.ArrayList;
import java.util.List;

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
import com.yikangyiliao.pension.entity.Taglib;
import com.yikangyiliao.pension.entity.UserConfigration;
import com.yikangyiliao.pension.entity.UserInfo;
import com.yikangyiliao.pension.manager.FormPostManager;
import com.yikangyiliao.pension.manager.MessageManager;
import com.yikangyiliao.pension.manager.TaglibManager;
import com.yikangyiliao.pension.manager.UserManager;

@Component(value = "forumPostsMsgOpration")
public class ForumPostsMsgOpration implements Runnable {

	@Autowired
	private FormPostManager formPostManager;

	@Autowired
	private TaglibManager taglibManager;

	@Autowired
	private MessageManager messageManager;

	@Autowired
	private UserManager userManager;

	private static Logger LOG=LoggerFactory.getLogger(ForumPostsMsgOpration.class);
	
	public void run() {

		while (true) {
			OperationMessage operationMessage = OperationMessageQueue.takeMessage();
			if (null != operationMessage) {
				try {
					Long forumPostId = Long.valueOf(operationMessage.getContent());
					FormPosts formPosts = formPostManager.selectByPrimaryKey(forumPostId);
					List<Taglib> taglibs = taglibManager.getTaglibsByForumPostId(forumPostId);

					// 查询这个关注这个标签的所有人员，发信息
					// 可以在做异步 ，一个发推送信息，一个保存到数据库，正常情况下是 已经存到数据库了，用户才会收到信息
					for (Taglib taglib : taglibs) {
						List<UserInfo> userInfos = userManager.getUserInfoListByTaglibId(taglib.getTaglibId()); // 应该按别名进行推送
						
						if (null != userInfos && userInfos.size() > 0) {
							List<String> pushAlias = new ArrayList<String>();
							
							String taglibAlert="你关注的标签有新内容了";
							
							for (UserInfo userInfo : userInfos) {
								messageManager.insertDynamicFollowMessage(-1l, userInfo.getUserId(),taglibAlert, formPosts.getTitle(),forumPostId,Byte.valueOf("4"));
								//判断被评论的用户是否开启了消息推送 0未开启，1已开启
								if(null!=UserConfigrationsCache.get(String.valueOf(userInfo.getUserId()))){
									UserConfigration userConfigration = (UserConfigration) UserConfigrationsCache.get(String.valueOf(userInfo.getUserId()));
									if(userConfigration.getDynamicAlert()==1){
										pushAlias.add(userInfo.getPushAlias());
										if (pushAlias.size() > 5) {
											try {
												Message<List<String>> pushMessage = new Message<List<String>>();
												pushMessage.setAlias(new ArrayList<String>(pushAlias));
												pushMessage.setContent(taglibAlert);
												MessageQueue.put(pushMessage);
												pushAlias = new ArrayList<String>();
											} catch (Exception e) {
												e.printStackTrace();
												LOG.error(LogUtils.getErrorStr(this.getClass().getName(), "run:79","极光推送异常:"+e.getMessage()));
											}
										}
									}
								}
							}
							try {
								Message<List<String>> pushMessage = new Message<List<String>>();
								pushMessage.setAlias(pushAlias);
								pushMessage.setContent(taglibAlert);
								MessageQueue.put(pushMessage);
							} catch (Exception e) {
								e.printStackTrace();
								LOG.error(LogUtils.getErrorStr(this.getClass().getName(), "run:92","极光推送异常:"+e.getMessage()));
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					LOG.error(LogUtils.getErrorStr(this.getClass().getName(), "run:98","exception:"+e.getMessage()));
				}
			}
		}
	}

}
