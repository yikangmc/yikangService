package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class ScaleServiceTest {

	
	
	@Test
	public void testSaveAssement() {
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			paramData.put("assessmentName", "hello");
			paramData.put("seniorId", 1);

			SendRequest.sendPost("00-02-01", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSaveSocialParticipation(){
		Map<String, Object> paramData = new HashMap<String, Object>();
		paramData.put("assessmentId",1);
		paramData.put("viability",1);
		paramData.put("workingAbility",1);
		paramData.put("temporalOrientation",1);
		paramData.put("personalOrientation",1);
		paramData.put("socialIntercourse",1);
		paramData.put("totalScore",1);
		
		try {
			SendRequest.sendPost("00-02-03", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testSaveDailyIndexe(){
		Map<String, Object> paramData = new HashMap<String, Object>();
		
		paramData.put("assessmentId",1);
		paramData.put("seniorId",3);
		paramData.put("eat",1);
		paramData.put("bath",1);
		paramData.put("facialDecency",1);
		paramData.put("dressing",1);
		paramData.put("urinateControl",1);
		paramData.put("defecateControl",1);
		paramData.put("toileting",1);
		paramData.put("bedToChair",1);
		paramData.put("flatWalking",1);
		paramData.put("upanddownStairs",1);
		paramData.put("totalScore",1);
		
		try {
			SendRequest.sendPost("00-02-04", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testSaveMentalIndexes(){
		Map<String, Object> paramData = new HashMap<String, Object>();
		
		paramData.put("assessmentId",1);
		paramData.put("cognitiveFunction",3);
		paramData.put("attackBehavior",1);
		paramData.put("depressiveSymptoms",1);
		paramData.put("totalScore",1);
		
		
		try {
			SendRequest.sendPost("00-02-05", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
