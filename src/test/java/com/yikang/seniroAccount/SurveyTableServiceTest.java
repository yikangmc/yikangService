package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;


public class SurveyTableServiceTest {

	
	
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-01 接口保存患者信息
	 * */
	@Test
	public void TestGetTableList(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("seniorId",1);
			
			SendRequest.sendPost("00-16-01",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @author liushuaic
	 * @date 2015/07/28 12:15
	 * @desc 测试00-01-01 接口保存患者信息
	 * */
	@Test
	public void TestGetQuestionAndAnswersIsCheckTwo(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("assessmentId",1);
			paramData.put("surveyTableId",1);
			paramData.put("questionCrosswiseId",1);
			SendRequest.sendPost("00-16-03",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author liushuaic
	 * @date 2015/08/24 12:26
	 * @desc 测试00-16-04 接口保存患者信息
	 * */
	@Test
	public void TestGetQuestionAndAnswersIsCheckThree(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("assessmentId",1);
			paramData.put("surveyTableId",1);
			paramData.put("questionCrosswiseId",1);
			SendRequest.sendPost("00-16-04",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
