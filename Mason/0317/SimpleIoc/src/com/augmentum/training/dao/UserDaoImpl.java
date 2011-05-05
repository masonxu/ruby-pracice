package com.augmentum.training.dao;

import com.augmentum.training.entity.User;

/**
 * UserDaoImpl implements the interface {@link #BeanFactory}.
 * @author mason.xu
 * @version 1.0 2011/03/18
 */
public class UserDaoImpl implements UserDao{

	@Override
	public void login(User user) {
		// TODO Auto-generated method stub
		System.out.println("Login Success");
	}
	
}
