package com.quo.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.entity.Emp;
import com.quo.exceptions.LoginException;
import com.quo.mapper.RoleMapper;
import com.quo.mapper.UserMapper;
import com.quo.service.UserService;
import com.quo.utils.SqlSessionUtil;


@Service("userService")
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserMapper umapper;



		@Override
		public boolean save(Emp e){
			
			
			
		return	umapper.save(e)==1;
	
			}
}
	


