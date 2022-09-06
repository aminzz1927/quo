package com.quo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Customer {
private int    cid;//顾客编号
private String cname;//会社名称
private String ctype;//顾客类型
private String address;//地址
private String email;//电子邮箱
private String zip;//邮编
private String tel;//电话
private String fax;//传真
private String contact;//联系人
private String ename;//作成者
private String csource;//来源
private String  ftime;//跟进时间
}
