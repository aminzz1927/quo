package com.quo.global;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
	
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		return false;
    	
		/* String requestURI = request.getRequestURI();
		Object empIsLogin = request.getSession().getAttribute("empIsLogin");
		System.out.println("链接"+requestURI+"进入拦截器！");
		if(empIsLogin == null){
			//表示未登录或者登录失效
			System.out.println("链接"+requestURI+"进入拦截器！");
		
		if(requestURI.contains(".js")||requestURI.contains(".css")||requestURI.contains("/img")||requestURI.contains("/login")){
			return true;
		}
		if(requestURI.toLowerCase().indexOf("login") >= 0){
		    return true;
		}
		
		HttpSession session = request.getSession();
		if(session.getAttribute("empIsLogin") != null){
			
		    return true; 
		}      
		}
		//response.sendRedirect("login");
		return false;*/
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
