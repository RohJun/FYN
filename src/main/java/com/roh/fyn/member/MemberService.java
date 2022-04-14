package com.roh.fyn.member;

import java.util.List;

// 메서드 시그니처 강제
public interface MemberService {
	public MemberVO getMember(MemberVO vo);
	public void insertMember(MemberVO vo);
	public void updateMember(MemberVO vo);
	public void deleteMember(MemberVO vo);
	public List<MemberVO> getMemberList(MemberVO vo);
	public void purchaseMember(MemberVO vo);
}
