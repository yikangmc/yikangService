package com.yikangyiliao.base.utils.messageUtil.im;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liushuaic
 * @date 2015/12/01 14:47
 * @desc 推送信息  队列
 * 
 * */
public class MessageQueue {
	
	private static BlockingQueue<Message> messageQueues=new LinkedBlockingQueue<Message>();

	
	public static synchronized void put(Message message) throws InterruptedException{
		messageQueues.put(message);
	}
	
	public static synchronized Message pop(){
		return messageQueues.poll();
	}
	
	public static synchronized Integer getMessagesSize(){
		return messageQueues.size();
	}
	
	
	
}
