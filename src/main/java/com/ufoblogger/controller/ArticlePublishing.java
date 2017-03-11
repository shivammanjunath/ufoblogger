package com.ufoblogger.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ufoblogger.api.Article;

@Path("publish")
public class ArticlePublishing {

	public ArticlePublishing() {
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/new")
	public Response publishArticle(Article article) {
		
		return Response.ok().entity("OK").build();
	}
}
