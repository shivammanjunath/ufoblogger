package com.ufoblogger.handler;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteConcernException;
import com.mongodb.MongoWriteException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ufoblogger.api.Article;
import com.ufoblogger.api.BlogUser;
import com.ufoblogger.api.LoginData;

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
		collection = mongoDatabase.getCollection(MONGO_DB_COLLECTION_ARTICLES);
		AggregateIterable<Document> articles;
		articles = collection.aggregate(Arrays.asList(
				new Document("$sort", new Document("datetime", -1))));
		
		List<Article> articlesList = new ArrayList<>();
		for (Document document : articles) {
			Article newArticle = new Article();
			newArticle.set_id(document.get("_id").toString());
			newArticle.setAuthorId(document.get("author_id").toString());
			newArticle.setCategory(document.getString("category"));
			newArticle.setDateTime(document.getLong("datetime"));
			newArticle.setDescription(document.getString("description"));
			newArticle.setTitle(document.getString("title"));
			newArticle.setTags(document.getString("tags"));
			
			String fullName = "";
			Document nameDocument = findUserById(newArticle.getAuthorId());
			if ( nameDocument != null) {
				fullName = nameDocument.getString("fullname");
			}
			newArticle.setAuthorFullName(fullName);
			
			articlesList.add(newArticle);
		}
		return articlesList;
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
	
	@Override
	public void writeArticle(Article article) {
		collection = mongoDatabase.getCollection(MONGO_DB_COLLECTION_ARTICLES);
		collection.insertOne(new Document()
				.append("title", article.getTitle())
				.append("datetime", article.getDateTime())
				.append("author_id", new ObjectId(article.getAuthorId()))
				.append("description", article.getDescription())
				.append("category", article.getCategory())
				.append("tags", article.getTags())
				);
	}
	
	@Override
	public void updateUserInfo(String fullName, String _id) {
		System.out.println("*** User activity updateUser " + fullName + " id : " + _id);
		collection = mongoDatabase.getCollection(MONGO_DB_COLLECTION_USERS);
		
		Bson filter = new Document().append("_id", new ObjectId(_id));
		Bson update = new Document()
				.append("fullname", fullName);
				
		try {
			collection.updateOne(filter, update);
		} catch (MongoWriteException excp) {
			System.out.println("" + excp.getMessage());
		} catch (MongoWriteConcernException excp ) {
			System.out.println("" + excp.getMessage());
		} catch (MongoException excp) {
			System.out.println("" + excp.getMessage());
		}
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
	
	private Document findUserById(String id) {
		MongoCollection<Document> tempCollection = mongoDatabase.getCollection(MONGO_DB_COLLECTION_USERS);
		Bson filter = new Document("_id", new ObjectId(id));
		Bson projection = new Document()
				.append("email",0)
				.append("phone", 0)
				.append("interest", 0)
				.append("password", 0);
		return tempCollection.find(filter).projection(projection).first();
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
