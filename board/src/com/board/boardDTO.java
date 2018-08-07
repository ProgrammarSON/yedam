package com.board;

import java.sql.Timestamp;

public class boardDTO {
	private String bnum;
	private String subject;
	private String writer;
	private Timestamp bdate;
	private String hits;
	private String content;
	private int pagecnt;
	
	public int getPagecnt() {
		return pagecnt;
	}
	public void setPagecnt(int pagecnt) {
		this.pagecnt = pagecnt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getBdate() {
		return bdate;
	}
	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}
	public String getHits() {
		return hits;
	}
	public void setHits(String hits) {
		this.hits = hits;
	}
	
	
		
}
