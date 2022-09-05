package com.quo.entity;

import lombok.Data;

/** 

* @author zhoumin

*/
@Data
public class SystemSettings {
	
	private Long amountCheck;			//审核金额标准
	
	private Integer expiry;				//有效期限

}
