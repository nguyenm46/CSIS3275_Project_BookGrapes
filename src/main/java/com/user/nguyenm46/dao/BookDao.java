package com.user.nguyenm46.dao;

import java.util.List;

import com.user.nguyenm46.model.Book;

public interface BookDao {

	Book findByCode(String name);
	
	List<Book> findAll();
}
