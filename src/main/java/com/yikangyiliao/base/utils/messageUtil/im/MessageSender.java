package com.yikangyiliao.base.utils.messageUtil.im;

import java.util.List;

import com.yikangyiliao.base.utils.messageUtil.MessageUtils;

import cn.jpush.api.push.model.PushPayload;

/**
 * @author liushuaic
 * @date 2015/12/01 15:56
 * @desc 信息发送类
 * 
 **/
public class MessageSender implements Runnable {

	@SuppressWarnings("rawtypes")
	public void run() {
		while (true) {
			try {
				Message message = MessageQueue.pop();
				if (null == message) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {

					// 判断是一个别名的容器，是个别名的字符串
					List<String> aliasCollection = null;
					String aliasString = null;
					if (message.getAlias() instanceof List) {
						aliasCollection = (List<String>) message.getAlias();
					} else if (message.getAlias() instanceof String) {
						aliasString = (String) message.getAlias();
					}

					PushPayload pushPayload = null;
					if (message.getMessageCategroy() == 0) {
						if (null != aliasCollection) {
							pushPayload = MessageUtils.buildPushObject_all_alias_alert(aliasCollection,
									message.getContent());
						} else if (null != aliasString) {
							pushPayload = MessageUtils.buildPushObject_all_alias_alert(aliasString,
									message.getContent());
						}
					} else if (message.getMessageCategroy() == 1) {
						if (null != aliasCollection) {
							pushPayload = MessageUtils.buildPushObject_all_alias_alert(aliasCollection,
									message.getContent());
						} else if (null != aliasString) {
							pushPayload = MessageUtils.buildPushObject_all_alias_alert(aliasString,
									message.getContent());
						}
					}

					// 如果没有发送成功，重新放入，发送队列，只以是否推送到 极光为准。
					boolean isSended = MessageUtils.sendMessageByPushPayLoad(pushPayload);
					if (!isSended) {
						try {
							int retryNum = message.getRetrayNum();
							message.setRetrayNum(retryNum + 1);
							if (retryNum < 3) {
								MessageQueue.put(message);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Message m = new Message();
		m.setContent("测试");
		m.setAlias("message_info_934");
		m.setMessageCategroy(0);

		// Message m2=new Message();
		// m2.setContent("m2");
		// m2.setAlias("18899999999");
		// m2.setMessageCategroy(0);
		//
		// Message m3=new Message();
		// m3.setContent("m3");
		// m3.setAlias("18899999999");
		// m3.setMessageCategroy(0);
		//
		//
		// Message m4=new Message();
		// m4.setContent("m4");
		// m4.setAlias("18899999999");
		// m4.setMessageCategroy(0);
		//
		//
		MessageSender messageSender = new MessageSender();
		new Thread(messageSender).start();
		MessageSender messageSender2 = new MessageSender();
		new Thread(messageSender2).start();
		MessageSender messageSender3 = new MessageSender();
		new Thread(messageSender3).start();
		 MessageSender messageSender4=new MessageSender();
		 new Thread(messageSender4).start();
		for (int i = 0; i < 14; i++) {
			MessageQueue.put(m);
			MessageQueue.put(m);
			MessageQueue.put(m);
			MessageQueue.put(m);
		}

	}

}
