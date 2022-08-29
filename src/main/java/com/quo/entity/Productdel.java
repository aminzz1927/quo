package com.quo.entity;

public class Productdel {
private int psid;

private boolean delEnable;

public int getPsid() {
	return psid;
}

public void setPsid(int psid) {
	this.psid = psid;
}

public boolean isDelEnable() {
	return delEnable;
}

public void setDelEnable(boolean delEnable) {
	this.delEnable = delEnable;
}

@Override
public String toString() {
	return "productdel [psid=" + psid + ", delEnable=" + delEnable + "]";
}

public Productdel(int psid, boolean delEnable) {
	super();
	this.psid = psid;
	this.delEnable = delEnable;
}

public Productdel() {
	super();
	// TODO Auto-generated constructor stub
} 

}
