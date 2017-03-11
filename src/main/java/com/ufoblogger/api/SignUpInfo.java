package com.ufoblogger.api;

public class SignUpInfo {

	private boolean signupStatus;
	private String errorMessage;
	
	public SignUpInfo() {
	}

	public SignUpInfo(boolean signupStatus, String errorMessage) {
		super();
		this.signupStatus = signupStatus;
		this.errorMessage = errorMessage;
	}

	public boolean isSignupStatus() {
		return signupStatus;
	}

	public void setSignupStatus(boolean signupStatus) {
		this.signupStatus = signupStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
