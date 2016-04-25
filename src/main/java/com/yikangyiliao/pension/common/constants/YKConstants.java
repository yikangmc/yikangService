package com.yikangyiliao.pension.common.constants;

public class YKConstants {

	
	
	
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
