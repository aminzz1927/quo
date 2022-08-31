package com.quo.entity;

public class Emp {
	private int eno;
	private String ename;
	private String pwd;
	public Emp(int eno, String ename, String pwd, int dno, int rid, String tel, String email) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.pwd = pwd;
		this.dno = dno;
		this.rid = rid;
		this.tel = tel;
		this.email = email;
	}



	private int dno;
	private int rid;
	
	
	@Override
	public String toString() {
		return "Emp [eno=" + eno + ", ename=" + ename + ", pwd=" + pwd + ", dno=" + dno + ", rid=" + rid + ", tel="
				+ tel + ", email=" + email + "]";
	}



	private String tel;
	private String email;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}

	
	
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
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

	

	public Emp() {
		super();
	}
	

	
	
	
	

}
