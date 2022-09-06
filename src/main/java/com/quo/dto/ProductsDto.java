package com.quo.dto;

import lombok.Data;

@Data
public class ProductsDto {
	
	private Long pid;					//产品编号
	
	private String pname;				//产品名称
	
	private String tname;				//产品类型名称
	 
	private String psname;				//产品系列名称
		
	private double price;				//价格

	private int stock;					//库存

	

}
