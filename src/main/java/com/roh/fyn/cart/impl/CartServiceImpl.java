package com.roh.fyn.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roh.fyn.cart.CartService;
import com.roh.fyn.cart.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService{

	@Autowired	//DI
	private CartDAO4 cartDAO;
	
	@Override
	public void insertCart(CartVO vo) {
		// TODO Auto-generated method stub
		cartDAO.insertCart(vo);
	}

	@Override
	public void deleteCart(CartVO vo) {
		// TODO Auto-generated method stub
		cartDAO.deleteCart(vo);
	}

	@Override
	public List<CartVO> getCartList(CartVO vo) {
		// TODO Auto-generated method stub
		return cartDAO.getCartList(vo);
	}

}
