package com.quo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quo.entity.Customer;
import com.quo.entity.Dept;
import com.quo.service.CustomerService;
import com.quo.service.DeptService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;

@RestController("customerController")
@RequestMapping(value="/api")
public class CustomerController {
	@Autowired
	public CustomerService cService;
	@RequestMapping(value="/customer",method=RequestMethod.GET)
	  public Result findCustomerAll() {
	
		List<Customer> clist=cService.getAll();
	Result result=new Result(ResultCode.SUCCESS);
	System.out.println(clist);
	result.setData(clist);
	   return result;
	}
}
