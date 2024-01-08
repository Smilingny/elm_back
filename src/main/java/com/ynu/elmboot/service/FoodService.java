package com.ynu.elmboot.service;

import java.util.List;

import com.ynu.elmboot.entity.Food;

public interface FoodService {

	public List<Food> listFoodByBusinessId(Integer businessId);
}
