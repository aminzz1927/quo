package com.quo.controller;

import java.util.List;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quo.entity.Dept;
import com.quo.entity.Emp;
import com.quo.entity.ProductSeries;
import com.quo.entity.Role;
import com.quo.exceptions.LoginException;
import com.quo.mapper.RoleMapper;
import com.quo.service.DeptService;
import com.quo.service.ProductSeriesService;
import com.quo.service.RoleService;

import com.quo.service.UserService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;
/**
 * 
 * @author 韩宛廷

 *
 */
@RestController("userController")
@RequestMapping(value="/api")
public class UserController {
	@Autowired
	public UserService uService;
	

	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	  public Result save(@RequestBody Emp emp) {
		emp.setPwd("670b14728ad9902aecba32e22fa4f6bd");
		uService.save(emp);
		System.out.println(emp);
		 return new Result(ResultCode.SUCCESS);
	}
	
	
	
	
}
