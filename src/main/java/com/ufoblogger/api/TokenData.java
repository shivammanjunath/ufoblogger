package com.ufoblogger.api;

public class TokenData {
	
	private String loginToken;
	private String userId;

	public TokenData() {
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
