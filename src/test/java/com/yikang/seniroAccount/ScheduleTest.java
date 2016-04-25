package com.yikang.seniroAccount;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class ScheduleTest {

	
	
	
	/**
	 * @author liushuaic
	 * @throws IOException 
	 * @date 2015/09/18 11:43 
	 * 查询出来某一个月的所有的可个修改的天数
	 * **/
	@Test
	public void getScheduleByMonth() throws IOException{
		Map<String,Object> paramData=new HashMap<String, Object>();
		paramData.put("year", 2015);
		paramData.put("month", 9);
		SendRequest.sendPost("00-19-01?appId=234&accessTicket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		
		
	}
	
	/**
	 * @author liushuaic
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @date 2015/09/18 11:43 
	 * 获取某一天的具体工作内容
	 * **/
	@Test
	public void getServiceScheduleDetail() throws IOException, InterruptedException{
		SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		System.out.println("开始时间 "+sdf.format(new Date()));
		Map<String,Object> paramData=new HashMap<String, Object>();
		paramData.put("serviceDate", "2015-09-18");
		SendRequest.sendPost("00-19-02?appId=234&accessTicket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		System.out.println("结束时间 " +sdf.format(new Date()));
	}
	
	
	/**
	 * @author liushuaic
	 * @throws IOException 
	 * @date 2015/09/18 11:43 
	 * 获取某一天的具体工作内容
	 * **/
	@Test
	public void insertServiceScheduleDetail() throws IOException{
		Map<String,Object> paramData=new HashMap<String, Object>();
		paramData.put("serviceDate", "2015-09-28");
		int[] timeQuantumIds={1,2,3,4};
		paramData.put("timeQuantumIds", timeQuantumIds);
		SendRequest.sendPost("00-19-03?appId=234&accessTicket=6d454b32bf07ec80bd7258fe341712850540ae8e72ef6b48b13746e40a90a41d5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		
		
	}
	
	
}
