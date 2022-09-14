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
//@ExcelAttribute(sort=0)
	private String pname;                   //产品名称
	//@ExcelAttribute(sort=1)
		private int psid;                   //产品名称
//@ExcelAttribute(sort=3)
	private Double price;					//价格
//@ExcelAttribute(sort=5)
	private String connection;				//耳机连接方式
//@ExcelAttribute(sort=6)
	private String pInterface;				//耳机接口
//@ExcelAttribute(sort=7)
	private String noise;					//降噪
//@ExcelAttribute(sort=8)
	private String bass;					//重低音
//@ExcelAttribute(sort=9)
	private String waterproof;				//防水功能
//@ExcelAttribute(sort=10)
    private String mic;						//麦克风
//@ExcelAttribute(sort=11)
    private String packageInfo;				//包装清单

public ProductReport(Object [] values) {
   
    this.pname = values[0].toString();
    this.psid=((Double) values[1]).intValue();
    this.price = (Double) (values[2]);
 
    this.connection=values[3].toString();
    this.pInterface=values[4].toString();
    this.noise=values[5].toString();
    this.bass=values[6].toString();
    this.waterproof=values[7].toString();
    this.mic=values[8].toString();
    this.packageInfo=values[9].toString();
    

}
   
}
