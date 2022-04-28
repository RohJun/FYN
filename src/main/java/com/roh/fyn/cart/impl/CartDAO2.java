package com.roh.fyn.cart.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.roh.fyn.cart.CartVO;

//@Repository("cartDAO")
public class CartDAO2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 장바구니 추가
	private final String CART_INSERT = "insert into cart (cartId,memId,memName,nftId,nftTitle,nftPrice) values((select nvl(max(cartId),2000)+1 from cart),?,?,?,?,?)";
	// 장바구니 삭제
	private final String CART_DELETE = "delete cart where cartId=?";
	// 장바구니 리스트 조회
	private final String CART_SELECTALL = "select * from cart where memId=?";

	// 장바구니 등록
	public void insertCart(CartVO vo) {
		System.out.println("로그 : CartDAO2 : insertCart 호출");
		jdbcTemplate.update(CART_INSERT, vo.getMemId(), vo.getMemName(), vo.getNftId(), vo.getNftTitle(),
				vo.getNftPrice());
	}

	// 장바구니 삭제
	public void deleteCart(CartVO vo) {
		System.out.println("로그 : CARTDAO2 - deleteCart()호출");
		jdbcTemplate.update(CART_DELETE, vo.getCartId());
	}

	// 장바구니 리스트조회
	public List<CartVO> getCartList(CartVO vo) {
		System.out.println("로그 : CARTDAO2 - getCartList()호출");
		return jdbcTemplate.query(CART_SELECTALL, new CartRowMapper());
	}
}

class CartRowMapper implements RowMapper<CartVO> {
	@Override
	public CartVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartVO data = new CartVO();
		data.setCartId(rs.getInt("cartId"));
		data.setMemId(rs.getString("memId"));
		data.setMemName(rs.getString("memName"));
		data.setNftId(rs.getInt("nftId"));
		data.setNftTitle(rs.getString("nftTitle"));
		data.setNftPrice(rs.getInt("nftPrice"));
		return data;
	}
}
