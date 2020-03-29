package com.user.wongi5.dao;

import java.util.List;

import com.user.wongi5.model.Book;
import com.user.wongi5.model.BookUser;
import com.user.wongi5.model.User;

public interface BookUserDao {
	
	BookUser findByEmail(String email);

	int registerBookByBookCode(String email, String code);

	List<Book> findRegisteredBooks(String email);
	
	List<BookUser> findAll();
	
	boolean addBookUser(BookUser BookUser);
}
