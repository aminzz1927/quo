package com.quo.entity;


public class Authority {
		
	private Long rmid;
	
	private Long rid;
	
	private Long mid;

	public Long getRmid() {
		return rmid;
	}

	public void setRmid(Long rmid) {
		this.rmid = rmid;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Authority [rmid=" + rmid + ", rid=" + rid + ", mid=" + mid + "]";
	}



}
