package com.quo.entity;

public class Role {
	private int rid;
	private int dno;
	private String rname;
	public Role(int rid, int dno, String rname) {
		super();
		this.rid = rid;
		this.dno = dno;
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", dno=" + dno + ", rname=" + rname + "]";
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
