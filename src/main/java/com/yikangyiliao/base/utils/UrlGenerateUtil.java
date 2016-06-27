package com.yikangyiliao.base.utils;

import java.util.UUID;

public class UrlGenerateUtil {

	
	/**
	 * @author liushuaic
	 * @date 2016-06-17 18:05
	 * @desc 生成文章分享url
	 * **/
	public static String generateShareForumPostUrl(String uuid){
		String shareUrl=System.getProperty("shareForumPostUrl");
		return shareUrl+uuid;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-17 18:09
	 * @desc 生成问题回答分享url
	 * */
	public static String generateShareQuestionAnswerUrl(){
		String shareQuestionAnswerUrl=System.getProperty("shareQuestionAnswerDetailUrl");
		String uuid=UUID.randomUUID().toString();
		return shareQuestionAnswerUrl+uuid;
	}
	
}
