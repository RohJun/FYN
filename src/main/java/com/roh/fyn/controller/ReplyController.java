package com.roh.fyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roh.fyn.reply.ReplyVO;
import com.roh.fyn.reply.impl.ReplyDAO1;

@Controller
public class ReplyController {
	//댓글 작성
	@RequestMapping(value="/addReply.do")
	public String insertReply(ReplyVO vo,ReplyDAO1 replyDAO) {
		System.out.println("로그: repC - 리뷰등록 요청"+vo.getMemId()+vo.getRepTitle());
		replyDAO.insertReply(vo);
		return "nftDetail.do";
	}
	//댓글 삭제
	@RequestMapping(value="/deleteReply.do")
	public String deleteReply(ReplyVO vo,ReplyDAO1 replyDAO) {
		System.out.println("로그: repC - 댓글 삭제 요청");
		replyDAO.deleteReply(vo);
		return "nftDetail.do";
	}
}
