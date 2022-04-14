package com.roh.fyn.cart.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.roh.fyn.cart.CartVO;
import com.roh.fyn.common.JDBCUtil;

@Repository("cartDAO")
public class CartDAO1 {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 장바구니 추가
	private final String CART_INSERT = "insert into cart (cartId,memId,memName,nftId,nftTitle,nftPrice) values((select nvl(max(cartId),2000)+1 from cart),?,?,?,?,?)";
	// 장바구니 삭제
	private final String CART_DELETE = "delete cart where cartId=?";
	// 장바구니 리스트 조회
	private final String CART_SELECTALL = "select * from cart where memId=?";

	// 장바구니 등록
	// memId,memName,nftId,nftTitle,nftPrice
	public void insertCart(CartVO vo) {
		System.out.println("로그 : CARTDAO - insertCart()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(CART_INSERT);
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getMemName());
			pstmt.setInt(3, vo.getNftId());
			pstmt.setString(4, vo.getNftTitle());
			pstmt.setInt(5, vo.getNftPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// 장바구니 삭제
	public void deleteCart(CartVO vo) {
		System.out.println("로그 : CARTDAO - deleteCart()호출");
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(CART_DELETE);
			pstmt.setInt(1, vo.getCartId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	// 장바구니 리스트조회
	public List<CartVO> getCartList(CartVO vo) {
		System.out.println("로그 : CARTDAO - getCartList()호출");
		List<CartVO> datas = new ArrayList<CartVO>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(CART_SELECTALL);
			pstmt.setString(1, vo.getMemId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CartVO data = new CartVO();
				data.setCartId(rs.getInt("cartId"));
				data.setMemId(rs.getString("memId"));
				data.setMemName(rs.getString("memName"));
				data.setNftId(rs.getInt("nftId"));
				data.setNftTitle(rs.getString("nftTitle"));
				data.setNftPrice(rs.getInt("nftPrice"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}

}
