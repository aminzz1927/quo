package com.quo.controller;

import java.io.BufferedReader;


import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.quo.entity.Emp;
import com.quo.exceptions.LoginException;
import com.quo.service.EmpService;
import com.quo.service.impl.EmpServiceImpl;
import com.quo.utils.Const;
import com.quo.utils.JsonUtil;
import com.quo.utils.MD5;
import com.quo.utils.OutJson;
import com.quo.utils.TransactionHandler;

/**
 * 
 * @author 韩宛廷
 *
 */
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jojStr = JsonUtil.getBody(request);
		System.out.println(jojStr);
		JSONObject joj = new JSONObject(jojStr);          
		//JsonUtil.toJson(request.getReader());
		System.out.println(joj);
		String enostr = joj.getString("eno");
		int eno = Integer.valueOf(enostr);
		String pwd = joj.getString("pwd");
		pwd =MD5.get(pwd);
		System.out.println(pwd);
		Map<String, Object> jsonMap = new HashMap<>();
		try {
			// 调用service登录(获取的对象是代理对象)
			EmpService empService = (EmpService) new TransactionHandler(new EmpServiceImpl()).getProxy();
			Emp emp = empService.login(eno, pwd);
			// 程序能执行到此处一定是登录成功了。
			request.getSession().setAttribute(Const.SESSION_USER, emp); // 向session域当中绑定当前登录的用户。
			jsonMap.put("success", true);

			// 登录成功之后，查看用户是否选择了十天内免登录
			String flag = joj.getString("flag");
			if ("1".equals(flag)) {
				String cookie1 = String.format("a=%d; max-age=864000; Path=%s; HttpOnly; Secure; SameSite=Lax;", eno,
						request.getContextPath());
				
				String cookie2 = String.format("b=%s; max-age=864000; Path=%s; HttpOnly; Secure; SameSite=Lax;", pwd,
						request.getContextPath());
				response.addHeader("Set-Cookie", cookie1);
				response.addHeader("Set-Cookie", cookie2);

			} else {
				String cookie1 = String.format("a=%d; Path=%s; HttpOnly; Secure; SameSite=Lax;", eno,
						request.getContextPath());
				String cookie2 = String.format("b=%s; Path=%s; HttpOnly; Secure; SameSite=Lax;", pwd,
						request.getContextPath());
				response.addHeader("Set-Cookie", cookie1);
				response.addHeader("Set-Cookie", cookie2);
			}

			if (pwd.equals("670b14728ad9902aecba32e22fa4f6bd")) {
				jsonMap.put("isNewUser", true);
				System.out.println("true"+pwd);
			} else {
				jsonMap.put("isNewUser", false);
				System.out.println("false"+pwd);
			}

		} catch (LoginException e) {
			jsonMap.put("success", false);
			jsonMap.put("isNewUser", false);
			jsonMap.put("errorMsg", e.getMessage());
		}
		// 响应json
		OutJson.print(response, jsonMap);
	}
}
