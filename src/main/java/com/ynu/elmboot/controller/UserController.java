package com.ynu.elmboot.controller;

import com.ynu.elmboot.entity.User;
import com.ynu.elmboot.service.UserService;
import com.ynu.elmboot.util.JwtUtil;
import com.ynu.elmboot.util.RedisCache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/UserController")
public class UserController {
	
	private final JwtUtil jwtUtil;
	private final UserService userService;
	private final RedisCache redisCache;
	public UserController(UserService userService, JwtUtil jwtUtil, RedisCache redisCache){
		this.userService = userService;
		this.jwtUtil = jwtUtil;
		this.redisCache = redisCache;
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(User user) throws Exception{
		User userInfo = userService.login(user);
		if (userInfo != null){
			String key = "user:"+userInfo.getUserId();
			redisCache.setCacheObject(key,user,7, TimeUnit.DAYS);
			String token =  JwtUtil.createToken(userInfo);
			Map<String, Object> map = new HashMap<>();
			map.put("token", token);
			map.put("user", userInfo);
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
		return new ResponseEntity<>("登陆失败", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/getUserById")
	public ResponseEntity<Integer> getUserById(User user) {
		try {
			int result = userService.getUserById(user.getUserId());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/saveUser")
	public ResponseEntity<Integer> saveUser(User user) {
		try {
			int result = userService.saveUser(user);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
