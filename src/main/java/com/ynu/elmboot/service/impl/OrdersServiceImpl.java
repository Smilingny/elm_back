package com.ynu.elmboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ynu.elmboot.mapper.CartMapper;
import com.ynu.elmboot.mapper.OrderDetailetMapper;
import com.ynu.elmboot.mapper.OrdersMapper;
import com.ynu.elmboot.entity.Cart;
import com.ynu.elmboot.entity.Orders;
import com.ynu.elmboot.service.OrdersService;
import com.ynu.elmboot.util.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ynu.elmboot.entity.OrderDetailet;

@Service
public class OrdersServiceImpl implements OrdersService {
	

	private final CartMapper cartMapper;
	private final OrdersMapper ordersMapper;
	private final OrderDetailetMapper orderDetailetMapper;
	public OrdersServiceImpl(CartMapper cartMapper, OrdersMapper ordersMapper, OrderDetailetMapper orderDetailetMapper){
		this.cartMapper = cartMapper;
		this.ordersMapper = ordersMapper;
		this.orderDetailetMapper = orderDetailetMapper;
	}

	@Override
	@Transactional
	public int createOrders(Orders orders) {
		//1、查询当前用户购物车中当前商家的所有食品
		Cart cart = new Cart();
		cart.setUserId(orders.getUserId());
		cart.setBusinessId(orders.getBusinessId());
		List<Cart> cartList = cartMapper.listCart(cart);
		
		//2、创建订单（返回生成的订单编号）
		orders.setOrderDate(CommonUtil.getCurrentDate());
		ordersMapper.saveOrders(orders);
		int orderId = orders.getOrderId();
		
		//3、批量添加订单明细
		List<OrderDetailet> list = new ArrayList<>();
		for(Cart c : cartList) {
			OrderDetailet od = new OrderDetailet();
			od.setOrderId(orderId);
			od.setFoodId(c.getFoodId());
			od.setQuantity(c.getQuantity());
			list.add(od);
		}
		orderDetailetMapper.saveOrderDetailetBatch(list);
		
		//4、从购物车表中删除相关食品信息
		cartMapper.removeCart(cart);
		
		return orderId;
	}
	
	@Override
	public Orders getOrdersById(Integer orderId) {
		return ordersMapper.getOrdersById(orderId);
	}
	
	@Override
	public List<Orders> listOrdersByUserId(String userId){
		return ordersMapper.listOrdersByUserId(userId);
	}
}
