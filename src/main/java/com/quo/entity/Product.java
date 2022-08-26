package com.quo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private Long pid;
	
	private String pname;
	
	private int psid;
	
	private int stock;
	
	private String connection;
	
	private String pinterface;
	
	private String noise;
	
	private String bass;
	
	private String waterproof;
	
	private double price;
	
	private String packageInfo;

	

}
