package com.ynu.elmboot.service.impl;

import java.util.List;

import com.ynu.elmboot.mapper.DeliveryAddressMapper;
import com.ynu.elmboot.service.DeliveryAddressService;
import org.springframework.stereotype.Service;

import com.ynu.elmboot.entity.DeliveryAddress;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

	private final DeliveryAddressMapper deliveryAddressMapper;
	public DeliveryAddressServiceImpl(DeliveryAddressMapper deliveryAddressMapper){
		this.deliveryAddressMapper = deliveryAddressMapper;
	}

	@Override
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
		return deliveryAddressMapper.listDeliveryAddressByUserId(userId);
	}
	
	@Override
	public DeliveryAddress getDeliveryAddressById(Integer daId) {
		return deliveryAddressMapper.getDeliveryAddressById(daId);
	}
	
	@Override
	public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
		return deliveryAddressMapper.saveDeliveryAddress(deliveryAddress);
	}
	
	@Override
	public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
		return deliveryAddressMapper.updateDeliveryAddress(deliveryAddress);
	}
	
	@Override
	public int removeDeliveryAddress(Integer daId) {
		return deliveryAddressMapper.removeDeliveryAddress(daId);
	}
}
