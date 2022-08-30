package com.quo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quo.dto.AuthorityDto;
import com.quo.dto.ProductDto;
import com.quo.entity.Authority;
import com.quo.service.AuthorityService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;

/** 

* @author zhoumin

*/
@Controller("roleController")
@RequestMapping(value="/api")
public class RoleController {
	@Autowired
	public AuthorityService authorityService;
	

	//获取某个角色的所有权限
	@RequestMapping(value="/get_role_authority",method=RequestMethod.GET)
	@ResponseBody
	public Result getRoleAuthority(Integer rid){
		
		  List<AuthorityDto> authority = authorityService.findListByRoleId(rid);
		  System.out.println("AAAAAAAAAA"+authority);
		  Result result=new Result(ResultCode.SUCCESS);
		  result.setData(authority);

		return result;
		
	}
	
	

	
	
	

}
