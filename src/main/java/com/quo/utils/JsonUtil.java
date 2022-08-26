package com.quo.utils;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONObject;

public class JsonUtil  {
	
	public static JSONObject toJson(BufferedReader reader) {
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				jb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
		/*
		 * JSONObject jsonObject =
		 * HTTP.toJSONObject("{\"eno\":\"A0001\",\"pwd\":\"ass1\",\"flag\":\"0\"}");
		 */
		    
		return jsonObject;
	}
	
	public static String getBody(HttpServletRequest request)  {

	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        // throw ex;
	        return "";
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {

	            }
	        }
	    }

	    body = stringBuilder.toString();
	    return body;
	}


	
}
