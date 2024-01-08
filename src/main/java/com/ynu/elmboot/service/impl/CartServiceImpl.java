package com.ynu.elmboot.service.impl;

import java.util.List;

import com.ynu.elmboot.mapper.CartMapper;
import com.ynu.elmboot.entity.Cart;
import com.ynu.elmboot.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

	private final CartMapper cartMapper;
	public CartServiceImpl(CartMapper cartMapper){
		this.cartMapper = cartMapper;
	}
	@Override
	public List<Cart> listCart(Cart cart) {
		return cartMapper.listCart(cart);
	}
	
	@Override
	public int saveCart(Cart cart) {
		return cartMapper.saveCart(cart);
	}
	
	@Override
	public int updateCart(Cart cart) {
		return cartMapper.updateCart(cart);
	}
	
	@Override
	public int removeCart(Cart cart) {
		return cartMapper.removeCart(cart);
	}
}
