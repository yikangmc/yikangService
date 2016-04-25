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

import com.yikangyiliao.base.config.YiKangServiceConfige;
import com.yikangyiliao.base.utils.AccessTiketCheckout;
import com.yikangyiliao.base.utils.InterfaceUtil;
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
//		if(null != requestURI && !requestURI.equals("/service/login")){
//			HttpSession session=hsr.getSession();
//			if(null == session.getAttribute("sessionToket")){
//				session.setAttribute("sessionToket",this.strTokit);
//				System.out.println("set session");
//				arg0.getRequestDispatcher("/login.html").forward(arg0, arg1);
//			}
//		}

//		paramMap.put("appId", appId);
//		paramMap.put("accessTiket", accessTiket);

		if((!contextPath.equals("/") )&& (requestURI.indexOf(contextPath)>=0)){
			requestURI=requestURI.substring(contextPath.length());
		}
		
		String serviceCode=requestURI.replace("/service/", "");
		
		String appId=hsr.getParameter("appId");
		String accessTicket=hsr.getParameter("accessTicket");
		String hostIp=NetworkUtil.getIpAddress(hsr);
		log.debug("登陆ip-->"+hostIp);
		
			//在登陆时，对ip 做登陆限制
		
		YiKangServiceConfige yiKangServiceConfige=InterfaceUtil.getMethodYikangServiceConfigByServiceCode(serviceCode);
		
		if(
				(null != appId && appId.length()>1 && null != accessTicket && accessTicket.length() >= 0) 
				|| requestURI.equals("/service/login") 
				|| requestURI.equals("/service/registAndSaveServiceInfo") 
				|| (null != yiKangServiceConfige && !yiKangServiceConfige.getIsFileter())
		 ){
			try {
				if(		requestURI.equals("/service/login") 
					|| requestURI.equals("/service/registerUserAndSaveServiceInfo")
					|| requestURI.equals("/fileUpload/imgeFileUpload")	
					|| (null != yiKangServiceConfige && !yiKangServiceConfige.getIsFileter())
				 ){
					arg2.doFilter(arg0, arg1);
				}else if(null != accessTicket && AccessTiketCheckout.checkAccessTiketLayout(accessTicket, hsr)){
					arg2.doFilter(arg0, arg1);
				}
			} catch (Exception e) {
				log.error("登陆ip-->"+hostIp);
				e.printStackTrace();
			}
			
			
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
