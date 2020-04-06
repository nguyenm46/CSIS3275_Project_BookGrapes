package com.user.nguyenm46.dao;

import java.util.List;

import com.user.nguyenm46.model.Book;
import com.user.nguyenm46.model.BookUser;
//Hsueh-Cheng Liu 300280496 

public interface BookUserDao {
	
	BookUser findByEmail(String email);

	boolean registerBookByBookCode(String email, String code);

	List<Book> findRegisteredBooks(String email);
	
	List<BookUser> findAll();
	
	boolean addBookUser(BookUser BookUser);
}
