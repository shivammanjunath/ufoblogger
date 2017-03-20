package com.ufoblogger.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ufoblogger.api.SearchQuery;
import com.ufoblogger.logic.ReadArticles;

@Path("readarticles")
public class ArticlesReading {

	public ArticlesReading() {
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/public")
	public Response fetchHomePageArticles() {
		
		System.out.println("****** REQUEST RECEIVED AT THE SERVER fetchHomePageArticles ******");
		
		ReadArticles readArticles = new ReadArticles();
		
		return Response.ok().entity(readArticles.getAllArticles()).build();
	}

}
