package com.roh.fyn.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.roh.fyn.member.MemberVO;
import com.roh.fyn.member.impl.MemberDAO1;
import com.roh.fyn.nft.NftVO;
import com.roh.fyn.nft.impl.NftDAO1;
import com.roh.fyn.notice.NoticeVO;
import com.roh.fyn.notice.impl.NoticeDAO1;
import com.roh.fyn.reply.ReplyVO;
import com.roh.fyn.reply.impl.ReplyDAO1;

@Controller
public class AdminController {

	// 관리자 메인
	@RequestMapping(value = "/adminMain.do")
	public String getAllList(NftVO nftvo, NftDAO1 nftDAO, MemberVO memvo, MemberDAO1 memberDAO, NoticeVO notvo,
			NoticeDAO1 noticeDAO, ReplyVO repvo, ReplyDAO1 replyDAO, Model model) {
		List<NftVO> nftdatas = nftDAO.getNftList(nftvo);
		List<MemberVO> memdatas = memberDAO.getMemberList(memvo);
		List<NoticeVO> notdatas = noticeDAO.getNoticeList(notvo);
		List<ReplyVO> repdatas = replyDAO.getReplyList(repvo);

		model.addAttribute("nftDatas", nftdatas); // Model을 이용하여 전달할 정보를 저장!
		model.addAttribute("memDatas", memdatas);
		model.addAttribute("notDatas", notdatas);
		model.addAttribute("repDatas", repdatas);
		return "admin_main.jsp";
	}

	// 관리자 검색
	@RequestMapping(value = "/adminSearch.do")
	public String getAllListSearch(NftVO nftvo, NftDAO1 nftDAO, MemberVO memvo, MemberDAO1 memberDAO, NoticeVO notvo,
			NoticeDAO1 noticeDAO, ReplyVO repvo, ReplyDAO1 replyDAO, Model model) {
		System.out.println("로그" + memvo);
		System.out.println("로그" + nftvo);
		List<NftVO> nftdatas = nftDAO.getNftList(nftvo);
		List<MemberVO> memdatas = memberDAO.getMemberList(memvo);
		List<NoticeVO> notdatas = noticeDAO.getNoticeList(notvo);
		List<ReplyVO> repdatas = replyDAO.getReplyList(repvo);
		System.out.println("adSearch " + memdatas);
		System.out.println("adSearch " + nftdatas);
		System.out.println("adSearch " + repdatas);

		model.addAttribute("nftDatas", nftdatas); // Model을 이용하여 전달할 정보를 저장!
		model.addAttribute("memDatas", memdatas);
		model.addAttribute("notDatas", notdatas);
		model.addAttribute("repDatas", repdatas);
		return "admin_searchResult.jsp";
	}

	// 관리자 공지사항 등록
	@RequestMapping(value = "/adminInsertNotice.do")
	public String insertNotice(NoticeVO vo, NoticeDAO1 noticeDAO) {
		System.out.println("AdC - " + vo.getNotTitle());
		System.out.println("AdC - " + vo.getNotContent());

		noticeDAO.insertNotice(vo);
		return "redirect:adminMain.do";
	}

	// 관리자 NFT 상품 등록
	@RequestMapping(value = "/adminInsertNft.do")
	public String insertCart(NftVO vo, NftDAO1 nftDAO) throws IllegalStateException, IOException {
		// 파일업로드 로직
		System.out.println("로그 AdC - NFT등록 요청"+vo);
		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String nftPic = uploadFile.getOriginalFilename();
			System.out.println("파일명: " + nftPic);
			vo.setNftPic(nftPic);
			uploadFile.transferTo(new File("C:\\Users\\junro\\eclipse-workspace\\SP_FYN_v1.0\\src\\main\\webapp\\img\\" + nftPic));
		}
		System.out.println(vo.getNftPic());
		nftDAO.insertNft(vo);
		return "redirect:adminMain.do";
	}

	// 관리자 회원 리스트 페이지
	@RequestMapping(value = "/adminMemberMain.do")
	public String getNftList(MemberVO vo, MemberDAO1 memberDAO, Model model) {
		List<MemberVO> datas = memberDAO.getMemberList(vo);
		model.addAttribute("memberDatas", datas); // Model을 이용하여 전달할 정보를 저장!
		System.out.println(datas);
		return "admin_member_main.jsp";
	}

	// 관리자 회원 상세 페이지
	@RequestMapping("/adminMemberDetail.do")
	public String getMember(MemberVO vo, MemberDAO1 memberDAO, Model model) {
		vo = memberDAO.getMember(vo);
		model.addAttribute("memData", vo);
		return "admin_member_detail.jsp";
	}

	// 관리자 회원 수정
	@RequestMapping("/adminMemberUpdate.do")
	public String updateMember(MemberVO vo, MemberDAO1 memberDAO, Model model) {
		System.out.println(vo);
		memberDAO.updateMember(vo);
		System.out.println(vo);
		model.addAttribute("memData", vo);
		return "admin_member_detail.jsp";
	}

	// 관리자 회원 탈퇴
	@RequestMapping(value = "/adminMemberDelete.do")
	public String deleteMember(MemberVO vo, MemberDAO1 memberDAO) {
		memberDAO.deleteMember(vo);
		return "redirect:adminMemberMain.do";
	}

	// 관리자 NFT 리스트 페이지
	@RequestMapping(value = "/adminNftMain.do")
	public String getNftList(NftVO vo, NftDAO1 nftDAO, Model model) {
		List<NftVO> datas = nftDAO.getNftList(vo);
		System.out.println(vo.getNftPic());
		model.addAttribute("nftDatas", datas); // Model을 이용하여 전달할 정보를 저장!
		return "admin_nft_main.jsp";
	}

	// 관리자 NFT 상세 페이지
	@RequestMapping("/adminNftDetail.do")
	public String getNft(NftVO vo, NftDAO1 nftDAO, Model model) {
		vo = nftDAO.getNft(vo);
		model.addAttribute("nftData", vo);
		return "admin_nft_detail.jsp";
	}

	// 관리자 NFT 수정
	@RequestMapping("/adminNftUpdate.do")
	public String updateNft(NftVO vo, NftDAO1 nftDAO, Model model) {
		System.out.println(vo);
		nftDAO.updateNft(vo);
		return "adminNftMain.do";
	}

	// 관리자 NFT 삭제
	@RequestMapping(value = "/adminNftDelete.do")
	public String deleteNft(NftVO vo, NftDAO1 nftDAO) {
		nftDAO.deleteNft(vo);
		return "redirect:adminNftMain.do";
	}

	// 관리자 공지사항 리스트 페이지
	@RequestMapping(value = "/adminNotice.do")
	public String getNftList1(NoticeVO vo, NoticeDAO1 noticeDAO, Model model) {
		List<NoticeVO> datas = noticeDAO.getNoticeList(vo);
		model.addAttribute("noticeDatas", datas); // Model을 이용하여 전달할 정보를 저장!
		return "admin_notice.jsp";
	}
}
