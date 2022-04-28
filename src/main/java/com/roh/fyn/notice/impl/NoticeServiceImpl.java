package com.roh.fyn.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roh.fyn.notice.NoticeService;
import com.roh.fyn.notice.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Autowired //DI
	private NoticeDAO3 noticeDAO;
	
	@Override
	public void insertNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		noticeDAO.insertNotice(vo);
	}

	@Override
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		// TODO Auto-generated method stub
		return noticeDAO.getNoticeList(vo);
	}

}
