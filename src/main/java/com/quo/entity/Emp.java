package com.quo.entity;

public class Emp {
	private String eno;
	private String ename;
	private String pwd;
	private int dno;
	private int rid;
	private String post;
	
	private String tel;
	private String email;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}

	
	public Emp(String eno, String ename, String pwd, int dno, int rid, String post, String tel, String email) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.pwd = pwd;
		this.dno = dno;
		this.rid = rid;
		this.post = post;
		this.tel = tel;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Emp [eno=" + eno + ", ename=" + ename + ", pwd=" + pwd + ", dno=" + dno + ", rid=" + rid + ", post="
				+ post + ", tel=" + tel + ", email=" + email + "]";
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
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
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

	
	
	
	
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public Emp() {
		super();
	}
	

	
	
	
	

}
