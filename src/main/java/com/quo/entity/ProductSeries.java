package com.quo.entity;
/**
 * 
 * @author 韩宛廷
 *
 */

public class ProductSeries {
  private  int psid;
  private  String psname;
  private   String tname;
  private String notes;
 

public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}

public String getPsname() {
	return psname;
}



public void setPsname(String psname) {
	this.psname = psname;
}




public ProductSeries() {
	super();
	// TODO Auto-generated constructor stub
}


public int getPsid() {
	return psid;
}
public void setPsid(int psid) {
	this.psid = psid;
}
@Override
public String toString() {
	return "ProductSeries [psid=" + psid + ", psname=" + psname + ", tname=" + tname + ", notes=" + notes + "]";
}
public ProductSeries(int psid, String psname, String tname, String notes) {
	super();
	this.psid = psid;
	this.psname = psname;
	this.tname = tname;
	this.notes = notes;
}








}
