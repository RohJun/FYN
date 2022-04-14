package com.roh.fyn.reply;

import java.util.List;


// 메서드 시그니처 강제
public interface ReplyService {
	public void insertReply(ReplyVO vo);
	public void deleteReply(ReplyVO vo);
	public List<ReplyVO> getReplyList(ReplyVO vo);
}
