package com.yikang.seniroAccount;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class SicknessAssessmentServiceTest {

	
	/**
	 * @author liushuaic
	 * @date 2015/08/07 20:20
	 * @desc 获取疾病评估列表
	 * */
	@Test
	public void TestGetTable(){
		try {
			Map<String,Object> paramData=new HashMap<String, Object>();
			paramData.put("name","hello");
			paramData.put("sex",1);
			
			SendRequest.sendPost("00-06-01",paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
