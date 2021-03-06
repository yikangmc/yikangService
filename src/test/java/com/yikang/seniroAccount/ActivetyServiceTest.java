package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class ActivetyServiceTest {

	
	@Test
	public void testGetActivetys(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			SendRequest.sendPost("00-31-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetActivetyByActiveyId(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("activetyId",1);
			SendRequest.sendPost("00-31-02?appId=234&machineCode=123123", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testInsertActivety(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("title","活动标题");
			paramData.put("content","活动内容<br>你好世界");
			paramData.put("startTime","2016-05-17 15:04:00");
			paramData.put("endTime","2016-05-18 15:04:00");
			paramData.put("entryStartTime","2016-05-16 08:04:00");
			paramData.put("entryEndTime","2016-05-16 15:04:00");
			paramData.put("mapPositionAddress","朝外们写中心B座501");
			paramData.put("detailAddress","易康美辰北京科技有限公司(BEIJING)");
			paramData.put("districtCode","110101");
			paramData.put("lng","12.00033");
			paramData.put("lat","1338.00333");
			paramData.put("personNumber","10");
			paramData.put("cost","20");
			
			List<Long> taglibs=new ArrayList<Long>();
			taglibs.add(1l);
			taglibs.add(2l);
			paramData.put("taglibs", taglibs);
			paramData.put("activetyMode", 1);

			SendRequest.sendPost("00-31-03?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-23 16:32
	 * @desc 报名参与活动
	 * **/
	@Test
	public void testInsertMyAcitivety(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("activetyId", 1);

			SendRequest.sendPost("00-31-04?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-23  16:50
	 * @desc 添加活动评论
	 * */
	@Test
	public void testInsertActivetyComment(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("activetyId", 1);
			paramData.put("content", "我添加的活动评论");
			
			SendRequest.sendPost("00-31-05?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-23 17:16
	 * @获取活动评论列表
	 * **/
	@Test
	public void testGetActivetyCommentByActivetyId(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("activetyId", 1);
			
			SendRequest.sendPost("00-31-06?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-09-08  11:23
	 * @获取活动评论列表
	 * **/
	@Test
	public void getActivetyByCreateUserIdPage(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("page", 1);
			SendRequest.sendPost("00-31-09?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

	/**
	 * @author liushuaic
	 * @date 2016-09-08  11:23
	 * @获取活动评论列表
	 * **/
	@Test
	public void getActivetyByServerUserIdPage(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("page", 1);
			paramData.put("serverUserId", 1);
			SendRequest.sendPost("00-31-10?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
