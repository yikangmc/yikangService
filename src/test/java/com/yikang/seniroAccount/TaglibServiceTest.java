package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class TaglibServiceTest {

	
	
	@Test
	public void  getRecommendTaglib(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			
			SendRequest.sendPost("00-30-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void  geAllTaglib(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			
			SendRequest.sendPost("00-30-04?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-06-01  10:11
	 * @desc 获取我关注的用户
	 * */
	@Test
	public void  geMyWatchTaglib(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			
			SendRequest.sendPost("00-30-05?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-06-01  10:11
	 * @desc 获取我关注的用户
	 * */
	@Test
	public void  testGetSencondTaglib(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			
			SendRequest.sendPost("00-30-06?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
