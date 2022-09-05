package com.quo.controller;

import java.util.List;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	

	//添加新用户
	@RequestMapping(value="/user",method=RequestMethod.POST)
	  public Result save(@RequestBody EmpDto emp) {
		uService.save(emp);
		System.out.println(emp);
		 return new Result(ResultCode.SUCCESS);
	}
	
	//获取所有用户信息
	@RequestMapping(value="/users",method=RequestMethod.GET)
	  public Result findEmpAll() {
		List<Emp> elist=uService.getEmpAll();
	Result result=new Result(ResultCode.SUCCESS);
	System.out.println(elist);
	result.setData(elist);
	   return result;
	}
	//获取单个用户信息
	@RequestMapping(value="/user/{eno}",method = RequestMethod.GET)
    public Result findByEno(@PathVariable(value="eno") int eno) {
        Emp emp= uService.getByEno(eno);
        Result result = new Result(ResultCode.SUCCESS);
       result.setData(emp);
       return result;
    }
	
	//更新用户信息
	@RequestMapping(value = "/user/{eno}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="eno") int eno, @RequestBody EmpDto empdto ) {
        //业务操作
		empdto.setEno(eno);
		uService.update(empdto);
        return new Result(ResultCode.SUCCESS);
    }
	
	//重置密码
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
	
	 //删除单个产品
	@RequestMapping(value = "/user/{eno}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable(value = "eno") int eno) {
		uService.deleteByEno(eno);
		return new Result(ResultCode.SUCCESS);
	}
	
	 //删除多个产品
	  @RequestMapping(value="/users-del",method=RequestMethod.POST)		  
	  @ResponseBody 
	  public Result deleteByEnos(@RequestBody int[] enos){ 
		  uService.deleteByEnos(enos);
		  return new Result(ResultCode.SUCCESS);
	  
	  }
	
}
