package com.roh.fyn.reply.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.roh.fyn.reply.ReplyVO;

//@Repository("replyDAO")
public class ReplyDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 댓글 추가
	private final String REPLY_INSERT = "insert into reply (repId,memId,memName,nftId,repTitle,repContent) values((select nvl(max(repId),3000)+1 from reply),?,?,?,?,?)";
	// 댓글 삭제
	private final String REPLY_DELETE = "delete reply where repId=?";
	// 댓글 리스트 nftId로 조회
	private final String REPLY_SELECTALL_NFTID = "select * from reply where nftId=?";
	// 댓글 리스트 조회 제목검색
	private final String REPLY_SELECTALL_MEMNAME = "select * from reply where lower(memName) like '%'|| lower(?) ||'%' order by memName DESC";

	// 댓글 등록
	// memId,memName,nftId,repTitle,repContent
	public void insertReply(ReplyVO vo) {
		System.out.println("로그 : REPLYDAO2 - insertReply()호출");
		jdbcTemplate.update(REPLY_INSERT, vo.getMemId(), vo.getMemName(), vo.getNftId(), vo.getRepTitle(),
				vo.getRepContent());
	}

	// 댓글 삭제
	public void deleteReply(ReplyVO vo) {
		System.out.println("로그 : REPLYDAO2 - deleteReply()호출");
		jdbcTemplate.update(REPLY_INSERT, vo.getRepId());
	}

	// 댓글 리스트 조회_nftId
	public List<ReplyVO> getReplyList(ReplyVO vo) {
		System.out.println("로그 : REPLYDAO2 - getReplyList()호출");
		// 해당 nft의 댓글 조회
		if (vo.getSearchText() == null) {
			Object[] args = { vo.getNftId() };
			return jdbcTemplate.query(REPLY_SELECTALL_NFTID, args, new ReplyRowMapper());
		}
		// 검색 조회
		else {
			Object[] args = { vo.getMemName() };
			return jdbcTemplate.query(REPLY_SELECTALL_MEMNAME, args, new ReplyRowMapper());
		}
	}
}

class ReplyRowMapper implements RowMapper<ReplyVO> {

	@Override
	public ReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReplyVO data = new ReplyVO();
		// repDate(데이트) -> repRegDate(스트링)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		data.setRepId(rs.getInt("repId"));
		data.setMemId(rs.getString("memId"));
		data.setMemName(rs.getString("memName"));
		data.setNftId(rs.getInt("nftId"));
		data.setRepTitle(rs.getString("repTitle"));
		data.setRepContent(rs.getString("repContent"));
		data.setRepRegDate(sdf.format(rs.getDate("repDate")));
		return data;
	}

}
