package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class ServicerServiceTest {

	
	
	
	
	
	/**
	 * @author liushuaic
	 * @date 2015-10-15 11:54
	 * @desc 测试获取服务人员
	 * */
	@Test
	public void getAssessmentServiceTest(){
		
		
		try {
			
//			null != paramData.get("districtCode")
//			&& null != paramData.get("mapPositionAddress")
//			&& null != paramData.get("detailAddress")
//			&& null != paramData.get("serviceDate")
//			&& null != paramData.get("custumerTimeQuantumId")
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("districtCode","1");
			paramData.put("mapPositionAddress","1");
			paramData.put("detailAddress","1");
			paramData.put("serviceDate","1");
			paramData.put("custumerTimeQuantumId","1");
			
			SendRequest.sendPost("00-22-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
