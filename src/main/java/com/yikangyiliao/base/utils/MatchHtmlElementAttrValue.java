package com.yikangyiliao.base.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatchHtmlElementAttrValue {
	
	
	 private final static String regxpForHtml = "<([^>]*)>"; // 过滤所有以<开头以>结尾的标签
	
	  /**
     * 获取指定HTML标签的指定属性的值
     * @param source 要匹配的源文本
     * @param element 标签名称
     * @param attr 标签的属性名称
     * @return 属性值列表
     */
    public static List<String> match(String source, String element, String attr) {
        List<String> result = new ArrayList<String>();
        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?\\s.*?>";
        Matcher m = Pattern.compile(reg).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result.add(r);
        }
        return result;
    }

/**
     * 获取img标签中的src值
     * @param content
     * @return
     */
    public static List<String> getImgSrc(String content){
         
        List<String> list = new ArrayList<String>();
        //目前img标签标示有3种表达式
        //<img alt="" src="1.jpg"/>   <img alt="" src="1.jpg"></img>     <img alt="" src="1.jpg">
        //开始匹配content中的<img />标签
        Pattern p_img = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
        Matcher m_img = p_img.matcher(content);
        boolean result_img = m_img.find();
        if (result_img) {
            while (result_img) {
                //获取到匹配的<img />标签中的内容
                String str_img = m_img.group(2);
                 
                //开始匹配<img />标签中的src
                Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
                Matcher m_src = p_src.matcher(str_img);
                if (m_src.find()) {
                    String str_src = m_src.group(3);
                    list.add(str_src);
                }
                //结束匹配<img />标签中的src
                 
                //匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
                result_img = m_img.find();
            }
        }
        return list;
    }
 
    /**
     * @author liushuaic
     * @date 2016-06-27 17:35
     * @desc 替换&xxx;标签
     * */
    public static String  replaseAndCharachter(String str){
    	return str.replaceAll("&{1}[A-Za-z]+[;]{1}", "");
    }
    
    public static void main(String[] args) {
        String source = "<p><img alt=\"\" src=\"https://biophoto.s3.cn-north-1.amazonaws.com.cn/e645305e-29b9-4352-949f-e4ff52598492.png\" style=\"height:360px; width:1116px\" />helloqo r sadfasdf</p>";
//        List<String> list = getImgSrc(source);
        String list = replaceAllHtmlTagContent(source);
        System.out.println(list);
    }
    
    /**
     * @author liushuaic
     * @date 2016-06-24 10:35
     * @desc 替换所有html 标签为空
     * **/
    public static String replaceAllHtmlTagContent(String htmlContent){
    	return	htmlContent.replaceAll(regxpForHtml, ""); 
    }
    
    

}
