package com.quo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quo.entity.Dept;
import com.quo.service.DeptService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;
@RestController("deptController")
@RequestMapping(value="/api")
public class DeptController {
	@Autowired
	public DeptService dService;
	@RequestMapping(value="/dept",method=RequestMethod.GET)
	  public Result findDeptAll() {
	
		List<Dept> dlist=	dService.getAll();
	Result result=new Result(ResultCode.SUCCESS);
	System.out.println(dlist);
	result.setData(dlist);
	   return result;
	}
}
