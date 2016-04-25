package com.yikangyiliao.pension.common.utils.map;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.yikangyiliao.pension.common.utils.map.model.GeoCodeModel;

/**
 * @author liushuaic
 * @date 2015/10/15 12:27
 * @desc 地图位置 工具类
 * */
public class MapUtils {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private static String requestURl="http://restapi.amap.com/v3/";
	
	private static String KEYPARAM="key=062c151bbabb1e99cb6a45621c29b6d7";
	
	/**
	 * @author liushuaic
	 * @throws IOException 
	 * @date 2015/10/15 13:58
	 * @desc 获取经纬度，根据地址
	 * @param address 省+市+区+街道+门牌号
	 * @param city 北京/beijing/010/110000
	 * @param output json,xml
	 * @return GeoCodeModel
	 * 
	 * */
	public static GeoCodeModel getGeoCodeModelByAddress(String address,String city) throws IOException{
		
		String paramStr=KEYPARAM+"";
		if(null != address && address !=""){
			paramStr=paramStr+"&address="+URLEncoder.encode(address)+"";
		}
		if(null != city && city !=""){
			paramStr=paramStr+"&city="+city+"";
		}
		
		
		GeoCodeModel geoCodeModel=null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			
			String url=requestURl+"geocode/geo?"+paramStr;
			//System.out.println(url);
			HttpGet httpget = new HttpGet(url);

			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
						
					} else {
						throw new ClientProtocolException( "Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			//System.out.println(responseBody);
			if(null != responseBody){
				geoCodeModel=objectMapper.readValue(responseBody.getBytes(), GeoCodeModel.class);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			httpclient.close();
		} 
		
		
		return geoCodeModel;
	}
	public static void main(String[] args) throws IOException {
//		GeoCodeModel gmc=MapUtils.getGeoCodeModelByAddress("北京市海淀区万寿路光华护士基金",null);
//		System.out.println(gmc.getGeocodes().get(0).getLocation());
		
		String target="史各庄(公交站)";
		target=target.replace("("," ");
		target=target.replace(")"," ");
		
		System.out.println(URLEncoder.encode(target));
	}
	
}
