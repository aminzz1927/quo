package com.quo.entity;

import lombok.Data;

@Data
public class EmpLogin {
	private int eno;       //员工编号
	private String pwd;   //密码
	private String flag;
}
