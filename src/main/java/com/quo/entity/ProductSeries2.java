package com.quo.entity;

public class ProductSeries2 {
  private  int psid;
  private  String psname;
  private   String tid;
  private String notes;
 

public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}


public String getPsname() {
	return psname;
}



public void setPsname(String psname) {
	this.psname = psname;
}




public ProductSeries2() {
	super();
	// TODO Auto-generated constructor stub
}


public int getPsid() {
	return psid;
}
public void setPsid(int psid) {
	this.psid = psid;
}
public String getTid() {
	return tid;
}
public void setTid(String tid) {
	this.tid = tid;
}
@Override
public String toString() {
	return "ProductSeries2 [psid=" + psid + ", psname=" + psname + ", tid=" + tid + ", notes=" + notes + "]";
}
public ProductSeries2(int psid, String psname, String tid, String notes) {
	super();
	this.psid = psid;
	this.psname = psname;
	this.tid = tid;
	this.notes = notes;
}






}
