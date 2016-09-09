package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class QuestionAnswerCommentTest {
	
	@Test
	public void testInsertQuestionAnswerComment(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("userId", 137);
			paramData.put("content", "测试回复内容");
			paramData.put("question_answer_id", 39);
			paramData.put("to_userId", 20);
			SendRequest.sendPost("00-45-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetQuestionAnswerComment(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("question_answer_id", 1678);
			paramData.put("userId", 20);
			paramData.put("page", 1);
			SendRequest.sendPost("00-45-02?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
