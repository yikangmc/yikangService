package com.yikangyiliao.base.utils;


/**
 * @author liushuaic
 * @date 2016-09-13 10:42
 * @desc 获取日志列表
 * */
public class LogUtils {
	
	private static String splitStr="-->";
	
	private static String DEBUGSTR="debug";
	private static String INFOSTR="info";
	private static String WARNINGSTR="warning";
	private static String ERRORSTR="error";

	/**
	 * @author liushuaic
	 * @date 2016-09-13 10:55
	 * @param className 类名， methodName 方法名
	 * @return 2016-09-13 11:07:51-->info-->LogUitils-->getInfo
	 * */
	public static String getInfoStr(String className,String methodName){
		StringBuffer stringBuffer=new StringBuffer(DateUtils.getCurrentDateTimeStr()).append(splitStr).append(INFOSTR);
		return stringBuffer.append(splitStr).append(className).append(splitStr).append(methodName).toString();
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-09-13 10:55
	 * @param className 类名， methodName 方法名 otherStr 多添加的字符串
	 * @return 2016-09-13 11:07:51-->info-->LogUitils-->getInfo-->param:{11:22}
	 * */
	public static String getInfoStr(String className,String methodName,String otherStr){
		StringBuffer stringBuffer=new StringBuffer(DateUtils.getCurrentDateTimeStr()).append(splitStr).append(INFOSTR);
		return stringBuffer.append(splitStr).append(className).append(splitStr).append(methodName).append(splitStr).append(otherStr).toString();
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-09-13 10:55
	 * @param className 类名， methodName 方法名
	 * @return 2016-09-13 11:07:51-->warning-->LogUitils-->getInfo
	 * */
	public static String getWarningStr(String className,String methodName){
		StringBuffer stringBuffer=new StringBuffer(DateUtils.getCurrentDateTimeStr()).append(splitStr).append(WARNINGSTR);
		return stringBuffer.append(splitStr).append(className).append(splitStr).append(methodName).toString();
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-09-13 10:55
	 * @param className 类名， methodName 方法名 otherStr 多添加的字符串
	 * @return 2016-09-13 11:07:51-->warning-->LogUitils-->getInfo-->param:{11:22}
	 * */
	public static String getWarningStr(String className,String methodName,String otherStr){
		StringBuffer stringBuffer=new StringBuffer(DateUtils.getCurrentDateTimeStr()).append(splitStr).append(WARNINGSTR);
		return stringBuffer.append(splitStr).append(className).append(splitStr).append(methodName).append(splitStr).append(otherStr).toString();
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-09-13 10:55
	 * @param className 类名， methodName 方法名
	 * @return 2016-09-13 11:07:51-->warning-->LogUitils-->getInfo
	 * */
	public static String getErrorStr(String className,String methodName){
		StringBuffer stringBuffer=new StringBuffer(DateUtils.getCurrentDateTimeStr()).append(splitStr).append(ERRORSTR);
		return stringBuffer.append(splitStr).append(className).append(splitStr).append(methodName).toString();
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-09-13 10:55
	 * @param className 类名， methodName 方法名 otherStr 多添加的字符串
	 * @return 2016-09-13 11:07:51-->warning-->LogUitils-->getInfo-->param:{11:22}
	 * */
	public static String getErrorStr(String className,String methodName,String otherStr){
		StringBuffer stringBuffer=new StringBuffer(DateUtils.getCurrentDateTimeStr()).append(splitStr).append(ERRORSTR);
		return stringBuffer.append(splitStr).append(className).append(splitStr).append(methodName).append(splitStr).append(otherStr).toString();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(LogUtils.getInfoStr("LogUitils", "getInfo"));
		System.out.println(LogUtils.getInfoStr("LogUitils", "getInfo","param:{11:22}"));
	}
	
}
