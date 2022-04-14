package com.roh.fyn.cart;

import java.util.List;

public interface CartService {
	//메서드 강제
	public void insertCart(CartVO vo);
	public void deleteCart(CartVO vo);
	public List<CartVO> getCartList(CartVO vo);
}
