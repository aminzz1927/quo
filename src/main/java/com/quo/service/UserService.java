package com.quo.service;



import java.util.List;

import com.quo.entity.Emp;
import com.quo.entity.EmpDto;
import com.quo.entity.EmpDto2;
import com.quo.entity.ProductSeries2;
import com.quo.entity.Role;
import com.quo.exceptions.LoginException;

public interface UserService {
	//添加用户信息
	boolean save(EmpDto e);
	//获取所有用户信息
	List<Emp> getEmpAll();
	//获取单个用户信息
	Emp getByEno(int eno);
	//更新用户信息
	boolean update(EmpDto ed);
	
	 //查询用户密码
	Emp getPwdByEno(int eno);
	//重置用户密码
	 void changeEmpPwd(int eno) throws LoginException;
	 //删除单个用户
	  boolean deleteByEno(int eno);
	  //删除单个用户
		boolean deleteByEnos(int[] enos);
	  }
