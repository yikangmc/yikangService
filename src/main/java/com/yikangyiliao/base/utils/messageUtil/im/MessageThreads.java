package com.yikangyiliao.base.utils.messageUtil.im;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author liushuaic
 * @date 2015/12/01 18:30
 * @desc 添加发送信息线程池
 * 主要用用于守护线程
 * 
 * **/
public class MessageThreads {
	
	private static MessageSender messageSender;
	
	static{
		messageSender=new MessageSender();
	}
	
	public void startSendMessage(){
		ThreadPoolExecutor threadPoolExecutor=
				new ThreadPoolExecutor(12, 20, 3000, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(3));
		threadPoolExecutor.execute(messageSender);
		threadPoolExecutor.execute(messageSender);
		threadPoolExecutor.execute(messageSender);
		threadPoolExecutor.execute(messageSender);
		threadPoolExecutor.execute(messageSender);
	}

	public static void main(String[] args) throws InterruptedException {
		
		MessageThreads messageThreads=new MessageThreads();
		messageThreads.startSendMessage();
		
		for(int i=0;i<50;i++){
			Message<String> message=new Message<String>();
			message.setAlias("message_info_934");
			message.setContent("测试信息");
			MessageQueue.put(message);
			MessageQueue.put(message);
			MessageQueue.put(message);
		}
	}
	
}
