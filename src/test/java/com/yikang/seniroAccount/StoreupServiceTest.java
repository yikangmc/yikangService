package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class StoreupServiceTest {
	
	
	

	@Test
	public void getStoreupsByUserId(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			SendRequest.sendPost("00-37-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deleteStoreups(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("forumPostId", 1);
			SendRequest.sendPost("00-37-02?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void addFourmpostStoreup(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("forumPostId", 1);
			SendRequest.sendPost("00-37-03?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
