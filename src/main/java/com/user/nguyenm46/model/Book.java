package com.user.nguyenm46.model;

//Hsueh-Cheng Liu 300280496 

public class Book {
	private String code;
	private String booktitle;
	private String author;
	private String publishedyear;
	private String bookreview;
	
	
	public String getBookreview() {
		return bookreview;
	}
	public void setBookreview(String bookreview) {
		this.bookreview = bookreview;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishedyear() {
		return publishedyear;
	}
	public void setPublishedyear(String publishedyear) {
		this.publishedyear = publishedyear;
	}
}
