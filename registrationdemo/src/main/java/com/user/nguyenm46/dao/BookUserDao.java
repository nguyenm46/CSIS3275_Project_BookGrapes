package com.user.nguyenm46.dao;

import java.util.List;

import com.user.nguyenm46.model.Book;
import com.user.nguyenm46.model.BookUser;
import com.user.nguyenm46.model.User;

public interface BookUserDao {
	
	BookUser findByEmail(String email);

	int registerBookByBookCode(String email, String code);

	List<Book> findRegisteredBooks(String email);
	
	List<BookUser> findAll();
	
	boolean addBookUser(BookUser BookUser);
}