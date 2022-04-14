package com.roh.fyn.notice;

import java.util.Date;

public class NoticeVO {
	private int notId;			// 공지사항 번호(고유값)
	private String notTitle;	// 공지사항 제목
	private String notContent;	// 공지사항 내용
	private Date notDate;		// 공지사항 등록날짜
	private String notRegDate;	// 공지사항 등록날짜 형변환
	
	//getter setter
	public int getNotId() {
		return notId;
	}
	public void setNotId(int notId) {
		this.notId = notId;
	}
	public String getNotTitle() {
		return notTitle;
	}
	public void setNotTitle(String notTitle) {
		this.notTitle = notTitle;
	}
	public String getNotContent() {
		return notContent;
	}
	public void setNotContent(String notContent) {
		this.notContent = notContent;
	}
	public Date getNotDate() {
		return notDate;
	}
	public void setNotDate(Date notDate) {
		this.notDate = notDate;
	}
	public String getNotRegDate() {
		return notRegDate;
	}
	public void setNotRegDate(String notRegDate) {
		this.notRegDate = notRegDate;
	}
	@Override
	public String toString() {
		return "NoticeVO [notId=" + notId + ", notTitle=" + notTitle + ", notContent=" + notContent + ", notDate="
				+ notDate + ", notRegDate=" + notRegDate + "]";
	}
	
	
}
