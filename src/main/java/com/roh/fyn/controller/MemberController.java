package com.roh.fyn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roh.fyn.member.MemberVO;
import com.roh.fyn.member.impl.MemberDAO1;
import com.roh.fyn.nft.NftVO;
import com.roh.fyn.nft.impl.NftDAO1;

@Controller
public class MemberController {

	// 회원 로그인
	@RequestMapping("/signIn.do")
	public String signIn(MemberVO vo, MemberDAO1 memberDAO, HttpSession session) {
		vo = memberDAO.getMember(vo);
		if (vo == null) {
			return "redirect:signIn.jsp";
		} else if (vo.getMemRank() == 1) {
			session.setAttribute("member", vo);
			return "redirect:adminMain.do";
		}
		session.setAttribute("member", vo);
		return "redirect:main.do";
	}

	// 회원 로그아웃
	@RequestMapping("/signOut.do")
	public String signOut(HttpSession session) {
		session.invalidate();
		return "redirect:main.do";
	}

	// 회원가입
	@RequestMapping("/signUp.do")
	public String insertMember(MemberVO vo, MemberDAO1 memberDAO, Model model) {
		System.out.println(vo.getMemId());
		memberDAO.insertMember(vo);
		return "redirect:signIn.jsp";
	}

	// 회원 정보 수정
	@RequestMapping("/updateMember.do")
	public String updateMember(MemberVO vo, MemberDAO1 memberDAO, HttpSession session) {
		System.out.println("로그: MC - updateMember 요청");
		memberDAO.updateMember(vo);
		session.setAttribute("member", vo);
		return "myPage.jsp";
	}

	// 회원탈퇴
	@RequestMapping("/deleteMember.do")
	public String deleteMember(MemberVO vo, MemberDAO1 memberDAO, HttpSession session) {
		memberDAO.deleteMember(vo);
		session.invalidate();
		return "main.do";
	}

	// 회원 마이페이지 상세보기
	@RequestMapping("/getMember.do")
	public String getMember(MemberVO vo, MemberDAO1 memberDAO, Model model) {
		System.out.println("로그: MC - mypage요청");
		memberDAO.getMember(vo);
		return "redirect:myPage.jsp";
	}

	// 회원 구매
	@RequestMapping("/purchaseMember.do")
	public String purchaseMember(MemberVO vo, MemberDAO1 memberDAO, Model model, NftVO nftvo, HttpSession session,
			NftDAO1 nftdao) {
		System.out.println("로그: MemController - purchaseMember요청" + vo.getMemId() + vo.getPurchasePrice());
		System.out.println("로그: MC - purchaseMember요청 " + nftvo.getNftId());
		nftdao.updateNftPurchase(nftvo);
		memberDAO.purchaseMember(vo);
		vo = memberDAO.getMember(vo);
		session.setAttribute("member", vo);

		return "main.do";
	}

	// about 페이지 다국어 처리
	@RequestMapping("/aboutpage.do")
	public String about_get(MemberVO vo) {
		System.out.println("로그 : mC - about.do 요청");
		return "about.jsp";
	}
}
