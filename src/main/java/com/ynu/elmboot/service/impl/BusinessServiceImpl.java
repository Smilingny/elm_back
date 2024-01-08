package com.ynu.elmboot.service.impl;

import java.util.List;

import com.ynu.elmboot.service.BusinessService;
import org.springframework.stereotype.Service;

import com.ynu.elmboot.mapper.BusinessMapper;
import com.ynu.elmboot.entity.Business;

@Service
public class BusinessServiceImpl implements BusinessService {

	private final BusinessMapper businessMapper;
	public BusinessServiceImpl(BusinessMapper businessMapper){
		this.businessMapper = businessMapper;
	}

	@Override
	public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
		return businessMapper.listBusinessByOrderTypeId(orderTypeId);
	}
	
	@Override
	public Business getBusinessById(Integer businessId) {
		return businessMapper.getBusinessById(businessId);
	}
}
