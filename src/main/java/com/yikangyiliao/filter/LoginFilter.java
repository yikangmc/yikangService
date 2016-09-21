package com.yikangyiliao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.yikangyiliao.base.utils.NetworkUtil;


public class LoginFilter implements Filter {

	
	private Logger log=Logger.getLogger(LoginFilter.class);
	
	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest hsr=(HttpServletRequest)arg0;
		String requestURI=hsr.getRequestURI();
		String contextPath=hsr.getContextPath();

		if((!contextPath.equals("/") )&& (requestURI.indexOf(contextPath)>=0)){
			requestURI=requestURI.substring(contextPath.length());
		}
		
		String appId=hsr.getParameter("appId");
		String machineCode=hsr.getParameter("machineCode");
		String hostIp=NetworkUtil.getIpAddress(hsr);
		log.debug("登陆ip-->"+hostIp);
		
		//在登陆时，对ip 做登陆限制
		              
		if( null != appId &&  null != machineCode && machineCode.length()>1){
			arg2.doFilter(arg0, arg1);
		}else{
			arg1.setCharacterEncoding("utf-8");
			arg1.setContentType("application/json;charset=UTF-8");
			arg1.getWriter().print("{'status':'999999','message':'数据校验失败!'}");
		}

		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
