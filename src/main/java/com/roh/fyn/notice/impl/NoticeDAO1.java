package com.roh.fyn.notice.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.roh.fyn.common.JDBCUtil;
import com.roh.fyn.notice.NoticeVO;

//@Repository("noticeDAO")
public class NoticeDAO1 {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 공지사항 등록
	private final String NOTICE_INSERT = "insert into notice (notId,notTitle,notContent) values((select nvl(max(notId),4000)+1 from notice),?,?)";
	// 공지사항 리스트 조회
	private final String NOTICE_SELECTALL = "select * from notice";

	// 공지사항 등록
	public void insertNotice(NoticeVO vo) {
		System.out.println("로그 : NOTDAO - insertNotice()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(NOTICE_INSERT);
			pstmt.setString(1, vo.getNotTitle());
			pstmt.setString(2, vo.getNotContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// 공지사항 리스트 조회
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		System.out.println("로그 : NFTDAO - getNftList()호출");
		List<NoticeVO> datas = new ArrayList<NoticeVO>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(NOTICE_SELECTALL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// nftDate(데이트) -> nftRegDate(스트링)
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				NoticeVO data = new NoticeVO();
				data.setNotId(rs.getInt("notId"));
				data.setNotTitle(rs.getString("notTitle"));
				data.setNotContent(rs.getString("notContent"));
				data.setNotRegDate(sdf.format(rs.getDate("notDate")));
			
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}

}
