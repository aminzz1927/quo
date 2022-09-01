package com.quo.service;



import java.util.List;

import com.quo.entity.Emp;
import com.quo.entity.EmpDto;
import com.quo.entity.EmpDto2;
import com.quo.entity.ProductSeries2;
import com.quo.entity.Role;
import com.quo.exceptions.LoginException;

public interface UserService {
	
	boolean save(Emp e);
	
	List<EmpDto2> getEmpAll();

	EmpDto getByEno(int eno);
	
	boolean update(EmpDto ed);
	
   
	Emp getPwdByEno(int eno);
	
	 void changeEmpPwd(int eno) throws LoginException;
}
