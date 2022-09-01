package com.quo.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/** 

* @author zhoumin

*/
@Data
@NoArgsConstructor
public class Quote {
	
	private Long qid;
	
	private String qdate;
	
	private String abst;
	
	private String payment;
	
	private String expiry;
	
	private String edd;
	
	private Long cid;
	
	private Long pid;
	
	
	
	

}
