package com.quo.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/** 

* @author zhoumin

*/
@Data
@NoArgsConstructor
public class MenuDto {
	
	private EmpDto empDto;				//获取用户名、部门名、角色名
	private List<Integer> mids;			//权限集合

}
