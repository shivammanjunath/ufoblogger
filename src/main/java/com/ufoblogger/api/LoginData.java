package com.ufoblogger.api;

public class LoginData {
	
	private String loginEmail;
	private String loginPassword;

	public LoginData() {
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String toString() {
		return ("Email " + loginEmail + " & Password " + loginPassword);
	}
}
