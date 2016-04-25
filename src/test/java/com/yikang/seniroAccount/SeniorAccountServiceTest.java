package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class SeniorAccountServiceTest {

	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-01 接口保存患者信息
	 * */
	@Test
	public void TestSaveSeniroAccount(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("appId", "");
			paramData.put("name","123123");
			paramData.put("sex","0");
			
			SendRequest.sendPost("00-01-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-03 查询某一个用户下的所有人
	 * getSeniorAccountByUserId
	 * */
	@Test
	public void TestGetSeniorAccountByUserId(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			//paramData.put("userId",1);
			
			SendRequest.sendPost("00-01-03",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-04 查询某一个用户下的所有人
	 * getSeniorAccountInfoByInvitationUserId
	 * */
	@Test
	public void TestGetSeniorAccountInfoByInvitationUserId(){
		try {
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("userStatus", -1);
			SendRequest.sendPost("00-01-04?appId=00-01&machineCode=123123&accessTicket=ae7433528cdd54dc76e922c1d612c82dfcfc343a64e68012c34c1b74c4cd73dd5e4c7afd323d91954ba85f0a1bf9bb45",paramData);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-04 查询某一个用户下的所有人
	 * getSeniorAccountInfoByInvitationUserId
	 * */
	@Test
	public void TestGetSeniorAccountByClentUserId(){
		try {
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			SendRequest.sendPost("00-01-05?appId=00-01&machineCode=123123&accessTicket=ae7433528cdd54dc76e922c1d612c82dfcfc343a64e68012c34c1b74c4cd73dd5e4c7afd323d91954ba85f0a1bf9bb45",paramData);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
