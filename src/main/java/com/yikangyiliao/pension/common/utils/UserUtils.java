package com.yikangyiliao.pension.common.utils;

import org.springframework.context.ApplicationContext;

import com.yikangyiliao.base.cache.RedisExample;
import com.yikangyiliao.base.utils.ApplicationContextUtil;
import com.yikangyiliao.pension.entity.User;



/**
 * @author liushuaic
 * @date 2015/07/28 19:48
 * @desc 用户操作类
 * **/
@SuppressWarnings("unused")
public class UserUtils {

	
	private static ApplicationContext applicationContext=ApplicationContextUtil.applicationContext;
	
	private static RedisExample redisExample= ApplicationContextUtil.applicationContext.getBean(RedisExample.class);
	
	/**
	 * TODO 根据accessTiket 获取用户名称
	 * **/
	public static String getUserNameByAccessTiket(String accessTiket){
		return "";
	}
	
	/**
	 * TODO 根据accessTiket 获取用户id 
	 * **/
	public static Long getUserIdByAccessTiket(String accessTiket){
		return 0l;
	}
	
	public static User getUserByAccessTiket(String accessTiket){
		return new User();
		//return (User)redisExample.get(accessTiket);
	}
	
	
}
