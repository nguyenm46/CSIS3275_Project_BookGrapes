package com.user.wongi5.dao;

import java.util.List;

import com.user.wongi5.model.Book;

public interface BookDao {

	Book findByCode(String name);
	
	List<Book> findAll();
}
