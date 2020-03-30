package com.user.nguyenm46.dao;

import java.util.List;

import com.user.nguyenm46.model.Book;

//Hsueh-Cheng Liu 300280496 

public interface BookDao {

	Book findByCode(String name);
	
	List<Book> findAll();
	
	boolean addBook(Book book, String size);
}
