package com.ufoblogger.logic;

import org.bson.Document;

import com.ufoblogger.api.BlogUser;
import com.ufoblogger.api.LoginData;
import com.ufoblogger.api.UserInfo;
import com.ufoblogger.handler.ILocalOperations;
import com.ufoblogger.handler.UserActivity;

public class ValidateLogin {

	public ValidateLogin() {
	}

	public UserInfo performLogin(LoginData loginData) {
		
		UserInfo userInfo = new UserInfo("", "", "");

		Document user = UserActivity.getInstance().performLogin(loginData);
		
		if ( user != null ) {
			System.out.println("*** ValidateLogin : User Found ***");
			String password = user.getString("password");
			
			System.out.println("*** Password in DB " + password + " ***");
			System.out.println("*** User provided " + loginData.getLoginPassword() + " ***");
			
			if ( password.equals(loginData.getLoginPassword()) ) {
				userInfo.set_id(user.get("_id").toString());
				userInfo.setUserToken(UserActivity.getInstance().getUserToken(user.getString("fullname")));
				userInfo.setUserFullName(user.getString("fullname"));
				userInfo.setUserInterest(user.getString("interest"));
				userInfo.setLoginStatus(true);
				System.out.println("*** UserInfo (" + userInfo.get_id() + ") is updated for Response ***");
			} else {
				userInfo.setUserToken("Invalid Password");
				userInfo.setLoginStatus(false);
			}
		} else {
			System.out.println("*** ValidateLogin : User NOT Found ***");
			userInfo.setLoginStatus(false);
		}

		return userInfo;
	}
}
