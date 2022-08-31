package com.quo.entity;

public class EmpDto {
	private int eno;
	private String ename;
	private int dno;
	private int rid;
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
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
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
	@Override
	public String toString() {
		return "EmpDto [eno=" + eno + ", ename=" + ename + ", dno=" + dno + ", rid=" + rid + ", tel=" + tel + ", email="
				+ email + "]";
	}
	public EmpDto(int eno, String ename, int dno, int rid, String tel, String email) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.dno = dno;
		this.rid = rid;
		this.tel = tel;
		this.email = email;
	}
	public EmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
