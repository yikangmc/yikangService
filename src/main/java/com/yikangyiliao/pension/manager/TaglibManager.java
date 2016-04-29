package com.yikangyiliao.pension.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yikangyiliao.pension.dao.TaglibDao;
import com.yikangyiliao.pension.entity.Taglib;

@Component
public class TaglibManager {

	@Autowired
	private TaglibDao taglibDao;
	
	
	/**
	 * @author liushuaic
	 * @date 2015-04-26 14:22
	 * @desc 获取标签列表
	 * **/
	public List<Taglib> getTaglibs(String tagName){
		return taglibDao.getTaglibs(tagName);
	}
}
