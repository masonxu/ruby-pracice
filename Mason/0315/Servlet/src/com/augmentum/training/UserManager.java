package com.augmentum.training;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
	// The map is used for storing the user.
	private  static Map<String,User> userMap = 
				 new ConcurrentHashMap<String, User>();
	
	// The list is used for storing the online user.
	private static List<User> onlineList = new ArrayList<User>();
	
	/**
	 * TODO Create one user and put the new user into 
	 * the map called userMap.
	 * @param userName
	 * @param password
	 * @return new created user.
	 */	
	public boolean register(String userName, String password) {
		if (userMap.get(userName) == null) {
			User user = new User(userName, password);	
			this.userMap.put(userName, user);	
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Exit the system.
	 * @param userName
	 * @return
	 */
	public boolean offLine(String userName) {
		User user = userMap.get(userName);
		
		if(user != null) {
			user.setStatus(Const.USER_OFFLINE);
			onlineList.remove(user);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Login the system.
	 * @param userName
	 * @param password
	 * @return
	 */
	public  User login(String userName,String password){
		User user = this.userMap.get(userName);
		if (user != null) {
			if(password.equals(user.getPassword())) {
				onlineList.add(user);
				user.setLastOnlineTime(new GregorianCalendar());
				user.setStatus(Const.USER_ONLINE);
				user.setLoginTimes(user.getLoginTimes() + 1);
				return user;
			}
		}
		return null;	
	}

	public Map<String, User> getUserMap() {
		return userMap;
	}

	public List<User> getOnlineList() {
		return onlineList;
	}
	
	
}
