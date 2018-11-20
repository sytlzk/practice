package com.java1234.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java1234.user.dao.UserDao;
import com.java1234.user.entity.User;
import com.java1234.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userdao;
	public User login(User user) {
		return userdao.login(user);
	}

}
