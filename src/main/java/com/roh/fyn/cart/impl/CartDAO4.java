package com.roh.fyn.cart.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.roh.fyn.cart.CartVO;

@Repository("cartDAO")
public class CartDAO4 {

	@PersistenceContext
	private EntityManager em;

	// 장바구니 등록
	public void insertCart(CartVO vo) {
		System.out.println("로그 : CartDAO4 : insertCart 호출");
		em.persist(vo);
	}

	// 장바구니 삭제
	public void deleteCart(CartVO vo) {
		System.out.println("로그 : CARTDAO4 - deleteCart()호출");
		em.remove(em.find(CartVO.class, vo.getCartId()));
	}

	// 장바구니 리스트조회
	public List<CartVO> getCartList(CartVO vo) {
		System.out.println("로그 : CARTDAO4 - getCartList()호출");
		return em.createQuery("from CartVO b order by b.cartId desc").getResultList();

	}
}
