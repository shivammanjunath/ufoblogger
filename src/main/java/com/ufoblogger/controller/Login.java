package com.ufoblogger.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ufoblogger.api.LoginData;
import com.ufoblogger.api.UserInfo;
import com.ufoblogger.exceptions.AccountNotFoundException;
import com.ufoblogger.exceptions.InvalidLoginCredentialsException;
import com.ufoblogger.logic.ValidateLogin;

@Path("signin")
public class Login {

	public Login() {
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public Response performLogin(LoginData loginData) {
		
		UserInfo userInfo = null;
		
		ValidateLogin login = new ValidateLogin();

		userInfo = login.performLogin(loginData);
		
		if ( userInfo.getUserToken().equals("Invalid Password") ) {
			userInfo.setErrorMessage("Invalid login credentials!");
			InvalidLoginCredentialsException excp = new InvalidLoginCredentialsException();
			excp.setEntity(userInfo);
			throw excp;
		} else if ( userInfo.getUserToken() == "" ) {
			userInfo.setErrorMessage("Account not found, signup to create a new account");
			//throw new AccountNotFoundException();
		}

		
		return Response.ok().entity(userInfo).build();
	}

}
