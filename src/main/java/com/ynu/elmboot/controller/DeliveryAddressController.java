package com.ynu.elmboot.controller;

import java.util.List;

import com.ynu.elmboot.service.DeliveryAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynu.elmboot.entity.DeliveryAddress;

@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {
	private final DeliveryAddressService deliveryAddressService;

	public DeliveryAddressController(DeliveryAddressService deliveryAddressService) {
		this.deliveryAddressService = deliveryAddressService;
	}

	@PostMapping("/listDeliveryAddressByUserId")
	public ResponseEntity<List<DeliveryAddress>> listDeliveryAddressByUserId(DeliveryAddress deliveryAddress) {
		try {
			List<DeliveryAddress> result = deliveryAddressService.listDeliveryAddressByUserId(deliveryAddress.getUserId());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/getDeliveryAddressById")
	public ResponseEntity<DeliveryAddress> getDeliveryAddressById(DeliveryAddress deliveryAddress) {
		try {
			DeliveryAddress result = deliveryAddressService.getDeliveryAddressById(deliveryAddress.getDaId());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/saveDeliveryAddress")
	public ResponseEntity<Integer> saveDeliveryAddress(DeliveryAddress deliveryAddress) {
		try {
			int result = deliveryAddressService.saveDeliveryAddress(deliveryAddress);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/updateDeliveryAddress")
	public ResponseEntity<Integer> updateDeliveryAddress(DeliveryAddress deliveryAddress) {
		try {
			int result = deliveryAddressService.updateDeliveryAddress(deliveryAddress);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/removeDeliveryAddress")
	public ResponseEntity<Integer> removeDeliveryAddress(DeliveryAddress deliveryAddress) {
		try {
			int result = deliveryAddressService.removeDeliveryAddress(deliveryAddress.getDaId());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
