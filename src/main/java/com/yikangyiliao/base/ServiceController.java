package com.yikangyiliao.base;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yikangyiliao.base.config.YiKangServiceConfige;
import com.yikangyiliao.base.encryption.AES;
import com.yikangyiliao.base.utils.AccessTiketCheckout;
import com.yikangyiliao.base.utils.ApplicationContextUtil;
import com.yikangyiliao.base.utils.InterfaceUtil;
import com.yikangyiliao.base.utils.LogUtils;
import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.response.ResponseMessage;

@Controller
public class ServiceController {

	private ObjectMapper objectMapper = new ObjectMapper();

	private Logger logger = Logger.getLogger(ServiceController.class);

	private final String passKey = "1234567890abcDEF";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/service/{serverviceCode}")
	@ResponseBody
	public Object doMethod(@PathVariable String serverviceCode, String appId, String accessTicket, String paramData,
			HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		logger.debug("controller 接收到请求  " + sdf.format(new Date()));
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		ResponseMessage responseMessage = new ResponseMessage();
		if (null != serverviceCode) {

			// 根据编码获取server 与 methodName
			YiKangServiceConfige yikangServiceConfige = InterfaceUtil
					.getMethodYikangServiceConfigByServiceCode(serverviceCode);
			if (null != yikangServiceConfige) {

				String beanName = yikangServiceConfige.getServiceName();
				String methodName = yikangServiceConfige.getMethodName();

				if (null != beanName && beanName.length() > 0 && null != methodName && methodName.length() > 0) {

					Object invokObject = ApplicationContextUtil.applicationContext.getBean(beanName);

					try {

						Method returnMethod = null;
						try{
							returnMethod = invokObject.getClass().getMethod(methodName,Map.class);
						}catch(Exception e){
							e.printStackTrace();
							logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod", e.getMessage()));
							rtnMap.put("status", "999999");
							rtnMap.put("message", "没有找到服务！");
							return rtnMap;

						}
						
							
						Map<String, Object> paramMap = new HashMap<String, Object>();
						
						//解密请求
						if (null != paramData && paramData.length() > 5) {
							paramData = AES.Decrypt(paramData, passKey);
							logger.debug("serviceController --> 接收到的paramData数据：" + paramData);
							paramMap = objectMapper.readValue(paramData, Map.class);
						}

						// 判断是否需要登陆，如果需要登陆就进行accessTicket校验
						if (yikangServiceConfige.getIsFileter()) {
							if (null != accessTicket ) {
								if(accessTicket.length() > 5){
									try{
										String UD = AccessTiketCheckout.getAccessTiketUD(accessTicket);
										String LDT = AccessTiketCheckout.getAccessTiketLDT(accessTicket);
										String MC = AccessTiketCheckout.getAccessTiketMC(accessTicket);
										paramMap.put("userId", UD);
										paramMap.put("loginDateTime", LDT);
										paramMap.put("machineCode", MC);
									}catch(Exception e){
										e.printStackTrace();
										logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod", e.getMessage()));
										responseMessage.setStatus( ExceptionConstants.accessTiketException.accessTikeCheckException.errorCode);
										responseMessage.setMessage( ExceptionConstants.accessTiketException.accessTikeCheckException.errorMessage);
										return responseMessage;
									}
								}else{
									responseMessage.setStatus( ExceptionConstants.accessTiketException.accessTikeCheckException.errorCode);
									responseMessage.setMessage( ExceptionConstants.accessTiketException.accessTikeCheckException.errorMessage);
									return responseMessage;
								}
							} else {
								responseMessage.setStatus( ExceptionConstants.accessTiketException.unlogin.errorCode);
								responseMessage.setMessage( ExceptionConstants.accessTiketException.unlogin.errorMessage);
								return responseMessage;

							}
						}else{
							if (null != accessTicket ) {
								if(accessTicket.length() > 5){
									try{
										String UD = AccessTiketCheckout.getAccessTiketUD(accessTicket);
										String LDT = AccessTiketCheckout.getAccessTiketLDT(accessTicket);
										String MC = AccessTiketCheckout.getAccessTiketMC(accessTicket);
										paramMap.put("userId", UD);
										paramMap.put("loginDateTime", LDT);
										paramMap.put("machineCode", MC);
									}catch(Exception e){
										e.printStackTrace();
										logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:130"));
									}
								}else{
									logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:133"));
								}
							} else {
								//logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:136"));
								logger.info("没有登陆！");
							}
						}
						

						try {

							Object res = returnMethod.invoke(invokObject, paramMap);
							if (res instanceof Map) {

								rtnMap = (Map<String, Object>) res;

								if (null != rtnMap && null != rtnMap.get("data")) {
									Object data = rtnMap.get("data");
									String jsonStr = "";
									if (!serverviceCode.equals("login")) {
										jsonStr = objectMapper.writeValueAsString(data);
									} else {
										jsonStr = data.toString();
									}

									String enStr = AES.Encrypt(jsonStr, passKey);
									rtnMap.put("data", enStr);
								}

								return rtnMap;

							} else if (res instanceof ResponseMessage) {
								responseMessage = (ResponseMessage) res;

								if (null != responseMessage && null != responseMessage.getData()) {

									Object data = responseMessage.getData();
									String jsonStr = "";
									if (!serverviceCode.equals("login")) {
										jsonStr = objectMapper.writeValueAsString(data);
									} else {
										jsonStr = data.toString();
									}

									String enStr = AES.Encrypt(jsonStr, passKey);
									responseMessage.setData(enStr);
								}

								return responseMessage;
							}

						} catch (Exception e) {
							logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:163", e.getMessage()));
							e.printStackTrace();
							rtnMap.put("status", ExceptionConstants.systemException.systemException.errorCode);
							rtnMap.put("message", ExceptionConstants.systemException.systemException.errorMessage);
							return rtnMap;
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
						logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:170", e.getMessage()));
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
						logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:174", e.getMessage()));
					} catch (InvocationTargetException e) {
						e.printStackTrace();
						logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:177", e.getMessage()));
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
						logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:177", e.getMessage()));
					} catch (SecurityException e) {
						e.printStackTrace();
						logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:182", e.getMessage()));
					} catch (JsonGenerationException e) {
						e.printStackTrace();
						logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:186", e.getMessage()));
					} catch (JsonMappingException e) {
						e.printStackTrace();
						logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:189", e.getMessage()));
					} catch (IOException e) {
						e.printStackTrace();
						logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:192", e.getMessage()));
					} catch (Exception e) {
						e.printStackTrace();
						logger.error(LogUtils.getErrorStr(getClass().getName(), "doMethod:195", e.getMessage()));
					}
				}
			}
			rtnMap.put("status", "999999");
			rtnMap.put("message", "没有对应服务！");
			return rtnMap;
		}
		rtnMap.put("status", "999999");
		rtnMap.put("message", "易康现在有点忙！");
		return rtnMap;
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public String doMethodw2(ModelMap map, HttpServletRequest request) {

		return "{status:'999999',message:'易康现在有点忙！',data:''}";
	}

}
