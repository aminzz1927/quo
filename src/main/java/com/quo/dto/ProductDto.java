package com.quo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
	
	private Long pid;
	
	private String pname;
	
	private Integer tid;
	
	private String tname;

	private Integer psid; 

	private String psname;	
	
	private Double price;
	
	private int stock;
	
	private String connection;
	
	private String pInterface;
	
	private String noise;
	
	private String bass;
	
	private String waterproof;

    private String mic;
    
    private String packageInfo;


	

}
