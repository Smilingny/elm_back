package com.ynu.elmboot.service.impl;

import java.util.List;

import com.ynu.elmboot.mapper.FoodMapper;
import com.ynu.elmboot.service.FoodService;
import org.springframework.stereotype.Service;

import com.ynu.elmboot.entity.Food;

@Service
public class FoodServiceImpl implements FoodService {
	

	private final FoodMapper foodMapper;
	public FoodServiceImpl(FoodMapper foodMapper){
		this.foodMapper = foodMapper;
	}

	@Override
	public List<Food> listFoodByBusinessId(Integer businessId) {
		return foodMapper.listFoodByBusinessId(businessId);
	}
}
