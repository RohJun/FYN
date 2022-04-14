package com.roh.fyn.nft.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roh.fyn.nft.NftService;
import com.roh.fyn.nft.NftVO;

@Service("nftService")
public class NftServiceImpl implements NftService{

	@Autowired // DI
	private NftDAO1 nftDAO;
	
	@Override
	public NftVO getNft(NftVO vo) {
		// TODO Auto-generated method stub
		return nftDAO.getNft(vo);
	}

	@Override
	public void insertNft(NftVO vo) {
		// TODO Auto-generated method stub
		nftDAO.insertNft(vo);
	}

	@Override
	public void updateNft(NftVO vo) {
		// TODO Auto-generated method stub
		nftDAO.updateNft(vo);
	}

	@Override
	public void deleteNft(NftVO vo) {
		// TODO Auto-generated method stub
		nftDAO.deleteNft(vo);
	}

	@Override
	public List<NftVO> getNftList(NftVO vo) {
		// TODO Auto-generated method stub
		return nftDAO.getNftList(vo);
	}

}
