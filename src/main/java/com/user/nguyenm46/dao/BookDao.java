package com.user.nguyenm46.dao;

import java.util.List;

import com.user.nguyenm46.model.Book;

//Hsueh-Cheng Liu 300280496 

public interface BookDao {

	Book findByCode(String code);
	Book findByTitle(String booktitle);
	
	List<Book> findAll();
	
	boolean addBook(Book book, String size);
	
	boolean editbook(Book book);
	
	boolean addBookReview(String code, String email, String review);
	
	List<String> searchUserReview(String code);
}
