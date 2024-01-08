package com.ynu.elmboot.service;

import java.util.List;

import com.ynu.elmboot.entity.Business;

public interface BusinessService {

	public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);
	public Business getBusinessById(Integer businessId);
}
