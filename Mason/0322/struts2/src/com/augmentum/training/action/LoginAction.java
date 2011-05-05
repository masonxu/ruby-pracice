package com.augmentum.training.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.augmentum.training.util.Constant;
import com.opensymphony.xwork2.ActionSupport;
/**
 * The action is to handle login. If the user is the predefined,
 * the action will return success, otherwise return input. 
 * @author mason.xu
 *
 */
@SuppressWarnings("serial")
public class LoginAction  extends ActionSupport{

	private String username;
	private String password;
	private String error;
	
	public String execute() throws Exception {
		if ((username != null) && (password != null)) {
			if ((username.equals(Constant.USER_NAME)) && 
									(password.equals(Constant.PASSWORD))) {
				return SUCCESS;
			} else {
				this.error = Constant.ERROR_MESSAGE;
			}
		} else {
			this.error = Constant.ALERT_MESSAGE;
		}
		
		return INPUT;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
