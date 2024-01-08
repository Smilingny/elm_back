package com.ynu.elmboot.controller;

import java.util.List;

import com.ynu.elmboot.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynu.elmboot.entity.Food;

@RestController
@RequestMapping("/FoodController")
public class FoodController {
	private final FoodService foodService;

	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}

	@PostMapping("/listFoodByBusinessId")
	public ResponseEntity<List<Food>> listFoodByBusinessId(Food food) {
		try {
			List<Food> result = foodService.listFoodByBusinessId(food.getBusinessId());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
