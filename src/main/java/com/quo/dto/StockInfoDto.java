package com.quo.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/** 

* @author zhoumin

*/
@Data
@NoArgsConstructor
public class StockInfoDto {
	
	private Integer hid;			//操作编号
	
	private String pname;			//产品名称
	
	private String tname;			//类型名称
	
	private String psname;			//系列名称
	
	private Integer quantity;		//出入库数量
	
	private String aname;			//出入库类型
	
	private Integer preStock;	    //操作前数量
	
	private Integer afStock;	    //操作后数量
	
	private String ename;	    	//操作员姓名
	
	private String hdate;	    	//操作日期
	
}
