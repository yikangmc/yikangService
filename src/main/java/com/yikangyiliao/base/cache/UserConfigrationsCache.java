package com.yikangyiliao.base.cache;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author houyt
 * @date 2016-09-14 10:29
 * @desc 动态消息开关缓存类
 * */
public class UserConfigrationsCache {
	
	
	/**
	 *@author houyt
	 * @date 2016-09-14 10:43
	 *@desc 缓存
	 * */
	private static Map<String,Object> mapCache=Maps.newConcurrentMap();
	
	public static void clear(){
		mapCache.clear();
	}
	
	/**
	 * @author houyt
	 * @date 2016-09-14 10:43
	 * @desc 放入数据
	 * **/
	public static boolean put(String key,Object data){
		if(null == key){
			throw new NullPointerException("key 不能为空");
		}
		if(null == data){
			throw new NullPointerException("值 不能为空");
		}
		try{
			mapCache.put(key, data);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @author houyt
	 * @date 2016-09-14 10:43
	 * @desc 获取集合中的数据
	 * **/
	public static Object get(String key){
		return mapCache.get(key);
	}

	public static int getSize(){
		return mapCache.size();
	}

}
