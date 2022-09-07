package com.quo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author 韩宛廷
 *
 */
@Data
public class ProductExport {
	
	private Long pid;						//产品编号
	
	private String pname;					//产品名称
	
	private String tname;					//产品类型名称

	private String psname;					//产品系列名称
	
	private Double price;					//价格
	
	private int stock;						//库存
	
	private String connection;				//耳机连接方式
	
	private String pInterface;				//耳机接口
	
	private String noise;					//降噪
	
	private String bass;					//重低音
	
	private String waterproof;				//防水功能

    private String mic;						//麦克风
    
    private String packageInfo;				//包装清单


	

}
