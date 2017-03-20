package com.ufoblogger.logic;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ufoblogger.api.Article;
import com.ufoblogger.handler.UserActivity;

public class PublishArticle {

	public PublishArticle() {

	}

	public void saveArticle(Article article) {
		UserActivity.getInstance().writeArticle(article);
	}
}
