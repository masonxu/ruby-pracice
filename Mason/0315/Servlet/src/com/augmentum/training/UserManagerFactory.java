package com.augmentum.training;

public class UserManagerFactory {
	private static UserManager userManager = null;
	
	public static UserManager getUserManager() {
		if (userManager != null) {
			return userManager;
		} else {
			return new UserManager();
		}
	}
}
