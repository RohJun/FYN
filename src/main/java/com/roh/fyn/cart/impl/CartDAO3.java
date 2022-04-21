package com.roh.fyn.cart.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roh.fyn.cart.CartVO;

@Repository("cartDAO")
public class CartDAO3 {

	@Autowired
	private SqlSessionTemplate mybatis;

	// 장바구니 등록
	public void insertCart(CartVO vo) {
		System.out.println("로그 : CartDAO3 : insertCart 호출");
		mybatis.insert("CartDAO.insertCart", vo);
	}

	// 장바구니 삭제
	public void deleteCart(CartVO vo) {
		System.out.println("로그 : CARTDAO3 - deleteCart()호출");
		mybatis.delete("CartDAO.deleteCart", vo);
	}

	// 장바구니 리스트조회
	public List<CartVO> getCartList(CartVO vo) {
		System.out.println("로그 : CARTDAO3 - getCartList()호출");
		return mybatis.selectList("CartDAO.getCartList", vo);
	}
}
