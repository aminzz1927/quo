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

import com.quo.entity.Emp;
import com.quo.exceptions.LoginException;
import com.quo.service.EmpService;
import com.quo.service.impl.EmpServiceImpl;
import com.quo.utils.Const;
import com.quo.utils.OutJson;
import com.quo.utils.TransactionHandler;

/**
 * 
 * @author 韩宛廷
 *
 */
@WebServlet("/api/islogin")
public class IsLoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 获取浏览器提交的Cookie（Cookie可能有，也可能没有）
				Cookie[] cookies = request.getCookies(); // 请求没有Cookie的时候返回的不是一个长度为0的数组，而是null
				String enostr = "0";
				int eno = 0;
				String pwd = null;
				if(cookies != null){
					for(Cookie cookie : cookies){
						if("a".equals(cookie.getName())){
							enostr = cookie.getValue();
						} else if ("b".equals(cookie.getName())){
							pwd = cookie.getValue();
						}
					}
				}
				eno = Integer.valueOf(enostr);
				Map<String,Object> jsonMap = new HashMap<>();
				// 验证账号和密码是否仍然有效
				// 验证的前提是：账号和密码确实从Cookie中已经获取到了。
				if (eno != 0 && pwd != null){
					try {
						EmpService empService = (EmpService)new TransactionHandler(new EmpServiceImpl()).getProxy();
						Emp emp = empService.login(eno, pwd);
						request.getSession().setAttribute(Const.SESSION_USER, emp);
						
						jsonMap.put("isLogin", true);
					} catch (LoginException e) {
						e.printStackTrace();
						jsonMap.put("isLogin", false);
					}
					// 检查是否为新用户
					if(pwd.equals("670b14728ad9902aecba32e22fa4f6bd")){
						jsonMap.put("isLogin",false);
					}
				} else {
					jsonMap.put("isLogin", false);
				}
				// 响应json
				OutJson.print(response, jsonMap);
			}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
