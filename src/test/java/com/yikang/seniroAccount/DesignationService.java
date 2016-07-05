package com.yikang.seniroAccount;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class DesignationService {

	
	@Test
	public void getDesignations(Map<String,Object> paramMap){
		try{
			Map<String,Object> paramData=new HashMap<String, Object>();
			SendRequest.sendPost("00-17-14?appId=234&accessTicket=4286a50e808d04da0d39e4a83ef19f44aefb5c39877bd22903d981090d1f3b7c5e4c7afd323d91954ba85f0a1bf9bb45&machineCode=123123", paramData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
