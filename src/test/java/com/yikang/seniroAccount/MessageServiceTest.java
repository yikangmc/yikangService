package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class MessageServiceTest {

	@Test
	public void getSystemMessageByUserId(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			SendRequest.sendPost("00-35-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void getDynamicMessageByUserId(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			SendRequest.sendPost("00-35-02?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author houyt
	 * @serialData 2016/09/12 17:28
	 * @param paramMap
	 * @desc 测试通过消息标识标记此条状态为已读
	 * @return
	 */
	@Test
	public void testSetTheMessageAsRead(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("messagesId", 1842);
			SendRequest.sendPost("00-35-03?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author houyt
	 * @serialData 2016/09/12 17:28
	 * @param paramMap
	 * @desc 测试根据登录用户ID查询他的动态/系统 消息的未读数量
	 * @return
	 */
	@Test
	public void testGetMessageUnreadNumberByUserId(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			SendRequest.sendPost("00-35-04?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
