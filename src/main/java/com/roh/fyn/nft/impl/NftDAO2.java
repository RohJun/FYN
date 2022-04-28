package com.roh.fyn.nft.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.roh.fyn.nft.NftVO;

//@Repository("nftDAO")
public class NftDAO2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// nft추가
	private final String NFT_INSERT = "insert into nft (nftId,nftTitle,nftPrice,nftPic) values((select nvl(max(nftId),1000)+1 from nft),?,?,?)";
	// nft조회
	private final String NFT_SELECTONE = "select * from nft where nftId=?";
	// nft수정
	private final String NFT_UPDATE = "update nft set nftTitle=?, nftPrice=?, nftStatus=? where nftId=?";
	// nft삭제
	private final String NFT_DELETE = "delete nft where nftId=?";
	// nft리스트 조회
	private final String NFT_SELECTALL = "select * from nft";
	// nft리스트 조회 제목검색
	private final String NFT_SELECTALL_TITLE = "select * from nft where lower(nftTitle) like '%'|| lower(?) ||'%' order by nftTitle DESC";
	// nftstatus 수정 구매
	private final String NFT_UPDATE_PURCHASE = "update nft set nftStatus=nftStatus+1 where nftId=?";

	// nft 조회
	public NftVO getNft(NftVO vo) {
		System.out.println("로그 : NFTDAO2 - getNft()호출");
		Object[] args = { vo.getNftId() };
		return jdbcTemplate.queryForObject(NFT_SELECTONE, args, new NftRowMapper());
	}

	// nft 등록
	public void insertNft(NftVO vo) {
		System.out.println("로그 : NFTDAO2 - insertNft()호출");
		jdbcTemplate.update(NFT_INSERT, vo.getNftTitle(), vo.getNftPrice(), vo.getNftPic());
	}

	// nft정보수정
	public void updateNft(NftVO vo) {
		System.out.println("로그 : NFTDAO2 - updateNft()호출");
		jdbcTemplate.update(NFT_UPDATE, vo.getNftTitle(), vo.getNftPrice(), vo.getNftStatus(), vo.getNftId());
	}

	// nft 수정 (구매 후)
	public void updateNftPurchase(NftVO vo) {
		System.out.println("로그 : NFTDAO2 - updateNftPurchase()호출");
		jdbcTemplate.update(NFT_UPDATE_PURCHASE, vo.getNftId());
	}

	// nft삭제
	public void deleteNft(NftVO vo) {
		System.out.println("로그 : NFTDAO - deleteNft()호출");
		jdbcTemplate.update(NFT_DELETE, vo.getNftId());
	}

	// nft리스트조회
	public List<NftVO> getNftList(NftVO vo) {
		System.out.println("로그 : NFTDAO2 - getNftList()호출");
		// 리스트조회
		if (vo.getSearchText() == null) {
			return jdbcTemplate.query(NFT_SELECTALL, new NftRowMapper());
		}
		// 검색리스트조회
		else {
			Object[] args = { vo.getSearchText() };
			return jdbcTemplate.query(NFT_SELECTALL, args, new NftRowMapper());
		}
	}
}

class NftRowMapper implements RowMapper<NftVO> {

	@Override
	public NftVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NftVO data = new NftVO();
		// nftDate(데이트) -> nftRegDate(스트링)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		data.setNftId(rs.getInt("nftId"));
		data.setNftTitle(rs.getString("nftTitle"));
		data.setNftRegDate(sdf.format(rs.getDate("nftDate")));
		data.setNftPrice(rs.getInt("nftPrice"));
		data.setNftPic(rs.getString("nftPic"));
		return data;
	}

}
