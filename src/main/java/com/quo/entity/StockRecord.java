package com.quo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 

* @author zhoumin

*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockRecord {
	
	private Integer hid;
	
	private Long pid;
	
	private Integer atid;
	
	private Integer preStock;
	
	private Integer quantity;
	
	private Integer afStock;
	
	private Integer heno;
	
	private String hdate;

}
