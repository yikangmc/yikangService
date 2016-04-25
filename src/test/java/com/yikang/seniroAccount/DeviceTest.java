package com.yikang.seniroAccount;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class DeviceTest {
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/01 14:43
	 * @desc 测试00-18-01 注册设备
	 * */
	@Test
	public void TestSaveDevice(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("deviceType",1);
			paramData.put("deviceCode",2);
			paramData.put("codeType",1);
//			 *  deviceType  设备类型
//			 *  deviceCode  设备编码
//			 *  codeType	编码类型
			SendRequest.sendPost("00-18-01?appId='234'&accessTicket=9ca9e70575331308be798ffe29d99cb3164aa4d6fc24136f831baeadfe9071ec5e4c7afd323d91954ba85f0a1bf9bb45&machineCode='123123'",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2015/09/01 14:43
	 * @desc 测试00-18-02 获取用户的alias 用于，消息推送
	 * */
	@Test
	public void TestGetDeviceAlias(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			
			SendRequest.sendPost("00-18-02?appId='234'&accessTicket=9ca9e70575331308be798ffe29d99cb3164aa4d6fc24136f831baeadfe9071ec5e4c7afd323d91954ba85f0a1bf9bb45&machineCode='123123'",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(sdf.format(new Date(1439537378304l)));
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String assessmentName=sdf.format(Calendar.getInstance().getTime());
		
		System.out.println(assessmentName);
	}
}
