package com.ufoblogger.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.model.Filters;
import com.ufoblogger.api.Article;
import com.ufoblogger.api.SearchQuery;
import com.ufoblogger.handler.UserActivity;

public class ReadArticles {
	
	private List<Document> queryDocuments;

	public ReadArticles() {
	}

	public List<Article> getAllArticles() {
		return UserActivity.getInstance().fetchArticles("");
	}
	
	public List<Article> fetchArticles(SearchQuery query) {
		List<Article> articles = new ArrayList<>();
		
		return articles;
	}
	
	private void parseQuery(SearchQuery query) {
		
		List<Document> documents = new ArrayList();
		
	}
	
}
