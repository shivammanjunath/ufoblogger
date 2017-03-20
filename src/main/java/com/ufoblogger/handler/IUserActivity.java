package com.ufoblogger.handler;

import java.util.List;

import org.bson.Document;

import com.ufoblogger.api.Article;
import com.ufoblogger.api.BlogUser;
import com.ufoblogger.api.LoginData;

public interface IUserActivity {
	
	int createNewUserAccount(BlogUser newUser);
	
	Document performLogin(LoginData loginData);
	
	List<Article> fetchArticles(String type);

	void writeArticle(Article article);
	
	void updateUserInfo(String fullName, String _id);
}
