package com.roh.fyn.nft.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roh.fyn.nft.NftVO;

@Repository("nftDAO")
public class NftDAO3 {

	@Autowired
	private SqlSessionTemplate mybatis;

	// nft 조회
	public NftVO getNft(NftVO vo) {
		System.out.println("로그 : NFTDAO3 - getNft()호출");
		return mybatis.selectOne("NftDAO.getNft", vo);
	}

	// nft 등록
	public void insertNft(NftVO vo) {
		System.out.println("로그 : NFTDAO3 - insertNft()호출");
		mybatis.insert("NftDAO.insertNft", vo);
	}

	// nft정보수정
	public void updateNft(NftVO vo) {
		System.out.println("로그 : NFTDAO3 - updateNft()호출");
		mybatis.update("NftDAO.updateNft", vo);
	}

	// nft 수정 (구매 후)
	public void updateNftPurchase(NftVO vo) {
		System.out.println("로그 : NFTDAO3 - updateNftPurchase()호출");
		mybatis.update("NftDAO.updateNftPurchase", vo);
	}

	// nft삭제
	public void deleteNft(NftVO vo) {
		System.out.println("로그 : NFTDAO3 - deleteNft()호출");
		mybatis.delete("NftDAO.deleteNft", vo);
	}

	// nft리스트조회
	public List<NftVO> getNftList(NftVO vo) {
		System.out.println("로그 : NFTDAO3 - getNftList()호출");
		return mybatis.selectList("NftDAO.getNftList", vo);
	}
}

