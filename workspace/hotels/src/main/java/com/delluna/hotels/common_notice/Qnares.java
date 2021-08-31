package com.delluna.hotels.common_notice;

import java.sql.Date;

import com.delluna.hotels.common_member.Member;

public class Qnares {
	private int no;
	private String response;
	private Date wdate;
	private Qna qno;
	private String state;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getResponse() {
		return response;
	}
	public void setReponse(String response) {
		this.response = response;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public Qna getQno() {
		return qno;
	}
	public void setQno(Qna qno) {
		this.qno = qno;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
