package com.roh.fyn.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.roh.fyn.member.MemberVO;

//@Repository("memberDAO")
public class MemberDAO2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 회원가입
	private final String MEMBER_INSERT = "insert into member (memId,memPassword,memName,memEmail,memPhone) values(?,?,?,?,?)";
	// 회원조회
	private final String MEMBER_SELECTONE = "select * from member where memId=?";
	// 회원수정
	private final String MEMBER_UPDATE = "update member set memPassword=?, memName=?, memEmail=?, memPhone=?, memMoney=? where memId=?";
	// 회원구매
	private final String MEMBER_UPDATE_PURCHASE = "update member set memMoney=memMoney-? where memId=?";
	// 회원탈퇴
	private final String MEMBER_DELETE = "delete member where memId=?";
	// 회원리스트 조회
	private final String MEMBER_SELECTALL = "select * from member";
	// 회원리스트 조회_회원이름
	private final String MEMBER_SELECTALL_MEMNAME = "select * from member where lower(memName) like '%'|| lower(?) ||'%' order by memName DESC";

	// 회원 조회(로그인 + 상세보기)
	public MemberVO getMember(MemberVO vo) {
		System.out.println("로그 : MDAO2 - getMember()호출");
		if (vo.getMemPassword() != null) {
			return jdbcTemplate.queryForObject(MEMBER_SELECTONE, new MemberRowMapper());
		} else {
			Object[] args = { vo.getMemId() };
			return jdbcTemplate.queryForObject(MEMBER_SELECTONE, args, new MemberRowMapper());
		}
	}

	// 회원가입
	public void insertMember(MemberVO vo) {
		System.out.println("로그 : MDAO2 - insertMember()호출");
		jdbcTemplate.update(MEMBER_INSERT, vo.getMemId(), vo.getMemPassword(), vo.getMemName(), vo.getMemEmail(),
				vo.getMemPhone());
	}

	// 회원정보수정
	public void updateMember(MemberVO vo) {
		System.out.println("로그 : MDAO2 - updateMember()호출");
		jdbcTemplate.update(MEMBER_UPDATE, vo.getMemPassword(), vo.getMemName(), vo.getMemEmail(), vo.getMemPhone(),
				vo.getMemMoney(), vo.getMemId());
	}

	// 회원정보수정-구매
	public void purchaseMember(MemberVO vo) {
		System.out.println("로그 : MDAO2 - purchaseMember()호출");
		jdbcTemplate.update(MEMBER_UPDATE_PURCHASE, vo.getPurchasePrice(), vo.getMemId());
	}

	// 회원탈퇴
	public void deleteMember(MemberVO vo) {
		System.out.println("로그 : MDAO2 - deleteMember()호출");
		jdbcTemplate.update(MEMBER_DELETE, vo.getMemId());
	}

	// 회원리스트조회
	public List<MemberVO> getMemberList(MemberVO vo) {
		System.out.println("로그 : MDAO2 - getMemberList()호출");
		// 전체리스트조회
		if (vo.getSearchText() == null) {
			return jdbcTemplate.query(MEMBER_SELECTALL, new MemberRowMapper());

		}
		// 검색리스트조회
		else {
			Object[] args = { vo.getSearchText() };
			return jdbcTemplate.query(MEMBER_SELECTALL_MEMNAME, args, new MemberRowMapper());
		}
	}
}

class MemberRowMapper implements RowMapper<MemberVO> {

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setMemId(rs.getString("memId"));
		data.setMemPassword(rs.getString("memPassword"));
		data.setMemName(rs.getString("memName"));
		data.setMemEmail(rs.getString("memEmail"));
		data.setMemPhone(rs.getString("memPhone"));
		data.setMemMoney(rs.getInt("memMoney"));
		data.setMemRank(rs.getInt("memRank"));
		return data;
	}
	
}
