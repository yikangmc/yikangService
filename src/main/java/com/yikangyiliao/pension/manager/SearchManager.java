package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.TaglibDao;
import com.yikangyiliao.pension.entity.Taglib;

@Component
public class SearchManager {
	
	@Autowired
	private TaglibDao taglibDao;
	
	
	
	/**
	 * @author liushuaic
	 * @date 2016-04-26 10:09
	 * @desc 按标签的关键字搜索，标签
	 * **/
	public List<Taglib> searchTaglib(String tagLibStr){
		return null;
	}
	
	
	

}
