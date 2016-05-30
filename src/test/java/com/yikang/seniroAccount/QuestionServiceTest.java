package com.yikang.seniroAccount;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class QuestionServiceTest {

	
	
	@Test
	public void testGetQuestionByTaglibid(){
		//"
		
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("taglibId",1);
			SendRequest.sendPost("00-29-05?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetQuestionDetail(){
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("questionId",1);
			
			SendRequest.sendPost("00-29-04?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPublisQuestion(){
		try{
			Map<String,Object> paramData=new HashMap<String,Object>();
			paramData.put("title","问题标题");
			paramData.put("content","问题内容");
			Integer[] taglibsIds=new Integer[2];
			taglibsIds[0]=1;
			taglibsIds[1]=2;
			paramData.put("taglibIds", taglibsIds);
			
			SendRequest.sendPost("00-29-01?appId=234&accessTicket=99b5ee453affe2efad86f03909495dd1b9ce342e78fd9ac33497fe204e9991195e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
}
