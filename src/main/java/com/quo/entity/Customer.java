package com.quo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Customer {
private int    cid;
private String cname;
private String ctype;
private String address;
private String email;
private String zip;
private String tel;
private String fax;
private String contact;
private String ename;
private String csource;
private Date   ftime;
}
