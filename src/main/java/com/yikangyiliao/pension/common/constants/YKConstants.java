package com.yikangyiliao.pension.common.constants;

public class YKConstants {

	
	public enum AnswerTo{
		
		/**
		 * 回复给个人
		 * **/
		AnswerToPersion(Byte.valueOf("2")),
		/**
		 * 回复给帖子
		 * */
		AnswerToFormPosts(Byte.valueOf("1"));
		private byte answerTo;
		
		private AnswerTo(byte answerTo){
			this.answerTo=answerTo;
		}
		 public byte getValue() {
		        return answerTo;
		    }
	}
	
	
	public enum OperateType{
		insert(0),delete(1),update(2),other(3);
		 private Integer value;
		 
	    private OperateType(Integer value) {
	        this.value = value;
	    }
		 
	    public Integer getValue() {
	        return value;
	    }
	}
	public static void main(String[] args) {
		System.out.println(YKConstants.OperateType.other.getValue());
	}
}
