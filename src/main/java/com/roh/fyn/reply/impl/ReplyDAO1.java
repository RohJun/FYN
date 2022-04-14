package com.roh.fyn.reply.impl;

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
import com.roh.fyn.reply.ReplyVO;

@Repository("replyDAO")

public class ReplyDAO1 {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 댓글 추가
	private final String REPLY_INSERT = "insert into reply (repId,memId,memName,nftId,repTitle,repContent) values((select nvl(max(repId),3000)+1 from reply),?,?,?,?,?)";
	// 댓글 삭제
	private final String REPLY_DELETE = "delete reply where repId=?";
	// 댓글 리스트 nftId로 조회
	private final String REPLY_SELECTALL_NFTID = "select * from reply where nftId=?";
	// 댓글 리스트 조회 제목검색
	private final String REPLY_SELECTALL_MEMNAME = "select * from reply where lower(memName) like '%'|| lower(?) ||'%' order by memName DESC";

	// 댓글 등록
	// memId,memName,nftId,repTitle,repContent
	public void insertReply(ReplyVO vo) {
		System.out.println("로그 : REPLYDAO - insertReply()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(REPLY_INSERT);
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getMemName());
			pstmt.setInt(3, vo.getNftId());
			pstmt.setString(4, vo.getRepTitle());
			pstmt.setString(5, vo.getRepContent());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// 댓글 삭제
	public void deleteReply(ReplyVO vo) {
		System.out.println("로그 : REPLYDAO - deleteReply()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(REPLY_DELETE);
			pstmt.setInt(1, vo.getRepId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	//댓글 리스트 조회_nftId
		public List<ReplyVO> getReplyList(ReplyVO vo){
			System.out.println("로그 : REPLYDAO - getReplyList()호출");
			List<ReplyVO> datas = new ArrayList<ReplyVO>();
			conn=JDBCUtil.connect();
			try {
				if(vo.getSearchText()== null) {	//그냥 조회
					pstmt=conn.prepareStatement(REPLY_SELECTALL_NFTID);
					pstmt.setInt(1, vo.getNftId());
					ResultSet rs=pstmt.executeQuery();
					while(rs.next()) {
						//repDate(데이트) -> repRegDate(스트링)
			            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			            ReplyVO data=new ReplyVO(); 
						data.setRepId(rs.getInt("repId"));
						data.setMemId(rs.getString("memId"));
						data.setMemName(rs.getString("memName"));
						data.setNftId(rs.getInt("nftId"));
						data.setRepTitle(rs.getString("repTitle"));
						data.setRepContent(rs.getString("repContent"));
						data.setRepRegDate(sdf.format(rs.getDate("repDate")));
						datas.add(data);
					}
				}
				else {//검색
					pstmt=conn.prepareStatement(REPLY_SELECTALL_MEMNAME);
					pstmt.setString(1, vo.getMemId());
					ResultSet rs=pstmt.executeQuery();
					while(rs.next()) {
						//repDate(데이트) -> repRegDate(스트링)
			            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			            ReplyVO data=new ReplyVO(); 
						data.setRepId(rs.getInt("repId"));
						data.setMemId(rs.getString("memId"));
						data.setMemName(rs.getString("memName"));
						data.setNftId(rs.getInt("nftId"));
						data.setRepTitle(rs.getString("repTitle"));
						data.setRepContent(rs.getString("repContent"));
						data.setRepRegDate(sdf.format(rs.getDate("repDate")));
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
