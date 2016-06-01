package com.yikangyiliao.base.utils.messageUtil.im;

import com.yikangyiliao.base.utils.messageUtil.MessageUtils;

import cn.jpush.api.push.model.PushPayload;

/**
 * @author liushuaic
 * @date 2015/12/01 15:56
 * @desc 信息发送类
 * 
 * **/
public class MessageSender implements Runnable {

	public void run() {
		while (true){
			Message message=MessageQueue.pop();
			if(null == message){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				PushPayload pushPayload=null;
				if(message.getMessageCategroy()==0){
					pushPayload=MessageUtils.buildPushObject_all_alias_alert(message.getAlias(), message.getContent());
				}else if(message.getMessageCategroy()==1){
					pushPayload=MessageUtils.buildPushObject_tag_alert(message.getAlias(), message.getContent());
				}
				
				//如果没有发送成功，重新放入，发送队列，只以是否推送到 极光为准。
				boolean  isSended=MessageUtils.sendMessageByPushPayLoad(pushPayload);
				if(!isSended){
					try {
						int retryNum=message.getRetrayNum();
						message.setRetrayNum(retryNum+1);
						if(retryNum<3){
							MessageQueue.add(message);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			
		}
	}
	public static void main(String[] args) throws InterruptedException {
				Message m=new Message();
				m.setContent("m");
				m.setAlias("message_info_46");
				Message m2=new Message();
				m2.setContent("m2");
				m2.setAlias("message_info_46");
				Message m3=new Message();
				m3.setContent("m3");
				m3.setAlias("message_info_46");
				Message m4=new Message();
				m4.setContent("m4");
				m4.setAlias("message_info_46");
				MessageQueue.put(m);
				MessageQueue.put(m2);
				MessageQueue.put(m3);
				MessageQueue.put(m4);
				
				MessageSender messageSender=new MessageSender();
				new Thread(messageSender).start();
		
	}
	
}
