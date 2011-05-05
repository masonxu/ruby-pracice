package com.augmentum.training.test;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.augmentum.training.entity.*;
import com.augmentum.training.ioc.BeanFactory;
import com.augmentum.training.ioc.ContextXmlLoader;
import com.augmentum.training.service.UserService;

public class UserServiceTest {

	@Test
	public void testLogin() {
		 BeanFactory beanFactory = null;
		try {
			beanFactory = new ContextXmlLoader();
			UserService userService = (UserService) beanFactory.getBean("userService");
			userService.login(new User());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		                 
		 
		 
	}

}
