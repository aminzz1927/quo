package com.quo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 

* @author zhoumin

*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDetail {
	
	private Long qdid;
	
	private Long qid;
	
	private Long pid;
	
	private Double tax;
	
	private Double discount;
	
	private String payment;
	
	private Integer quantity;
	
	private String pname;
	
	private String ptype;
	
	private String pseries;
	
	private Double price;
	
	private String pstatus;
	

}
