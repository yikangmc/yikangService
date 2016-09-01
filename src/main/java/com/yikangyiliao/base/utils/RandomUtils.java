package com.yikangyiliao.base.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liushuaic
 * @date 2016-08-31 13:49
 * @desc 随机生成类
 * **/
public class RandomUtils {
	
	private static Logger logger=LoggerFactory.getLogger(RandomUtils.class);
	
	/**
	 * @author liushuaic
	 * @date 2016-08-31  14:17
	 * @desc 随机不重复的数据
	 * */
	public static int[] randomNumber(int maxNumber,int rtnCount) throws Exception{
		logger.info("starTime:"+Calendar.getInstance().getTimeInMillis());
		if(maxNumber == 0){
			throw new Exception("maxNnumber 不能为 0");
		}
		if(rtnCount == 0){
			throw new Exception("rtnCount 不能为 0");
		}
		//logger.info("maxNumber:"+maxNumber+"rtnCount:"+rtnCount);
		if(rtnCount>maxNumber){
			throw new ArrayIndexOutOfBoundsException("rtnCount 不能大于 maxNumber");
		}
		List<Integer> chacheArray=new ArrayList<Integer>();
		int[] rtnNumber=new int[rtnCount];
		for(int i=1;i<=maxNumber;i++){
			chacheArray.add(Integer.valueOf(i));
		}
		for(int j=0;j<rtnCount;j++){
			int index=new Random().nextInt(chacheArray.size());
			int val=chacheArray.get(index);
			rtnNumber[j]=val;
			chacheArray.remove(index);
			//logger.info("rtnData--index:"+j+" value:"+val);
		}
		logger.info("endTime:"+Calendar.getInstance().getTimeInMillis());
		return rtnNumber;
	}
	
	public static void main(String[] args) {
		try {
			RandomUtils.randomNumber(1000000, 10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
