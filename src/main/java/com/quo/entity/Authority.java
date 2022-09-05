package com.quo.entity;

import lombok.Data;
/** 

* @author zhoumin

*/
@Data
public class Authority {
		
	private Long rmid;				//权限id
	
	private Integer rid;			//角色id
	
	private Integer mid;			//菜单id
	
	private String mname;			//菜单名称

	

	

}
