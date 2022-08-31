package com.quo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Long getAmountCheck() {
		// TODO Auto-generated method stub
		return systemMapper.getAmountCheck();
	}


	//更新审核金额
	@Override
	public boolean updateAmountCheck(Long amountCheck) {
		// TODO Auto-generated method stub
		return systemMapper.updateAmountCheck(amountCheck);
	}


	//获取有效期
	@Override
	public String getExpiry() {
		// TODO Auto-generated method stub
		return systemMapper.getExpiry();
	}


	//更新有效期
	@Override
	public boolean updateExpiry(String expiry) {
		// TODO Auto-generated method stub
		
		return systemMapper.updateExpiry(expiry);
		
	}
	
	

}
