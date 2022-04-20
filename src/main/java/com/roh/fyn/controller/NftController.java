package com.roh.fyn.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.roh.fyn.member.MemberVO;
import com.roh.fyn.nft.NftVO;
import com.roh.fyn.nft.impl.NftDAO1;
import com.roh.fyn.reply.ReplyVO;
import com.roh.fyn.reply.impl.ReplyDAO1;

@Controller
@SessionAttributes("data")
public class NftController {

	// 메인페이지
	@RequestMapping(value = "/main.do")
	public String getNftList(NftVO vo, NftDAO1 nftDAO, Model model) {
		System.out.println("로그 : NFTC - main.do 호출");
		List<NftVO> datas = nftDAO.getNftList(vo);
		model.addAttribute("nftDatas", datas); // Model을 이용하여 전달할 정보를 저장!
		System.out.println("로그 2");
		return "main.jsp";
	}

	// 상세페이지 + 댓글해야함
	@RequestMapping(value = "/nftDetail.do")
	public String getNftReply(NftVO vo, NftDAO1 nftDAO, Model model, ReplyVO rvo, ReplyDAO1 repDAO) {

		vo = nftDAO.getNft(vo);
		model.addAttribute("nftData", vo); // ☆
		System.out.println(vo);

		List<ReplyVO> datas = repDAO.getReplyList(rvo);
		model.addAttribute("replyDatas", datas);
		return "nftDetail.jsp";
	}


}
