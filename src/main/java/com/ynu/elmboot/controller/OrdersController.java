package com.ynu.elmboot.controller;

import java.util.List;

import com.ynu.elmboot.entity.Orders;
import com.ynu.elmboot.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/OrdersController")
public class OrdersController {
	private final OrdersService ordersService;

	public OrdersController(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	@PostMapping("/createOrders")
	public ResponseEntity<Integer> createOrders(Orders orders) {
		try {
			int result = ordersService.createOrders(orders);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/getOrdersById")
	public ResponseEntity<Orders> getOrdersById(Orders orders) {
		try {
			Orders result = ordersService.getOrdersById(orders.getOrderId());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/listOrdersByUserId")
	public ResponseEntity<List<Orders>> listOrdersByUserId(Orders orders) {
		try {
			List<Orders> result = ordersService.listOrdersByUserId(orders.getUserId());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
