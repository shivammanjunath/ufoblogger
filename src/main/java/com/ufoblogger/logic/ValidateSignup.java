package com.ufoblogger.logic;

import com.ufoblogger.api.BlogUser;
import com.ufoblogger.api.SignUpInfo;
import com.ufoblogger.exceptions.AccountExists;
import com.ufoblogger.handler.UserActivity;

public class ValidateSignup {

	public ValidateSignup() {
		
	}
	
	public SignUpInfo createNewAccount(BlogUser blogUser) {
		
		int status = UserActivity.getInstance().createNewUserAccount(blogUser);
		
		SignUpInfo singupInfo;
		
		if ( status == 0 ) {
			singupInfo = new SignUpInfo(true, "Signed up successfully, you can login now!");
		} else {
			singupInfo = new SignUpInfo(false, "Account already exists, please Login!");
		}
		
		return singupInfo;
	}

}
