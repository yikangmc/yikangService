package com.yikangyiliao.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liushuaic
 * @date 2015/07/29 15:24
 * @desc 日期工具类
 * **/
public class DateUtils {
	
	
	private static String defaultFormateStr="yyyy-MM-dd";
	
	/**
	 * @param dataStr 2015-06-25
	 * @return  毫秒
	 * @author liushuaic
	 * @throws ParseException 
	 * @date 2015/07/29 15:42
	 * 列2015-10-10 获取的毫秒数为 2015-10-10 00:00:00
	 * ***/
	public static Long getＭillisecond(String dateStr) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(dateStr).getTime();
	}
	
	/**
	 * @param dataStr 2015-06-25
	 * @return  毫秒
	 * @author liushuaic
	 * @throws ParseException 
	 * @date 2015/07/29 15:42
	 * 列2015-10-10 获取的毫秒数为 2015-10-10 00:00:00
	 * ***/
	public static Date getDate(String dateStr) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(dateStr);
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/10/15 11:37
	 * @desc 获取当前日期的格式化的，字符串
	 * @return '20151015'
	 * 
	 * */
	public static String getFormateCurrenteDateStr(){
		
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyyMMdd");
		
		return sdf3.format(Calendar.getInstance().getTime());
		
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016/02/1 15:18
	 * @desc 格式化字符串 yyyy-MM-dd HH:mm:ss
	 * */
	public static String formateDate(Long dateTime){
		Date date=new Date(dateTime);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public static String formateDate(Date date){
		
		SimpleDateFormat sdf=new SimpleDateFormat(defaultFormateStr);
		return sdf.format(date);
				
	}
	
	public static void main(String[] args) throws ParseException {
		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date d=sdf.parse("2015-07-15");
//		System.out.println(d.getTime());
//		System.out.println(sdf2.format(sdf.parse("2015-07-15")));	
//		SimpleDateFormat sdf3=new SimpleDateFormat("yyyyMMdd");
//		System.out.println(sdf3.format(Calendar.getInstance().getTime()));
		
		Date date=Calendar.getInstance().getTime();
		SimpleDateFormat sdf2=new SimpleDateFormat("YYMMdd");
		System.out.println(sdf2.format(date));
		
		
		List<Map<String,Object>> datas=new ArrayList<Map<String,Object>>();
		Map<String,Object> d=new HashMap<String, Object>();
		d.put("dt", Calendar.getInstance().getTimeInMillis());
		datas.add(d);
		
		formateListObejctDateMilins(datas,"dt");
		
		System.out.println(datas.get(0).get("dt"));
	}

	/**
	 * @author liushuaic
	 * @date 2015/11/20 16:07
	 * @desc 格式化日期字符串
	 * **/
	public static void formateListObejctDateMilins(List<Map<String,Object>> datas,String properties){
		
		for(Map<String,Object> data:datas){
			Long dateTime=Long.valueOf(data.get(properties).toString());
			data.put(properties, DateUtils.formateDate(new Date(dateTime)));
		}
		
	}
	
	
}
