package com.roh.fyn.notice.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roh.fyn.notice.NoticeVO;

@Repository("noticeDAO")
public class NoticeDAO3 {
	@Autowired
	private SqlSessionTemplate mybatis;

	// 공지사항 등록
	public void insertNotice(NoticeVO vo) {
		System.out.println("로그 : NOTDAO3 - insertNotice()호출");
		mybatis.insert("NoticeDAO.insertNotice", vo);
	}

	// 공지사항 리스트 조회
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		System.out.println("로그 : NFTDAO3 - getNftList()호출");
		return mybatis.selectList("NoticeDAO.getNoticeList", vo);
	}
}
