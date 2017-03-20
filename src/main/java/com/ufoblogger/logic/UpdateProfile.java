package com.ufoblogger.logic;

import com.ufoblogger.api.Update;
import com.ufoblogger.handler.UserActivity;

public class UpdateProfile {

	public UpdateProfile() {
	}

	public void updateProfile(Update user) {
		
		System.out.println("*** UpdateProfile.updateProfile() ***");
		
		UserActivity.getInstance().updateUserInfo(user.getFullName(), user.getId());
		
	}
}
