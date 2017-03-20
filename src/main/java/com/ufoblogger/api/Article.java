package com.ufoblogger.api;

public class Article {
	
	private long dateTime;
	private String _id;
	private String title;
	private String authorId;
	private String category;
	private String description;
	private String tags;
	private String authorFullName;

	public Article() {

	}
	
	public Article(String title, String author, String category, String description) {
		super();
		this.title = title;
		this.authorId = author;
		this.category = category;
		this.description = description;
	}
	
	public Article(String title, String author, String category, String description, long dateTime) {
		super();
		this.title = title;
		this.authorId = author;
		this.category = category;
		this.description = description;
		this.dateTime = dateTime;
	}

	public Article(long dateTime, String title, String authorId, String category, String description,
			String tags) {
		super();
		this.dateTime = dateTime;
		this.title = title;
		this.authorId = authorId;
		this.category = category;
		this.description = description;
		this.tags = tags;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
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

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getAuthorFullName() {
		return authorFullName;
	}

	public void setAuthorFullName(String authorFullName) {
		this.authorFullName = authorFullName;
	}

	public String toString() {
		return (title + " / " + authorId + " / " + category + " / " + Long.toString(dateTime) + " / " + description);
	}
}
