package com.quo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/** 

* @author zhoumin

*/
@Data
@NoArgsConstructor
public class QuotesDto {
	
	private Long qid;					//报价单编号

	private String abst;				//概要
	
	private String qdate;				//报价日期
	
	private Double totalAmount;			//总金额
	
	private String cname;				//客户名称
	
	private String qsname;				//报价单状态

	private String ename;			    //创建人
	
	

}
