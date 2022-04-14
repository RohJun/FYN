package com.roh.fyn.member;

public class MemberVO {
	private String memId;		// 회원 아이디(고유값)
	private String memPassword;	// 회원 비밀번호
	private String memName;		// 회원 이름
	private String memEmail;	// 회원 이메일
	private String memPhone;	// 회원 전화번호
	private int memMoney;		// 보유 포인트
	private int memRank;		// 회원 등급
	private String searchText;	// 회원 검색
	private int purchasePrice;	//구매가

	
	//getter setter
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public int getMemMoney() {
		return memMoney;
	}
	public void setMemMoney(int memMoney) {
		this.memMoney = memMoney;
	}
	public int getMemRank() {
		return memRank;
	}
	public void setMemRank(int memRank) {
		this.memRank = memRank;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPassword=" + memPassword + ", memName=" + memName + ", memEmail="
				+ memEmail + ", memPhone=" + memPhone + ", memMoney=" + memMoney + ", memRank=" + memRank
				+ ", searchText=" + searchText + "]";
	}
	

}
