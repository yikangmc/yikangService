package com.yikang.seniroAccount;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.yikang.base.SendRequest;

public class AnswerServiceTest {

	@Test
	public void testSaveAnswer(){
		try {
			Map<String, Object> paramData = new HashMap<String, Object>();
			//paramData.put("assessmentName", "hello");
			paramData.put("assessmentId", 1);
			paramData.put("surveyTableId", 1);
			paramData.put("dataSource", 1);
			
			List<Map<String,Object>> questions=new ArrayList<Map<String,Object>>();
			
			Map<String,Object> question=new HashMap<String, Object>();
			question.put("questionId",1);
			

			List<Map<String,Object>> answers=new ArrayList<Map<String,Object>>();
			
			Map<String,Object> answer=new HashMap<String, Object>();
			answer.put("answerId", 1);
			answer.put("answerVal",1);
			answers.add(answer);
			
			Map<String,Object> answer2=new HashMap<String, Object>();
			answer2.put("answerId",2);
			answer2.put("answerVal",2);
			answers.add(answer);
			
			question.put("answers", answers);
			
			questions.add(question);
			
			
			paramData.put("questions", questions);

			SendRequest.sendPost("00-04-01", paramData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(Calendar.getInstance().getTime()));
	}
	
}
