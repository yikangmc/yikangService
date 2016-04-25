package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class TimeQuantumServiceTest {

	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-01 接口保存患者信息
	 * */
	@Test
	public void TestGetTimeQuantumsForCustomer(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("serviceDate","2015-01-01");
			
			SendRequest.sendPost("00-20-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
