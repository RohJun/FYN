package com.roh.fyn.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roh.fyn.notice.NoticeVO;
import com.roh.fyn.notice.impl.NoticeDAO1;

@Controller
public class NoticeController {

	//  공지사항 리스트 페이지
	@RequestMapping(value = "/notice.do")
	public String getNoticeList(NoticeVO vo, NoticeDAO1 noticeDAO, Model model) {
		List<NoticeVO> datas = noticeDAO.getNoticeList(vo);
		model.addAttribute("noticeDatas", datas); // Model을 이용하여 전달할 정보를 저장!
		return "notice.jsp";
	}
}
