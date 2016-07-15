package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class QueryUserInfoTest {
	
	@Test
	public void testRecommendUsersInfo(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			SendRequest.sendPost("00-41-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRecommendTaglibsInfo(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			SendRequest.sendPost("00-41-02?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertFeedbackInfo(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("createUserId", "12");
			paramData.put("content", "注意你的言行，这里使美国");
			paramData.put("connectMethod", "18612882495");
			SendRequest.sendPost("00-42-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
