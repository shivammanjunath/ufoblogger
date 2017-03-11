package com.ufoblogger.api;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class BlogUser {

	@Id
	private String userEmail;
	private String userFullName;
	private String loginPassword;
	private String userPhoneNumber;
	private String userInterestCategory;
	
	public BlogUser() {
		
	}
	
	public BlogUser(String userFullName, String userEmail, String loginPassword, String userPhoneNumber, String userInterestCategory) {
		super();
		this.userFullName = userFullName;
		this.userEmail = userEmail;
		this.loginPassword = loginPassword;
		this.userPhoneNumber = userPhoneNumber;
		this.userInterestCategory = userInterestCategory;
	}
	
	public String getUserFullName() {
		return userFullName;
	}	

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserInterestCategory() {
		return userInterestCategory;
	}

	public void setUserInterestCategory(String userInterestCategory) {
		this.userInterestCategory = userInterestCategory;
	}

}
