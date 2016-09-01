package com.yikangyiliao.base.cache;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author liushuaic
 * @date 2016-08-31 10:29
 * @desc 简单数据缓存类
 * */
public class SimpleCache {
	
	
	/**
	 *@author liushuaic
	 *@date 2016-08-31 10:30
	 *@desc 缓存
	 * */
	private static Map<String,Object> mapCache=Maps.newConcurrentMap();
	
	private static Date reloadDateTime=new Date();
	
	/**
	 * @author liushuaic
	 * @date 2016-08-31 10:57
	 * @desc 重新加载时间
	 * */
	public static void reloadData(Map<String,Object> paramData){
		mapCache=paramData;
		reloadDateTime=Calendar.getInstance().getTime();
	}
	
	public static void clear(){
		mapCache.clear();
		reloadDateTime=Calendar.getInstance().getTime();
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-08-31 10:49
	 * @desc 获取最新的更新时间
	 * */
	public Date getReloadDateTime(){
		return reloadDateTime;
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-08-31 11:06
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
	 * @author liushuaic
	 * @date 2016-08-31 11:09
	 * @desc 获取集合中的数据
	 * **/
	public static Object get(String key){
		return mapCache.get(key);
	}

	public static int getSize(){
		return mapCache.size();
	}

}
