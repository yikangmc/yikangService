package com.yikang.seniroAccount;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class CaptachaServiceTest {

	
	
	/**
	 * @author liushuaic
	 * @date 2016/03/22 15:22
	 * @desc 测试00-25-01 发送验证码
	 * */
	@Test
	public void TestGetDeviceAlias(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("mobileNumber","13716907523");
			SendRequest.sendPost("00-25-01?appId='234'&mobileNumber=13716907523",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String assessmentName=sdf.format(Calendar.getInstance().getTime());
		
		System.out.println(assessmentName);
	}
	
	
}
