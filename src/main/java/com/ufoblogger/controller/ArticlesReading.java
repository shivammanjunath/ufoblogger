package com.ufoblogger.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ufoblogger.api.SearchQuery;

@Path("readarticles")
public class ArticlesReading {

	public ArticlesReading() {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/public")
	public Response fetchHomePageArticles() {
		
		System.out.println("****** REQUEST RECEIVED AT THE SERVER ******");
		
		return Response.ok().entity("OK").build();
	}

}
