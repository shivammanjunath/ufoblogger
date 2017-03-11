package com.ufoblogger.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ufoblogger.api.BlogUser;
import com.ufoblogger.api.SignUpInfo;
import com.ufoblogger.logic.ValidateSignup;

@Path("signup")
public class Signup {

	public Signup() {
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public Response createNewAccount(BlogUser blogUser) {
		
		SignUpInfo entity = new ValidateSignup().createNewAccount(blogUser);
		
		return Response.ok().entity(entity).build();
	}
}
