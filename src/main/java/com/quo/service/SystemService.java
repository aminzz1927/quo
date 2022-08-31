package com.quo.service;

/** 

* @author zhoumin

*/

public interface SystemService {

	//获取审核金额
	Long getAmountCheck();

	//更新审核金额
	boolean updateAmountCheck(Long amountCheck);

	//获取有效期
	String getExpiry();

	//更新有效期
	boolean updateExpiry(String expiry);
	
	

}
