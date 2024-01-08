package com.ynu.elmboot.service;

import com.ynu.elmboot.entity.User;

public interface UserService {

	public User login(User user);
	public int getUserById(String userId);
	public int saveUser(User user);
}
