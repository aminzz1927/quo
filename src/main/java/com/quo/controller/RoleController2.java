package com.quo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quo.entity.Role;
import com.quo.service.RoleService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;
@RestController("roleController")
@RequestMapping(value="/api")
public class RoleController2 {
	
		@Autowired
		public RoleService rService;
		
		@RequestMapping(value="/role",method=RequestMethod.GET)
		  public Result findRoleAll() {
			List<Role> rlist=	rService.getAll();
		Result result=new Result(ResultCode.SUCCESS);
		System.out.println(rlist);
		result.setData(rlist);
		   return result;
		}
}
