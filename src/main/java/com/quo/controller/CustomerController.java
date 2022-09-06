package com.quo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quo.entity.Customer;
import com.quo.entity.Customer2;
import com.quo.entity.Dept;
import com.quo.entity.ProductSeries2;
import com.quo.service.CustomerService;
import com.quo.service.DeptService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;
/**
 * 
 * @author 韩宛廷
 *
 */
@RestController("customerController")
@RequestMapping(value="/api")
public class CustomerController {
	@Autowired
	public CustomerService cService;
	
	
	/**
	 * 获取所有的顾客信息
	 * 
	 */
	@RequestMapping(value="/customer",method=RequestMethod.GET)
	  public Result findCustomerAll() {
	
		List<Customer2> clist=cService.getAll();
	Result result=new Result(ResultCode.SUCCESS);
	System.out.println(clist);
	result.setData(clist);
	   return result;
	}
	
	@RequestMapping(value = "/customer/{cid}", method = RequestMethod.GET)
	public Result findByCid(@PathVariable(value = "cid") int cid) {
        Customer customer=  cService.getByCid(cid);
	
		Result result = new Result(ResultCode.SUCCESS);
		result.setData(customer);
		return result;

	}
}
