package com.roh.fyn.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.roh.fyn.common.JDBCUtil;
import com.roh.fyn.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO1 {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

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
		System.out.println("로그 : MDAO - getMember()호출");
		MemberVO data = null;
		conn = JDBCUtil.connect();
		try {
			if (vo.getMemPassword() != null) {
				pstmt = conn.prepareStatement(MEMBER_SELECTONE);
				pstmt.setString(1, vo.getMemId());
				ResultSet rs = pstmt.executeQuery();

				// 로그인
				if (rs.next()) {
					if (rs.getString("memPassword").equals(vo.getMemPassword())) {
						data = new MemberVO();
						data.setMemId(rs.getString("memId"));
						data.setMemPassword(rs.getString("memPassword"));
						data.setMemName(rs.getString("memName"));
						data.setMemEmail(rs.getString("memEmail"));
						data.setMemPhone(rs.getString("memPhone"));
						data.setMemMoney(rs.getInt("memMoney"));
						data.setMemRank(rs.getInt("memRank"));
					}
				}
			}
			// 상세보기
			else {
				pstmt = conn.prepareStatement(MEMBER_SELECTONE);
				pstmt.setString(1, vo.getMemId());
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					data = new MemberVO();
					data.setMemId(rs.getString("memId"));
					data.setMemPassword(rs.getString("memPassword"));
					data.setMemName(rs.getString("memName"));
					data.setMemEmail(rs.getString("memEmail"));
					data.setMemPhone(rs.getString("memPhone"));
					data.setMemMoney(rs.getInt("memMoney"));
					data.setMemRank(rs.getInt("memRank"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

	// 회원가입
	public void insertMember(MemberVO vo) {
		System.out.println("로그 : MDAO - insertMember()호출");
		System.out.println("DAO : " + vo.getMemId());
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(MEMBER_INSERT);
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getMemPassword());
			pstmt.setString(3, vo.getMemName());
			pstmt.setString(4, vo.getMemEmail());
			pstmt.setString(5, vo.getMemPhone());

			System.out.println("DAO : " + vo.getMemId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// 회원정보수정
	public void updateMember(MemberVO vo) {
		System.out.println("로그 : MDAO - updateMember()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(MEMBER_UPDATE);
			pstmt.setString(1, vo.getMemPassword());
			pstmt.setString(2, vo.getMemName());
			pstmt.setString(3, vo.getMemEmail());
			pstmt.setString(4, vo.getMemPhone());
			pstmt.setInt(5, vo.getMemMoney());
			pstmt.setString(6, vo.getMemId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// 회원정보수정-구매
	public void purchaseMember(MemberVO vo) {
		System.out.println("로그 : MDAO - purchaseMember()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(MEMBER_UPDATE_PURCHASE);
			pstmt.setInt(1, vo.getPurchasePrice());
			pstmt.setString(2, vo.getMemId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// 회원탈퇴
	public void deleteMember(MemberVO vo) {
		System.out.println("로그 : MDAO - deleteMember()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(MEMBER_DELETE);
			pstmt.setString(1, vo.getMemId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// 회원리스트조회
	public List<MemberVO> getMemberList(MemberVO vo) {
		System.out.println("로그 : MDAO - getMemberList()호출");
		List<MemberVO> datas = new ArrayList<MemberVO>();
		conn = JDBCUtil.connect();
		try {
			if (vo.getSearchText() == null) {
				pstmt = conn.prepareStatement(MEMBER_SELECTALL);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					MemberVO data = new MemberVO();
					data = new MemberVO();
					data.setMemId(rs.getString("memId"));
					data.setMemPassword(rs.getString("memPassword"));
					data.setMemName(rs.getString("memName"));
					data.setMemEmail(rs.getString("memEmail"));
					data.setMemPhone(rs.getString("memPhone"));
					data.setMemMoney(rs.getInt("memMoney"));
					data.setMemRank(rs.getInt("memRank"));
					datas.add(data);
				}
			} else {
				pstmt = conn.prepareStatement(MEMBER_SELECTALL_MEMNAME);
				pstmt.setString(1, vo.getSearchText());
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					MemberVO data = new MemberVO();
					data = new MemberVO();
					data.setMemId(rs.getString("memId"));
					data.setMemPassword(rs.getString("memPassword"));
					data.setMemName(rs.getString("memName"));
					data.setMemEmail(rs.getString("memEmail"));
					data.setMemPhone(rs.getString("memPhone"));
					data.setMemMoney(rs.getInt("memMoney"));
					data.setMemRank(rs.getInt("memRank"));
					datas.add(data);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}
}
