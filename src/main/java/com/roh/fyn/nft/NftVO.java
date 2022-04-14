package com.roh.fyn.nft;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class NftVO {
	private int nftId;			//nft 번호(고유값)
	private String nftTitle;	//nft 제목
	private Date nftDate;		//nft 등록 날짜
	private String nftRegDate;	//nft 등록 날짜 (형변환)
	private int nftPrice;		//nft 가격
	private String nftPic;		//nft 사진(경로)
	private int nftStatus;		//nft 판매상태
	private String searchText;	//검색
	private MultipartFile uploadFile;
	
	//get set
	public int getNftId() {
		return nftId;
	}
	public void setNftId(int nftId) {
		this.nftId = nftId;
	}
	public String getNftTitle() {
		return nftTitle;
	}
	public void setNftTitle(String nftTitle) {
		this.nftTitle = nftTitle;
	}
	public Date getNftDate() {
		return nftDate;
	}
	public void setNftDate(Date nftDate) {
		this.nftDate = nftDate;
	}
	public String getNftRegDate() {
		return nftRegDate;
	}
	public void setNftRegDate(String nftRegDate) {
		this.nftRegDate = nftRegDate;
	}
	public int getNftPrice() {
		return nftPrice;
	}
	public void setNftPrice(int nftPrice) {
		this.nftPrice = nftPrice;
	}
	public String getNftPic() {
		return nftPic;
	}
	public void setNftPic(String nftPic) {
		this.nftPic = nftPic;
	}
	public int getNftStatus() {
		return nftStatus;
	}
	public void setNftStatus(int nftStatus) {
		this.nftStatus = nftStatus;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	@Override
	public String toString() {
		return "NftVO [nftId=" + nftId + ", nftTitle=" + nftTitle + ", nftDate=" + nftDate + ", nftRegDate="
				+ nftRegDate + ", nftPrice=" + nftPrice + ", nftPic=" + nftPic + ", nftStatus=" + nftStatus
				+ ", searchText=" + searchText + ", uploadFile=" + uploadFile + "]";
	}
}
