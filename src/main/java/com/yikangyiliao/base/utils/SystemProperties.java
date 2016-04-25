package com.yikangyiliao.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author liushuaic
 * @date 2015/12/10 11:55
 * @desc system配置信息
 * **/
public class SystemProperties {
	
	private static Properties systemProperties=new Properties();
	
	static {
	 try {
			InputStream  inputStream=SystemProperties.class.getResource("/system.properties").openStream();
			systemProperties.load(inputStream);
		 } catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/12/01 11:54
	 * @desc 获取systemProperties 文件中的值
	 * */
	public static String getPropertieValue(String key){
		return systemProperties.getProperty(key);
	}

}
