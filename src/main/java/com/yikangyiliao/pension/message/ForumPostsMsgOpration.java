package com.yikangyiliao.pension.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.base.utils.messageUtil.im.Message;
import com.yikangyiliao.base.utils.messageUtil.im.MessageQueue;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessage;
import com.yikangyiliao.pension.common.utils.operationmesage.OperationMessageQueue;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.Taglib;
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

	public void run() {

		while (true) {
			OperationMessage operationMessage = OperationMessageQueue.takeMessage();
			if (null != operationMessage) {
				try {
					Long forumPostId = Long.valueOf(operationMessage.getContent());
					FormPosts formPosts = formPostManager.getForumPostsDetail(forumPostId,null);
					List<Taglib> taglibs = formPosts.getTaglibs();

					// 查询这个关注这个标签的所有人员，发信息
					// 可以在做异步 ，一个发推送信息，一个保存到数据库，正常情况下是 已经存到数据库了，用户才会收到信息
					for (Taglib taglib : taglibs) {
						List<UserInfo> userInfos = userManager.getUserInfoListByTaglibId(taglib.getTaglibId()); //应该按别名进行推送
						for (UserInfo userInfo : userInfos) {
							messageManager.insertDynamicFollowMessage(-1l, userInfo.getUserId(), "有新的文章了：" + formPosts.getTitle(), formPosts.getTitle());
							Message pushMessage = new Message();
							pushMessage.setAlias(userInfo.getPushAlias());
							pushMessage.setContent("你的关注有了新的内容 ：" + formPosts.getTitle());
							try {
								MessageQueue.put(pushMessage);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
