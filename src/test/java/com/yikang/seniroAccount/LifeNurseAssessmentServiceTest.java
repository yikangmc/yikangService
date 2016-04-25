package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class LifeNurseAssessmentServiceTest {

	
	@Test
	public void testGetQuestionCrosswiseByTableName(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("assessmentName", "hello");
			paramData.put("seniorId", 1);

			SendRequest.sendPost("00-03-01", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGetQuestionUnitAnswerMapByQuetionCrosswiseId(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			//paramData.put("assessmentName", "hello");
			paramData.put("questionCrosswiseId", 1);

			SendRequest.sendPost("00-03-02", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testGetOldMan(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			//paramData.put("assessmentName", "hello");
			paramData.put("questionCrosswiseId", 1);

			SendRequest.sendPost("00-05-01", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
