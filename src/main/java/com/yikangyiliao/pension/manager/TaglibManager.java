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
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-11 16:49
	 * @desc 获取推荐的二级标签
	 * */
	public List<Taglib>  getRecommendTaglib(){
		return taglibDao.getRecommendTaglib();
	}
	
	/**
	 * @author liushuaic
	 * @date 2016-05-12 10:20
	 * @desc 获取一极列表标签
	 * **/
	public  List<Taglib> getFristTaglib(){
		return taglibDao.getFristTaglib();
	}
	
	
	/**
	 * @author liushuaic
	 * @date 2016-05-12 10:31
	 * @desc 查询出所有的二级标签 根据  parentId
	 * **/
	public  List<Taglib> getSecondTaglibByParentId(Long parentId){
		return taglibDao.getSecondTaglibByParentId(parentId);
	}
	
	
}
