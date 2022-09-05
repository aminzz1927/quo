package com.quo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/** 

* @author zhoumin

*/
@Data
public class Product {
	
	private Long pid;     			 //产品编号
	
	private String pname;			 //产品名称
	
	private Integer psid;			 //产品系列编号
	
	private Integer stock;			 //库存
	
	private String connection;		 //耳机连接方式
	
	private String pinterface;		 //耳机接口
	
	private String noise;			 //降噪
	
	private String bass;			 //重低音
	
	private String waterproof;		 //防水功能
	
	private String mic;				 //麦克风
	
	private Double price;			 //价格
	
	private String packageInfo;		 //包装清单
	




	

}
