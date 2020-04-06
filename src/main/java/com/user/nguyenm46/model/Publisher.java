package com.user.nguyenm46.model;

import java.util.List;

//Hsueh-Cheng Liu 300280496 

public class Publisher {
	private String email;
	private String name;
	private String password;
	private List<Book> booklist;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

}
