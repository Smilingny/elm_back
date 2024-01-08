package com.ynu.elmboot.service;

import java.util.List;

import com.ynu.elmboot.entity.Orders;

public interface OrdersService {

	public int createOrders(Orders orders);
	public Orders getOrdersById(Integer orderId);
	public List<Orders> listOrdersByUserId(String userId);
}
