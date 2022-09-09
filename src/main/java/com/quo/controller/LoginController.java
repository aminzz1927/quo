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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quo.entity.Emp;
import com.quo.entity.EmpLogin;
import com.quo.exceptions.LoginException;
import com.quo.service.EmpService;
import com.quo.service.ProductService;
import com.quo.service.impl.EmpServiceImpl;
import com.quo.utils.Const;
import com.quo.utils.JsonUtil;
import com.quo.utils.MD5;
import com.quo.utils.OutJson;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;
import com.quo.utils.TransactionHandler;

/**
 * 
 * @author 韩宛廷
 *
 */
@Controller("loginController")
@RequestMapping(value = "/api")
public class LoginController {

	@Autowired
	public EmpService eService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Result login(HttpServletRequest request, HttpServletResponse response, @RequestBody EmpLogin emplogin){

		Result result = new Result();

		// 调用service登录(获取的对象是代理对象)
		int eno;
		try {
			String enostr = emplogin.getEno();
			eno = Integer.parseInt(enostr);
		} catch (NumberFormatException n) {
			result = new Result(ResultCode.FAIL);
			result.setMessage("IDまたはパスワードが正しくありません。");
			return result;
		}
		String pwd = emplogin.getPwd();
		String flag = emplogin.getFlag();
		try {
			pwd = MD5.get(pwd);
			eService.login(eno, pwd);
			if (pwd.equals("670b14728ad9902aecba32e22fa4f6bd")) {
				result = new Result(ResultCode.NEWUSER);
			} else {
				result = new Result(ResultCode.SUCCESS);
			}
			// 程序能执行到此处一定是登录成功了。
			request.getSession().setAttribute(Const.SESSION_USER, emplogin); // 向session域当中绑定当前登录的用户。

		} catch (LoginException e) {
			result = new Result(ResultCode.FAIL);
			result.setMessage(e.getMessage());
			return result;
		}

		// 登录成功之后，查看用户是否选择了十天内免登录
		if ("1".equals(flag)) {
			String cookie1 = String.format("a=%s; max-age=864000; Path=%s; HttpOnly; Secure; SameSite=Lax;", eno,
					request.getContextPath());
			String cookie2 = String.format("b=%s; max-age=864000; Path=%s; HttpOnly; Secure; SameSite=Lax;", pwd,
					request.getContextPath());
			response.addHeader("Set-Cookie", cookie1);
			response.addHeader("Set-Cookie", cookie2);

		} else {
			String cookie1 = String.format("a=%s; Path=%s; HttpOnly; Secure; SameSite=Lax;", eno,
					request.getContextPath());
			String cookie2 = String.format("b=%s; Path=%s; HttpOnly; Secure; SameSite=Lax;", pwd,
					request.getContextPath());
			response.addHeader("Set-Cookie", cookie1);
			response.addHeader("Set-Cookie", cookie2);
		}

		return result;

	}

	@RequestMapping(value = "/islogin", method = RequestMethod.GET)
	@ResponseBody
	public Result islogin(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		// 获取浏览器提交的Cookie（Cookie可能有，也可能没有）
		Cookie[] cookies = request.getCookies(); // 请求没有Cookie的时候返回的不是一个长度为0的数组，而是null
		String enostr = "0";
		int eno = 0;
		String pwd = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("a".equals(cookie.getName())) {
					enostr = cookie.getValue();
				} else if ("b".equals(cookie.getName())) {
					pwd = cookie.getValue();
				}
			}
		}
		eno = Integer.valueOf(enostr);
		// 验证账号和密码是否仍然有效
		// 验证的前提是：账号和密码确实从Cookie中已经获取到了。
		if (eno != 0 && pwd != null) {
			try {
				EmpLogin emplogin = eService.login(eno, pwd);
				request.getSession().setAttribute(Const.SESSION_USER, emplogin);
				result = new Result(ResultCode.SUCCESS);
			} catch (LoginException e) {
				e.printStackTrace();
				return new Result(ResultCode.FAIL);
			}
		}
		// 检查是否为新用户
		if (pwd.equals("670b14728ad9902aecba32e22fa4f6bd")) {
			result = new Result(ResultCode.FAIL);
		} else {
			result = new Result(ResultCode.SUCCESS);
		}
		return result;

	}

	@RequestMapping(value = "/resetpw", method = RequestMethod.POST)
	@ResponseBody
	public Result resetpwd(HttpServletRequest request, HttpServletResponse response, @RequestBody String newpwd) {
		System.out.println(newpwd);
		Result result = new Result();
		Cookie[] cookies = request.getCookies(); // 请求没有Cookie的时候返回的不是一个长度为0的数组，而是null
		String enostr = "0";
		int eno = 0;
		String pwd = null;
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("a".equals(cookie.getName())) {
					enostr = cookie.getValue();
				} else if ("b".equals(cookie.getName())) {
					pwd = cookie.getValue();
				}
			}
			
			try {
				eno = Integer.parseInt(enostr);
			} catch (NumberFormatException n) {
				result = new Result(ResultCode.FAIL);
				result.setMessage("IDまたはパスワードが正しくありません。");
				return result;
			}
		} else {
			 return new Result(ResultCode.FAIL);
		}

		Emp emp = new Emp();
		emp.setEno(eno);
		emp.setPwd(newpwd);//MD5.get(newpwd));
		if (eno != 0 && pwd != null) {
			try {
				//if 
				//eService.login(eno, MD5.get(pwd));
					eService.changePwd(emp);
					request.getSession().setAttribute(Const.SESSION_USER, emp); // 向session域
					result = new Result(ResultCode.SUCCESS);
//				}else {
//					result = new Result(ResultCode.FAIL);
//				}
			} catch (LoginException e) {
				result = new Result(ResultCode.FAIL);
				result.setMessage(e.getMessage());
				return result;
			}
		} else {
			result = new Result(ResultCode.FAIL);
		}
		return result;

	}

}
