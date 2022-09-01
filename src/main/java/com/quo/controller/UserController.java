package com.quo.controller;

import java.util.List;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.quo.entity.Dept;
import com.quo.entity.Emp;
import com.quo.entity.EmpDto;
import com.quo.entity.EmpDto2;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
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
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	  public Result findEmpAll() {
		List<EmpDto2> elist=	uService.getEmpAll();
	Result result=new Result(ResultCode.SUCCESS);
	System.out.println(elist);
	result.setData(elist);
	   return result;
	}
	
	@RequestMapping(value="/user/{eno}",method = RequestMethod.GET)
    public Result findByEno(@PathVariable(value="eno") int eno) {
        EmpDto empdto= uService.getByEno(eno);
        Result result = new Result(ResultCode.SUCCESS);
       result.setData(empdto);
       return result;
    }
	
	@RequestMapping(value = "/user/{eno}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="eno") int eno, @RequestBody EmpDto empdto ) {
        //业务操作
		empdto.setEno(eno);
		uService.update(empdto);
        return new Result(ResultCode.SUCCESS);
    }
	
	@RequestMapping(value = "/user-reset/{eno}",method = RequestMethod.PUT)
    public Result updatePwd(@PathVariable(value="eno") int eno ) throws LoginException {
        //业务操作
		String pwd= uService.getPwdByEno(eno).getPwd();
		if(pwd.equals("670b14728ad9902aecba32e22fa4f6bd")){
			// throw new LoginException("是初始用户");
			return new Result(ResultCode.NOFIRSTUSER);
		} else {
			uService.changeEmpPwd(eno);
			return new Result(ResultCode.SUCCESS);
		}
		
    }
	
}
