package com.quo.service.impl;

import java.util.List;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.quo.entity.Emp;
import com.quo.entity.EmpDto;
import com.quo.entity.EmpDto2;
import com.quo.exceptions.LoginException;
import com.quo.mapper.EmpMapper;
import com.quo.mapper.RoleMapper;
import com.quo.mapper.UserMapper;
import com.quo.service.UserService;
import com.quo.utils.SqlSessionUtil;


@Service("userService")
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserMapper umapper;


//添加新用户
		@Override
		public boolean save(EmpDto e){
			
		return	umapper.save(e)==1;
	
			}
		
		//获取所有用户信息
		@Override
		public List<Emp> getEmpAll() {
			return umapper.getEmpAll();
		}



		@Override
		public Emp getByEno(int eno) {
			
			return umapper.getByEno(eno);
		}


		//更新用户信息
		@Override
		public boolean update(EmpDto ed) {
			return	umapper.update(ed)==1;
			 }



		@Override
		public void changeEmpPwd(int eno) throws LoginException {
			
			if(umapper.changeEmpPwd(eno)<=0) {
				throw new LoginException("密码更新失败");
			}
			
		}



		@Override
		public Emp getPwdByEno(int eno) {
			return umapper.getPwdByEno(eno);
		}



		@Override
		public boolean deleteByEno(int eno) {
			return umapper.deleteByEno(eno) == 1;
		}



		@Override
		public boolean deleteByEnos(int[] enos) {
	
			return 	umapper.deleteByEnos(enos);
		}
		
		
}
	


