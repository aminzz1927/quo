package com.quo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import com.quo.utils.ExcelAttribute;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductReport {
@ExcelAttribute(sort=0)
private Long pid;						//产品编号
@ExcelAttribute(sort=1)
	private String pname;					//产品名称
@ExcelAttribute(sort=2)
	private String tname;					//产品类型名称
@ExcelAttribute(sort=3)
	private String psname;					//产品系列名称
@ExcelAttribute(sort=4)
	private Double price;					//价格
@ExcelAttribute(sort=5)
	private int stock;						//库存
@ExcelAttribute(sort=6)
	private String connection;				//耳机连接方式
@ExcelAttribute(sort=7)
	private String pInterface;				//耳机接口
@ExcelAttribute(sort=8)
	private String noise;					//降噪
@ExcelAttribute(sort=9)
	private String bass;					//重低音
@ExcelAttribute(sort=10)
	private String waterproof;				//防水功能
@ExcelAttribute(sort=11)
    private String mic;						//麦克风
@ExcelAttribute(sort=12)
    private String packageInfo;				//包装清单

   
   
}
