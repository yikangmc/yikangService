package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;


public class LoginServiceTest {

	/**
	 * @author liushuaic
	 * @date 2015/08/20 18:20
	 * @desc 登陆测试
	 * */
	@Test
	public void TestLogin(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("userName","1号");
			paramData.put("password","1");
			paramData.put("machineCode",133);
			SendRequest.sendPost("login",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
