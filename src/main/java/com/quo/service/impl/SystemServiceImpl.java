package com.quo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.dto.MenuDto;
import com.quo.entity.Emp;
import com.quo.entity.SystemSettings;
import com.quo.mapper.SystemMapper;
import com.quo.service.SystemService;

/** 

* @author zhoumin

*/
@Service("systemService")
public class SystemServiceImpl implements SystemService {
	@Autowired
	public SystemMapper systemMapper;
	

	//获取审核金额
	@Override
	public SystemSettings getSystemSettings() {
		// TODO Auto-generated method stub
		return systemMapper.getSystemSettings();
	}


	//更新审核金额
	@Override
	public boolean updateSystemSettings(SystemSettings systemSettings) {
		// TODO Auto-generated method stub
		return systemMapper.updateSystemSettings(systemSettings);
	}


	//获取登录信息及权限
	@Override
	public MenuDto getMenuDto(int eno) {
		// TODO Auto-generated method stub
		return systemMapper.getMenuDto(eno);
	}


	@Override
	public Emp ifExists(int eno, String pwd) {
		// TODO Auto-generated method stub
		return systemMapper.ifExists(eno,pwd);
	}



	

}
