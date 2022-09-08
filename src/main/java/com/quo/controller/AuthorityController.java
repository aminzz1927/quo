package com.quo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quo.entity.Role;
import com.quo.service.RoleService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;


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
@Controller("authorityController")
@RequestMapping(value="/api")            
public class AuthorityController {
	@Autowired
	public AuthorityService authorityService;
	

	//获取某个角色的所有权限
	@RequestMapping(value="/authority/{rid}",method=RequestMethod.GET)
	@ResponseBody
	public Result getRoleAuthority(@PathVariable Integer rid){
		
		  List<Integer> authority = authorityService.findListByRoleId(rid);
		  System.out.println("AAAAAAAAAA"+authority);
		  Result result=new Result(ResultCode.SUCCESS);
		  result.setData(authority);

		return result;
		
	}
		

	//更新权限
		@RequestMapping(value="/authority/{rid}",method=RequestMethod.PUT)
		@ResponseBody
		public Result updateAuthority(@PathVariable Integer rid,
									  @RequestBody Integer[] mids){
			
			authorityService.deleteByRoleId(rid);
			  for(Integer mid:mids) {
			   Authority authority = new Authority();
			   authority.setRid(rid);
			   authority.setMid(mid);
			   authorityService.addAuthority(authority);
			  }

			return new Result(ResultCode.SUCCESS);
			
		}

	
	

}
	
	

