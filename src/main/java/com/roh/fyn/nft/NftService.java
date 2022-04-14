package com.roh.fyn.nft;

import java.util.List;

// 메서드 시그니처 강제
public interface NftService {
	public NftVO getNft(NftVO vo);
	public void insertNft(NftVO vo);
	public void updateNft(NftVO vo);
	public void deleteNft(NftVO vo);
	public List<NftVO> getNftList(NftVO vo);
}
