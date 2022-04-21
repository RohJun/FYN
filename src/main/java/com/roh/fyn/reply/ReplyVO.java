package com.roh.fyn.reply;

import java.util.Date;

public class ReplyVO {
	private int repId;			// 댓글 번호(고유값)
	private String memId;		// 댓글 회원 아이디(참조값)
	private String memName;		// 댓글 회원 이름
	private int nftId;			// 댓글 nft 번호(참조값)
	private String repTitle;	// 댓글 제목
	private String repContent;	// 댓글 내용
	private Date repDate;		// 댓글 등록날짜
	private String repRegDate;	// 댓글 등록날짜 형변환
	private String searchText;	//검색
	
	//get set
	public int getRepId() {
		return repId;
	}
	public void setRepId(int repId) {
		this.repId = repId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getNftId() {
		return nftId;
	}
	public void setNftId(int nftId) {
		this.nftId = nftId;
	}
	public String getRepTitle() {
		return repTitle;
	}
	public void setRepTitle(String repTitle) {
		this.repTitle = repTitle;
	}
	public String getRepContent() {
		return repContent;
	}
	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
	public String getRepRegDate() {
		return repRegDate;
	}
	public void setRepRegDate(String repRegDate) {
		this.repRegDate = repRegDate;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	@Override
	public String toString() {
		return "ReplyVO [repId=" + repId + ", memId=" + memId + ", memName=" + memName + ", nftId=" + nftId
				+ ", repTitle=" + repTitle + ", repContent=" + repContent + ", repDate=" + repDate + ", repRegDate="
				+ repRegDate + ", searchText=" + searchText + "]";
	}
}
