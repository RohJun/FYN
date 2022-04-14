package com.roh.fyn.reply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roh.fyn.reply.ReplyService;
import com.roh.fyn.reply.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService{

	@Autowired	//DI
	private ReplyDAO1 replyDAO;
	
	@Override
	public void insertReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		replyDAO.insertReply(vo);
	}

	@Override
	public void deleteReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		replyDAO.deleteReply(vo);
	}

	@Override
	public List<ReplyVO> getReplyList(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyDAO.getReplyList(vo);
	}

}
