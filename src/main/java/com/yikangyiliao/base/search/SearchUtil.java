package com.yikangyiliao.base.search;

import java.util.ArrayList;
import java.util.List;

import com.yikangyiliao.base.cache.SimpleCache;
import com.yikangyiliao.base.utils.RandomUtils;
import com.yikangyiliao.pension.entity.FormPosts;
import com.yikangyiliao.pension.entity.Taglib;

public class SearchUtil{
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-08-31 15:14 
	 * @desc 搜索出关的文章数据
	 * @return if search no match data return list size is 0 else return data 
	 * **/
	public static List<FormPosts> searchForumPosts(String title,String content,List<Taglib> taglibs,int retCount){
		List<FormPosts> rtnformPosts=new ArrayList<FormPosts>();
		if(retCount ==0){
			return rtnformPosts;
		}
		List<FormPosts> formPosts=(List<FormPosts>)SimpleCache.get("formPosts");
		
		if(null == formPosts || formPosts.size()==0){
			return rtnformPosts;
		}
		try {
			int[] indexArray=RandomUtils.randomNumber(formPosts.size(), retCount);
			for(int i=0;i<indexArray.length;i++){
				rtnformPosts.add(formPosts.get(indexArray[i]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rtnformPosts;
	}

}
