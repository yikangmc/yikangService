package com.yikangyiliao.base.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.yikangyiliao.base.utils.messageUtil.im.MessageThreads;
import com.yikangyiliao.pension.schedule.PersonnelDistribution;


/**
 * @author liushuaic
 * @date 2015/10/10 10:41
 * @desc 加载一些基本的信息
 * 队列容器，是需要，在一个单独的地方存储的。
 * 这样才不会出现，问题。
 * **/
public class PorpertiesLonder implements ApplicationContextAware {

	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		
		PersonnelDistribution personnelDistribution=applicationContext.getBean(PersonnelDistribution.class);
		Thread thread=new Thread(personnelDistribution);
		thread.start();
		
		/**
		 * @author liushuaic
		 * @date 2015/12/08 11:49 信息推送
		 * **/
		MessageThreads messageThreads =new MessageThreads();
		messageThreads.startSendMessage();
	}

}
