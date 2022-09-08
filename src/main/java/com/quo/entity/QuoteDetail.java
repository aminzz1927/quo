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
	
	private Long qdid;           //报价单明细表id
	
	private Long qid;		     //报价单表id
	
	private Long pid;            //产品id
	
	private Double tax;			 //税率
	
	private Double discount;     //折扣
	
	private String payment;      //付款方式
	
	private Integer quantity;    //数量
	
	private String pname;        //产品名称
	
	private String ptype;        //产品类型
	
	private String pseries;		 //产品系列
	
	private Double price;   	 //产品价格
	
	private String pstatus;      //产品状态
	

}
