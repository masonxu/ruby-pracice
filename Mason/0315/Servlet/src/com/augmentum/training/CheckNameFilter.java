package com.augmentum.training;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CheckNameFilter implements Filter{
	
	UserManager um = null;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		String userName = arg0.getParameter(Const.USER_NAME);
		String type = arg0.getParameter(Const.TYPE);
		String password = arg0.getParameter(Const.PASSWORD);
		Map userMap = um.getUserMap();
		
		if (Const.REGISTER.equals(type)) {
			if(userMap.containsKey(userName)) {
				System.out.println("------register failure-------");
			}
		} else if(Const.LOGIN.equals(type)) {
			User s = (User) userMap.get(userName);
			if (s != null) {
				String st = s.getPassword();
				if(s.equals(password)) {
					System.out.println("------password error-------");
				}
			}	
		}
		
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		um = UserManagerFactory.getUserManager();
	}

}
