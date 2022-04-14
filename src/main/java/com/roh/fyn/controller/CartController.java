package com.roh.fyn.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roh.fyn.cart.CartVO;
import com.roh.fyn.cart.impl.CartDAO1;

@Controller
public class CartController {
	
	//장바구니 페이지 이동
	@RequestMapping(value="/myCart.do")
	public String getBoardList(CartVO vo,CartDAO1 cartDAO,Model model, HttpSession session) {
		System.out.println("로그 cartC - 장바구니요청"+session.getAttribute("memId"));
		System.out.println("mycart.do "+vo);
		List<CartVO> datas=cartDAO.getCartList(vo);
		model.addAttribute("cartDatas",datas); // Model을 이용하여 전달할 정보를 저장!
		return "myCart.jsp";
	}
	
	//장바구니 등록
	@RequestMapping(value="/addCart.do")
	public String insertCart(CartVO vo,CartDAO1 cartDAO) {
		System.out.println(vo.getMemId());
		System.out.println(vo.getNftTitle());
		cartDAO.insertCart(vo);
		return "redirect:main.do";
	}
	
	//장바구니 삭제
	@RequestMapping(value="/deleteCart.do")
	public String deleteCart(CartVO vo,CartDAO1 cartDAO) {
		cartDAO.deleteCart(vo);
		return "redirect:cart.do";
	}
	
}
