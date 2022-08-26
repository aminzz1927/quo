package com.quo.entity;

public class ProductType {

int tid;
String tname;
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
@Override
public String toString() {
	return "ProductType [tid=" + tid + ", tname=" + tname + "]";
}
public ProductType(int tid, String tname) {
	super();
	this.tid = tid;
	this.tname = tname;
}
public ProductType() {
	super();
	// TODO Auto-generated constructor stub
}
}