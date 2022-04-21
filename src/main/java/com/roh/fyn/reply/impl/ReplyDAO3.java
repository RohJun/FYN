package com.roh.fyn.reply.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roh.fyn.reply.ReplyVO;

@Repository("replyDAO")

public class ReplyDAO3 {
	@Autowired
	private SqlSessionTemplate mybatis;

	// 댓글 등록
	public void insertReply(ReplyVO vo) {
		System.out.println("로그 : REPLYDAO3 - insertReply()호출");
		mybatis.insert("ReplyDAO.insertReply", vo);
	}

	// 댓글 삭제
	public void deleteReply(ReplyVO vo) {
		System.out.println("로그 : REPLYDAO3 - deleteReply()호출");
		mybatis.delete("ReplyDAO.deleteReply", vo);
	}

	// 댓글 리스트 조회_nftId
	public List<ReplyVO> getReplyList(ReplyVO vo) {
		System.out.println("로그 : REPLYDAO3 - getReplyList()호출");
		return mybatis.selectList("ReplyDAO.getReplyList", vo);
	}
}
