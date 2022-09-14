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
	private String pname;
//产品名称
@ExcelAttribute(sort=1)
	private String tname;
//产品类型名称
@ExcelAttribute(sort=2)
	private String psname;					//产品系列名称
@ExcelAttribute(sort=3)
	private Double price;					//价格
@ExcelAttribute(sort=4)
	private int stock;						//库存
@ExcelAttribute(sort=5)
	private String connection;				//耳机连接方式
@ExcelAttribute(sort=6)
	private String pInterface;				//耳机接口
@ExcelAttribute(sort=7)
	private String noise;					//降噪
@ExcelAttribute(sort=8)
	private String bass;					//重低音
@ExcelAttribute(sort=9)
	private String waterproof;				//防水功能
@ExcelAttribute(sort=10)
    private String mic;						//麦克风
@ExcelAttribute(sort=11)
    private String packageInfo;				//包装清单

public ProductReport(Object [] values) {
   
    this.pname = values[1].toString();
    
    this.tname = values[2].toString();
    
    this.psname = values[3].toString();
    this.price = (Double) (values[4]);
    this.stock=((Double) values[5]).intValue();
    this.connection=values[6].toString();
    this.pInterface=values[7].toString();
    this.noise=values[8].toString();
    this.bass=values[9].toString();
    this.waterproof=values[10].toString();
    this.mic=values[11].toString();
    this.packageInfo=values[12].toString();
    

}
   
}
