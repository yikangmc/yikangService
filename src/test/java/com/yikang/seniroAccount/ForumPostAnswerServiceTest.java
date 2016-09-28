package com.yikang.seniroAccount;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class ForumPostAnswerServiceTest {
	
	
	@Test
	public void getForumPostAnswerList(){
		try{
			
			Map<String,Object> paramData=new HashMap<String, Object>();
			
			SendRequest.sendPost("00-46-01?appId=234&machineCode=123123",paramData);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	

}
