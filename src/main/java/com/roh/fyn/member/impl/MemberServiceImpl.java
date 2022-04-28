package com.roh.fyn.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roh.fyn.member.MemberService;
import com.roh.fyn.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired // 메모리에 해당타입이 존재하는지 확인
	private MemberDAO3 memberDAO;
	
	@Override
	public MemberVO getMember(MemberVO vo) {
		// before(인증,허가,...)
		return memberDAO.getMember(vo);
	}

	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.getMemberList(vo);
	}

	@Override
	public void purchaseMember(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

}
