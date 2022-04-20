package com.roh.fyn.notice.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.roh.fyn.notice.NoticeVO;

@Repository("noticeDAO")
public class NoticeDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 공지사항 등록
	private final String NOTICE_INSERT = "insert into notice (notId,notTitle,notContent) values((select nvl(max(notId),4000)+1 from notice),?,?)";
	// 공지사항 리스트 조회
	private final String NOTICE_SELECTALL = "select * from notice";

	// 공지사항 등록
	public void insertNotice(NoticeVO vo) {
		System.out.println("로그 : NOTDAO2 - insertNotice()호출");
		jdbcTemplate.update(NOTICE_INSERT, vo.getNotTitle(), vo.getNotContent());
	}

	// 공지사항 리스트 조회
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		System.out.println("로그 : NFTDAO2 - getNftList()호출");
		return jdbcTemplate.query(NOTICE_SELECTALL, new NoticeRowMapper());
	}
}

class NoticeRowMapper implements RowMapper<NoticeVO> {

	@Override
	public NoticeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoticeVO data = new NoticeVO();
		// nftDate(데이트) -> nftRegDate(스트링)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		data.setNotId(rs.getInt("notId"));
		data.setNotTitle(rs.getString("notTitle"));
		data.setNotContent(rs.getString("notContent"));
		data.setNotRegDate(sdf.format(rs.getDate("notDate")));
		return data;
	}

}
