package com.quo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.quo.annotation.AnnotationParse;
import com.quo.annotation.Permission;
import com.quo.entity.Authority;
import com.quo.entity.Emp;
import com.quo.service.AuthorityService;
import com.quo.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhoumin
 */
@Component
@Aspect //声明切面
public class PermissionAspect {

	    @Autowired
	    private AuthorityService authorityService;
	    
		 

	    //@Around("execution(* com.quo.service.impl.*.*(..))")
	    public void permissionCheck(ProceedingJoinPoint joinPoint,HttpSession session) throws Throwable {
	       
	            
	      Emp emp = (Emp) session.getAttribute("emp"); 
	      Integer rid = emp.getRid();
	      
	      List<String> perms = authorityService.getPerms(rid);
			       
	 	  Class targetClass = joinPoint.getTarget().getClass();
	 	  String methodName=joinPoint.getSignature().getName();
	 	  
	 	  //得到访问该方法的权限
	 	  String methodAccess= AnnotationParse.parse(targetClass, methodName);
	 	  
	 	  boolean flag=false;
		  //遍历用户所有权限，查看是否有访问该方法的权限
	 	  for (String perm : perms){
	 		  //该用户能访问目标方法
	 		  if(methodAccess.equals(perm)){
	 			  flag=true;
	 			  
	 		  }
	 	  }
		  
	 	  if(flag){
	 		  //开放访问权限
	 		  joinPoint.proceed();
	 		  
	 	  }else{
	 		  System.out.println("无权限访问！");
	 	  }
	
		  
	  }


}
