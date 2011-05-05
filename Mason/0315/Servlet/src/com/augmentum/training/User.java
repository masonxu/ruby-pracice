package com.augmentum.training;

import java.util.GregorianCalendar;
import java.util.UUID;

public class User {
	
	private String userName;
	private String password;
	private String status;
	private long loginTimes; 
	private GregorianCalendar lastOnlineTime;
	
	public User(String userName) {
		this.userName = userName;
		this.password = Const.DEFAULT_PASSWORD;
		this.status = Const.USER_ONLINE;
		this.loginTimes = Const.ZERO;
	}
	public User(String userName, String password){
		this.userName = userName;
		this.password = password;
		this.status = Const.USER_ONLINE;
		this.loginTimes = Const.ZERO;
	}
	
	
	public boolean login() {
		return true;
	}
	
	public boolean logout() {
		return true;
	}
	
	/**
	 * Reset the password.
	 * @param oldPassword
	 * @param newPassword
	 * @return true or false of operation of setting password.
	 */
	public boolean setPassword(String oldPassword,String newPassword) {
		if (this.password.equals(oldPassword)) {
			this.password = newPassword;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Use to get password.
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Use to get userName.
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Use to set userName
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Use to get the status of user.
	 * @return online or off-line
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Use to set the status of user.
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Use to get the time of last exit.
	 * @return
	 */
	public GregorianCalendar getLastOnlineTime() {
		return lastOnlineTime;
	}
	
	/**
	 * Use to set the time of last exit.
	 * @param lastOnlineTime
	 */
	public void setLastOnlineTime(GregorianCalendar lastOnlineTime) {
		this.lastOnlineTime = lastOnlineTime;
	}
	
	/**
	 * Use to get the time of login.
	 * @return
	 */
	public long getLoginTimes() {
		return loginTimes;
	}
	/**
	 * Use to set the time of login.
	 * @param loginTimes
	 */
	public void setLoginTimes(long loginTimes) {
		this.loginTimes = loginTimes;
	}
	
	

}
