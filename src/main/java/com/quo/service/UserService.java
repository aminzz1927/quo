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
    
	Emp getByEno(int eno);
	//更新用户信息
	boolean update(EmpDto ed);
	
   
	Emp getPwdByEno(int eno);
	
	 void changeEmpPwd(int eno) throws LoginException;
	 
	  boolean deleteByEno(int eno);
	  
		boolean deleteByEnos(int[] enos);
	  }
