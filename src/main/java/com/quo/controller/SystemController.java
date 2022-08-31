package com.quo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quo.dto.ProductsDto;
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
	
	  @RequestMapping(value="/amountcheck",method=RequestMethod.GET)
	  @ResponseBody 
	  public Result getAmountCheck(){ 
		  
		  Long amountCheck = systemService.getAmountCheck(); 
		  Result result=new Result(ResultCode.SUCCESS);
		  result.setData(amountCheck);     
		  
		  return result;
	  
	  }
	
	  @RequestMapping(value="/amountcheck",method=RequestMethod.PUT)
	  @ResponseBody 
	  public Result updateAmountCheck(@RequestBody Long amountCheck){ 
		  
		  systemService.updateAmountCheck(amountCheck);    
		  
		  return new Result(ResultCode.SUCCESS);
	  
	  }
	  
	  
	
	

}
