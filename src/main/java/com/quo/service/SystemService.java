package com.quo.service;

import com.quo.dto.EmpDto;
import com.quo.dto.MenuDto;
import com.quo.entity.Emp;
import com.quo.entity.SystemSettings;

/** 

* @author zhoumin

*/

public interface SystemService {

	//获取审核金额和有效期限
	SystemSettings getSystemSettings();

	//更新审核金额和有效期限
	boolean updateSystemSettings(SystemSettings systemSettings);

	//获取登录信息及权限
	//MenuDto getMenuDto(int eno);

	//判断用户是否存在
	Emp ifExists(int eno, String pwd);

	EmpDto getEmpDtoByEno(int eno);




	
	

}
