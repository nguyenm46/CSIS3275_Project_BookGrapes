package com.user.nguyenm46.dao;

import java.util.List;

import com.user.nguyenm46.model.Book;
import com.user.nguyenm46.model.Publisher;
//Hsueh-Cheng Liu 300280496 

public interface PublisherDao {
	
	Publisher findByEmail(String email);
	
	int publishedBookByBookCode(String email, String code);
	
	List<Book> findPublishedBooks(String email);

	List<Publisher> findAll();
	
	boolean addPublisher(Publisher publisher);
}
