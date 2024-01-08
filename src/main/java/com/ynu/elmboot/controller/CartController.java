package com.ynu.elmboot.controller;

import java.util.List;

import com.ynu.elmboot.entity.Cart;
import com.ynu.elmboot.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CartController")
public class CartController {
	private final CartService cartService;

	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping("/listCart")
	public ResponseEntity<List<Cart>> listCart(Cart cart) {
		try {
			List<Cart> result = cartService.listCart(cart);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/saveCart")
	public ResponseEntity<Integer> saveCart(Cart cart) {
		try {
			int result = cartService.saveCart(cart);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/updateCart")
	public ResponseEntity<Integer> updateCart(Cart cart) {
		try {
			int result = cartService.updateCart(cart);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/removeCart")
	public ResponseEntity<Integer> removeCart(Cart cart) {
		try {
			int result = cartService.removeCart(cart);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
