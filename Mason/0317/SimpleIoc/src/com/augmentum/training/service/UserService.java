package com.augmentum.training.service;

import com.augmentum.training.dao.UserDao;
import com.augmentum.training.entity.User;

/**
 * UserSerivice is used to handling the business about the class User.
 * @author mason.xu
 * @version 1.0 2011/03/18
 */
public class UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void login(User user) {
		System.out.println("service login.");
		userDao.login(user);
	}
	
}
