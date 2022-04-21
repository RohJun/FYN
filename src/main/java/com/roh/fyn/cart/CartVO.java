package com.roh.fyn.cart;

// 모델 버전 4를 확인하기위함 (해당클래스에 있는 주석)
//@Entity 
//@Table(name="CART")
public class CartVO {
	
	/*
	 * private static final long serialVersionUID = 1L;
	public CartVO() {
		super();
	}
	 */
	
	//@Id
	private int cartId;			// 장바구니 번호(고유값)
	private String memId;		// 장바구니 회원 아이디(참조값)
	private String memName;		// 장바구니 회원명
	private int nftId;			// nft 번호(참조값)
	private String nftTitle;	// nft 제목
	private int nftPrice;	// nft 가격
	
	//getter setter
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	public String getNftTitle() {
		return nftTitle;
	}
	public void setNftTitle(String nftTitle) {
		this.nftTitle = nftTitle;
	}
	public int getNftPrice() {
		return nftPrice;
	}
	public void setNftPrice(int nftPrice) {
		this.nftPrice = nftPrice;
	}
	
	//toString
	@Override
	public String toString() {
		return "CartVO [cartId=" + cartId + ", memId=" + memId + ", memName=" + memName + ", nftId=" + nftId
				+ ", nftTitle=" + nftTitle + ", nftPrice=" + nftPrice + "]";
	}
	
	
}
