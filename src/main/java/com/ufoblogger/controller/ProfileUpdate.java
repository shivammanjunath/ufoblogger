package com.ufoblogger.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ufoblogger.api.RequestStatus;
import com.ufoblogger.api.Update;
import com.ufoblogger.logic.UpdateProfile;

@Path("update")
public class ProfileUpdate {

	public ProfileUpdate() {
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public Response updateProfile(Update user) {
		
		System.out.println("*** Update request received ***");
		
		new UpdateProfile().updateProfile(user);
		
		return Response.ok().entity(new RequestStatus(true)).build();
	}


}
