package com.quo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quo.annotation.Permission;
import com.quo.dto.EmpDto;
import com.quo.dto.MenuDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.Emp;
import com.quo.entity.SystemSettings;
import com.quo.service.AuthorityService;
import com.quo.service.EmpService;
import com.quo.service.SystemService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;

/** 

* @author zhoumin

*/
@Controller("systemController")
@RequestMapping(value="/api")
public class SystemController {
	
	@Autowired
	public SystemService systemService;
	
	@Autowired
	public AuthorityService authorityService;
	
	@Autowired
	public EmpService eService;
	
	  //获取审核金额和有效期限
	  @RequestMapping(value="/system-setting",method=RequestMethod.GET)
	  @ResponseBody 
	  public Result getSystemSettings(){ 
		  
		  SystemSettings systemSettings = systemService.getSystemSettings(); 
		  Result result=new Result(ResultCode.SUCCESS);
		  result.setData(systemSettings);     
		  
		  return result;
	  
	  }
	 
	  //修改审核金额和有效期限
	  @RequestMapping(value="/system-setting",method=RequestMethod.PUT)
	  @ResponseBody 
	  public Result updateSystemSettings(@RequestBody SystemSettings systemSettings){ 
		  
		  systemService.updateSystemSettings(systemSettings);    
		  
		  return new Result(ResultCode.SUCCESS);
	  
	  }
	  
	  //获取用户登录信息和权限
	  @RequestMapping(value="/menu",method=RequestMethod.GET)
	  @ResponseBody 
	  public Result getMenu(HttpServletRequest request,MenuDto menuDto){ 
		  
		  Cookie[] cookies = request.getCookies();	
		  Integer eno = 0;
		  String pwd = null;
		  for(Cookie cookie : cookies) {
			  String name = cookie.getName();
			  String value = cookie.getValue();         	  		    
		    if(name.equals("a")) {
		    	String id = cookie.getValue(); 
		    	eno = Integer.valueOf(id);		       	
		    }		    
		    else if(name.equals("b")) {
		    	pwd = cookie.getValue();		    		    	
		    }			  	          
		  }	  		
		  
		  Emp emp = systemService.ifExists(eno,pwd);	  
		  EmpDto emp2 = systemService.getEmpDtoByEno(emp.getEno());
		  List<Integer> mids = authorityService.findListByRoleId(emp.getRid());
		  
		  menuDto.setEmpDto(emp2);
		  menuDto.setMids(mids);	
		  request.getSession().setAttribute("emp", emp);
		  request.getSession().setAttribute("permissions", mids);
		  System.out.println("AAAAAAAAAAA"+emp);
		  Result result=new Result(ResultCode.SUCCESS);
		  result.setData(menuDto); 
		  	  return result;
	  }
	  
	  
	
	

}
