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
	
	private Long qid;					//报价单编号
	
	private String qdate;				//报价日期
	
	private String abst;				//概要
	
	private String payment;				//付款方式
	
	private String expiry;				//有效期限
	
	private String edd;					//预计发货时间
	
	private Long cid;					//客户编号
	
	private Long pid;					//产品编号
	
	private Integer qsid;			//报价单状态
	
	

}
