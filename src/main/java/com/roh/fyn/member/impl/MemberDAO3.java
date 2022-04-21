package com.roh.fyn.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roh.fyn.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO3 {

	@Autowired
	private SqlSessionTemplate mybatis;

	// 회원 조회(로그인 + 상세보기)
	public MemberVO getMember(MemberVO vo) {
		System.out.println("로그 : MDAO3 - getMember()호출");
		return mybatis.selectOne("MemberDAO.getMember", vo);
	}

	// 회원가입
	public void insertMember(MemberVO vo) {
		System.out.println("로그 : MDAO3 - insertMember()호출");
		mybatis.insert("MemberDAO.insertMember", vo);
	}

	// 회원정보수정
	public void updateMember(MemberVO vo) {
		System.out.println("로그 : MDAO3 - updateMember()호출");
		mybatis.update("MemberDAO.updateMember", vo);
	}

	// 회원정보수정-구매
	public void purchaseMember(MemberVO vo) {
		System.out.println("로그 : MDAO2 - purchaseMember()호출");
		mybatis.update("MemberDAO.purchaseMember", vo);
	}

	// 회원탈퇴
	public void deleteMember(MemberVO vo) {
		System.out.println("로그 : MDAO2 - deleteMember()호출");
		mybatis.delete("MemberDAO.deleteMember", vo);
	}

	// 회원리스트조회
	public List<MemberVO> getMemberList(MemberVO vo) {
		System.out.println("로그 : MDAO2 - getMemberList()호출");
		return mybatis.selectList("MemberDAO.getMemberList", vo);
	}
}

