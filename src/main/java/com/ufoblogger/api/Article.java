package com.ufoblogger.api;

public class Article {
	
	private long _id;
	private long dateTime;
	private String title;
	private String authorId;
	private String category;
	private String description;

	public Article() {

	}
	
	public Article(String title, String author, String category, String description, long dateTime) {
		super();
		this.title = title;
		this.authorId = author;
		this.category = category;
		this.description = description;
		this.dateTime = dateTime;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return authorId;
	}

	public void setAuthor(String author) {
		this.authorId = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
