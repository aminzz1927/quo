package com.quo.entity;

public class EmpDto2 {
	private int eno;
	private String ename;
	private String dname;
	private String rname;
	private String tel;
	private String email;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public EmpDto2(int eno, String ename, String dname, String rname, String tel, String email) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.dname = dname;
		this.rname = rname;
		this.tel = tel;
		this.email = email;
	}
	@Override
	public String toString() {
		return "EmpDto2 [eno=" + eno + ", ename=" + ename + ", dname=" + dname + ", rname=" + rname + ", tel=" + tel
				+ ", email=" + email + "]";
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public EmpDto2() {
		super();
		// TODO Auto-generated constructor stub
	}
}
