package com.quo.entity;

public class Role {
	
	private Long rid;
	
	private Long dno;
	
	private String rname;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getDno() {
		return dno;
	}

	public void setDno(Long dno) {
		this.dno = dno;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	@Override
	public String toString() {
		return "Role [rid=" + rid + ", dno=" + dno + ", rname=" + rname + "]";
	}


	

}
