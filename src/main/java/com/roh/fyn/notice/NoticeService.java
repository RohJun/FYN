package com.roh.fyn.notice;

import java.util.List;

public interface NoticeService {
	//메서드 강제
	public void insertNotice(NoticeVO vo);
	public List<NoticeVO> getNoticeList(NoticeVO vo);
}
