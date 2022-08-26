package com.quo.utils;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 响应json工具类
 * @author Administrator
 *
 */
public class OutJson {
	
	private OutJson(){
		
	}
	
	/**
	 * 响应json，输出结果为：{"success" : true}或者{"success" : false}
	 * @param response
	 * @param success
	 */
	public static void print(HttpServletResponse response , boolean success){
		try {
			Map<String, Boolean> jsonMap = new HashMap<>();
			jsonMap.put("success", success);
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(jsonMap);
			response.setContentType("text/json;charset=UTF-8");
			response.getWriter().print(json);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 响应json
	 * @param response
	 * @param jsonMap
	 */
	public static void print(HttpServletResponse response , Object jsonMap){
		try {
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(jsonMap);
			response.setContentType("text/json;charset=UTF-8");
			response.getWriter().print(json);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


















