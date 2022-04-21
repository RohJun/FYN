package com.roh.fyn.cart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client { // 클라이언트,사용자,브라우저
	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("day79_0421_02");
		EntityManager em=emf.createEntityManager();
		CartVO vo=new CartVO();
		vo.setCartId(11111); // 시퀀스 미생성
		vo.setMemId("회원아이디");
		vo.setMemName("이름");
		vo.setNftId(2222);
		vo.setNftTitle("제목");
		vo.setNftPrice(5000);
		em.persist(vo); // INSERT
		System.out.println("로그: "+em.find(CartVO.class, vo.getCartId())); // SELECT_ONE
		em.close();
		emf.close();

	}
}
