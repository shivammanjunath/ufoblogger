package com.ufoblogger.controller;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ufoblogger.api.Article;
import com.ufoblogger.api.ArticleDataPrimary;
import com.ufoblogger.api.RequestStatus;
import com.ufoblogger.logic.PublishArticle;

@Path("publish")
public class ArticlePublishing {

	public ArticlePublishing() {
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/new")
	public Response publishArticle(ArticleDataPrimary article) {
		
		System.out.println("*** ArticlePublishing.publishArticle ***");
		
		Article tempArticle = new Article(
				article.getTitle(), 
				article.getAuthorId(),
				article.getCategory(),
				article.getDescription());
		
		tempArticle.setDateTime(Calendar.getInstance().getTimeInMillis());
		tempArticle.setTags(article.getTags());
		
		PublishArticle publish = new PublishArticle();
		publish.saveArticle(tempArticle);
		
		RequestStatus rs = new RequestStatus();
		rs.setRequestStatus(true);
		return Response.ok().entity(rs).build();
	}
}
