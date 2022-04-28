package com.roh.fyn.nft.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.roh.fyn.common.JDBCUtil;
import com.roh.fyn.nft.NftVO;

//@Repository("nftDAO")
public class NftDAO1 {
	Connection conn;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

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
	//nftstatus 수정 구매
	private final String NFT_UPDATE_PURCHASE="update nft set nftStatus=nftStatus+1 where nftId=?";
	
	// nft 조회
	public NftVO getNft(NftVO vo) {
		System.out.println("로그 : NFTDAO - getNft()호출");
		NftVO data = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(NFT_SELECTONE);
			pstmt.setInt(1, vo.getNftId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// nftDate(데이트) -> nftRegDate(스트링)
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				data = new NftVO();
				data.setNftId(rs.getInt("nftId"));
				data.setNftTitle(rs.getString("nftTitle"));
				data.setNftRegDate(sdf.format(rs.getDate("nftDate")));
				data.setNftPrice(rs.getInt("nftPrice"));
				data.setNftPic(rs.getString("nftPic"));
				data.setNftStatus(rs.getInt("nftStatus"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}

	// nft 등록
	public void insertNft(NftVO vo) {
		System.out.println("로그 : NFTDAO - insertNft()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(NFT_INSERT);
			pstmt.setString(1, vo.getNftTitle());
			pstmt.setInt(2, vo.getNftPrice());
			pstmt.setString(3, vo.getNftPic());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// nft정보수정
	// nftTitle=?, nftPrice=?, nftStatus=? where nftId=?";
	public void updateNft(NftVO vo) {
		System.out.println("로그 : NFTDAO - updateNft()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(NFT_UPDATE);
			pstmt.setString(1, vo.getNftTitle());
			pstmt.setInt(2, vo.getNftPrice());
			pstmt.setInt(3, vo.getNftStatus());
			pstmt.setInt(4, vo.getNftId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public void updateNftPurchase(NftVO vo) {
		System.out.println("로그 : NFTDAO - updateNftPurchase()호출");
		conn = JDBCUtil.connect();
		try {
			System.out.println("로그 NFTDAO - 1");
			pstmt = conn.prepareStatement(NFT_UPDATE_PURCHASE);
			pstmt.setInt(1, vo.getNftId());
			pstmt.executeUpdate();
			System.out.println("로그 NFTDAO - 2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// nft삭제
	public void deleteNft(NftVO vo) {
		System.out.println("로그 : NFTDAO - deleteNft()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(NFT_DELETE);
			pstmt.setInt(1, vo.getNftId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// nft리스트조회
	public List<NftVO> getNftList(NftVO vo) {
		System.out.println("로그 : NFTDAO - getNftList()호출");
		List<NftVO> datas = new ArrayList<NftVO>();
		conn = JDBCUtil.connect();
		try {
			if (vo.getSearchText() == null) {
				pstmt = conn.prepareStatement(NFT_SELECTALL);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// nftDate(데이트) -> nftRegDate(스트링)
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					NftVO data = new NftVO();
					data.setNftId(rs.getInt("nftId"));
					data.setNftTitle(rs.getString("nftTitle"));
					data.setNftRegDate(sdf.format(rs.getDate("nftDate")));
					data.setNftPrice(rs.getInt("nftPrice"));
					data.setNftPic(rs.getString("nftPic"));
					datas.add(data);
				}
			} else {
				pstmt = conn.prepareStatement(NFT_SELECTALL_TITLE);
				pstmt.setString(1, vo.getSearchText());
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					// nftDate(데이트) -> nftRegDate(스트링)
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					NftVO data = new NftVO();
					data.setNftId(rs.getInt("nftId"));
					data.setNftTitle(rs.getString("nftTitle"));
					data.setNftRegDate(sdf.format(rs.getDate("nftDate")));
					data.setNftPrice(rs.getInt("nftPrice"));
					data.setNftPic(rs.getString("nftPic"));
					datas.add(data);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}
}
