package com.yikangyiliao.base.utils;

import java.util.List;


/**
 * @author liushuai
 * @date 2016-05-09 16:41
 * **/
public class ParamMapUtils {
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-09 16:43
	 * @desc 转换paramMap中的List<Object>为  Long[]  数组
	 * **/
	public static Long[] converObjectArrayToLong(List array){
		Long[] retData=new Long[array.size()];
		for(int i=0;i<array.size();i++){
			retData[i]=Long.valueOf(array.get(i).toString());
		}
		return retData;
	}

	/**
	 * @author liushuaic
	 * @date 2016-05-28 18:03
	 * @desc 转换paramMap中的List<Object>为  String[]  数组
	 * **/
	public static String[] converObjectArrayToString(List array){
		String[] retData=new String[array.size()];
		for(int i=0;i<array.size();i++){
			retData[i]=array.get(i).toString();
		}
		return retData;
	}
}
