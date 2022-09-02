package com.quo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/** 

* @author zhoumin

*/
@Data
@NoArgsConstructor
public class MenuDto {
	
	private Integer eno;
	private String ename;
	private String dname;
	private String rname;
	private Integer[] mids;

}
