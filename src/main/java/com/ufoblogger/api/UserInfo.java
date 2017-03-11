package com.ufoblogger.api;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

public class UserInfo {

	private String _id;
	private String userFullName;
	private String userInterest;
	private String userToken;
	private String errorMessage;
	private boolean loginStatus;
	
	public UserInfo() {
	}

	public UserInfo(String userFullName, String userInterest, String userToken) {
		super();
		
		this.userFullName = userFullName;
		this.userInterest = userInterest;
		this.userToken = userToken;
	}

	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserInterest() {
		return userInterest;
	}

	public void setUserInterest(String userInterest) {
		this.userInterest = userInterest;
	}

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String toString() {
		return ("User : " + userFullName + " : Interested in " + userInterest);
	}
	
}
