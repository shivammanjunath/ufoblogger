package com.ufoblogger.handler;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.auth.login.AccountException;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ufoblogger.api.Article;
import com.ufoblogger.api.BlogUser;
import com.ufoblogger.api.LoginData;
import com.ufoblogger.exceptions.AccountExists;

public class UserActivity implements ILocalOperations {
	
	private String MONGO_SERVER_PUBLIC_IP = "104.154.207.93";
	private int MONGO_SERVER_PORT_NUMBER = 27017;
	
	private String MONGO_DATABASE_NAME = "ufoblogger";
	private String MONGO_DB_COLLECTION_USERS = "users";
	private String MONGO_DB_COLLECTION_ARTICLES = "articles";
	
	private static ILocalOperations CLASS_INSTANCE = new UserActivity();
	
	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	private MongoCollection<Document> collection;

	private UserActivity() {
		initMongoDB();
	}
	
	public static ILocalOperations getInstance() {
		return CLASS_INSTANCE;
	}
	
	private void initMongoDB() {
		mongoClient = new MongoClient(MONGO_SERVER_PUBLIC_IP, MONGO_SERVER_PORT_NUMBER);
		mongoDatabase = mongoClient.getDatabase(MONGO_DATABASE_NAME);
	}
	
	@Override
	public Document performLogin(LoginData loginData) {
		Document user = findUserInDB(loginData.getLoginEmail());
		return user;
	}

	@Override
	public List<Article> fetchArticles(String type) {
		return null;
	}

	@Override
	public int createNewUserAccount(BlogUser newUser) {
		
		int addStatus = 0;
		
		if ( findUserInDB(newUser.getUserEmail()) != null ) {
			addStatus = -1;
		} else {
		
			collection.insertOne(new Document()
					.append("email", newUser.getUserEmail())
					.append("password", newUser.getLoginPassword())
					.append("fullname", newUser.getUserFullName())
					.append("phone", newUser.getUserPhoneNumber())
					.append("interest", newUser.getUserInterestCategory())
					);
		}
		
		return addStatus;
	}
	
	public void writeArticle(Article article) {
		collection = mongoDatabase.getCollection(MONGO_DB_COLLECTION_ARTICLES);
		collection.insertOne(new Document()
				.append("title", article.getTitle())
				.append("datetime", article.getDateTime())
				.append("author_id", new ObjectId(article.getAuthor()))
				);
	}
	
	@Override
	public String getUserToken(String userData) {
		String token = "";
		long currentDateTime = Calendar.getInstance().getTimeInMillis() + (900000);
		token = tokenEncoder(userData + "<|>" + Long.toString(currentDateTime)); 
		return token;
	}
	
	@Override
	public String getDecodedToken(String token) {
		return tokenDecoder(token);
	}
	
	private Document findUserInDB(String email) {
		collection = mongoDatabase.getCollection(MONGO_DB_COLLECTION_USERS);
		
		Bson filter = new Document("email", email);
		Bson projection = new Document().append("email", 0).append("phone", 0);
		return collection.find(filter)
				.projection(projection)
				.first();
	}
	
	
	private String tokenEncoder(String toEncode) {
		String encoded = "";
		try {
			encoded = Base64.getEncoder().encodeToString(toEncode.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			
			System.out.println("****** UnsupportedEncodingException ******");
			//e.printStackTrace();
		}
		
		return encoded;
	}
	
	private String tokenDecoder(String token) {
		byte[] bytes = Base64.getDecoder().decode(token);
		return bytes.toString();
	}
}
