package com.quo.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/** 

* @author zhoumin

*/

public interface SystemMapper {

	//获取审核金额
	@Select("select amountCheck from systemsettings")
	Long getAmountCheck();

	//更新审核金额
	@Update("update systemsettings set amountCheck=#{amountCheck}")
	boolean updateAmountCheck(Long amountCheck);

	//获取有效期
	@Select("select expiry from systemsettings")
	String getExpiry();

	//更新有效期
	@Update("update systemsettings set expiry=#{expiry}")
	boolean updateExpiry(String expiry);

}
