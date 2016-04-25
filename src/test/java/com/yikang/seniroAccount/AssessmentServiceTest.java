package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class AssessmentServiceTest {

	@Test
	public void testSaveAssessment(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			//paramData.put("seniorId",44);
			//paramData.put("userId", 1);
			
//			String seniorId=paramData.get("seniorId").toString();
//			String userId=
			
			SendRequest.sendPost("00-23-01?appId=234&accessTicket=''&machineCode=123123", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
