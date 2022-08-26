package com.quo.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.quo.entity.Emp;
import com.quo.exceptions.LoginException;
import com.quo.service.EmpService;
import com.quo.service.impl.EmpServiceImpl;
import com.quo.utils.Const;
import com.quo.utils.JsonUtil;
import com.quo.utils.MD5;
import com.quo.utils.OutJson;
import com.quo.utils.TransactionHandler;


@WebServlet("/api/resetpw")
public class ResetPwdController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies(); // 请求没有Cookie的时候返回的不是一个长度为0的数组，而是null
		String eno = null;
		String pwd = null;
		if(cookies != null){
			for(Cookie cookie : cookies){
				if("a".equals(cookie.getName())){
					eno = cookie.getValue();
				} else if ("b".equals(cookie.getName())){
					pwd = cookie.getValue();
				}
			}
		}
		String jojStr = JsonUtil.getBody(request);
		System.out.println(jojStr);
		JSONObject joj = new JSONObject(jojStr);          
		//JsonUtil.toJson(request.getReader());
		System.out.println(joj);
		String newpwd = joj.getString("pwd");
		Emp emp=new Emp();
		emp.setEno(eno);
		emp.setPwd(MD5.get(newpwd));
		Map<String, Object> jsonMap = new HashMap<>();
		if (eno != null && pwd != null){
			EmpService empService = (EmpService) new TransactionHandler(new EmpServiceImpl()).getProxy();
			  
			try {
				empService.changePwd(emp);
				request.getSession().setAttribute(Const.SESSION_USER, emp); // 向session域
				jsonMap.put("success", true);
			} catch (LoginException e) {
				jsonMap.put("success", false);
				jsonMap.put("errorMsg", e.getMessage());
			}
		// 响应json
		OutJson.print(response, jsonMap);
	
	}

	

	}
}
