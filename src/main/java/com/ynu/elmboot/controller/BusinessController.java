package com.ynu.elmboot.controller;

import java.util.List;

import com.ynu.elmboot.service.BusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynu.elmboot.entity.Business;

@RestController
@RequestMapping("/BusinessController")
public class BusinessController {
	private final BusinessService businessService;

	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}

	@PostMapping("/listBusinessByOrderTypeId")
	public ResponseEntity<List<Business>> listBusinessByOrderTypeId(Business business) {
		try {
			List<Business> result = businessService.listBusinessByOrderTypeId(business.getOrderTypeId());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/getBusinessById")
	public ResponseEntity<Business> getBusinessById(Business business) {
		try {
			Business result = businessService.getBusinessById(business.getBusinessId());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
