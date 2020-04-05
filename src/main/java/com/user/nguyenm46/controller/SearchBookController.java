package com.user.nguyenm46.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.user.nguyenm46.dao.BookDao;
import com.user.nguyenm46.dao.BookUserDao;
import com.user.nguyenm46.model.Book;
import com.user.nguyenm46.model.BookInfo;
import com.user.nguyenm46.model.BookUser;
import com.user.nguyenm46.model.LoginInfo;
import com.user.nguyenm46.model.Publisher;

@Controller
//@SessionAttributes("book")
public class SearchBookController {

	@Autowired 
	BookDao bookDao;
	
	@ModelAttribute("bookInfo")
	public BookInfo searchBook() {
		return new BookInfo();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/searchBook")
	public String searchBook(HttpSession session)  {
//		Book book = (Book) session.getAttribute("book");
//	    if(book != null) {
//	    	return "search-result";
//	    }
	    return "search-book";	
	}
	
	@PostMapping("/searchBook")
	public String login(@ModelAttribute("bookInfo") BookInfo bookInfo, Model model) {
		Book book = bookDao.findByTitle(bookInfo.getBooktitle());
		model.addAttribute("message", " - Book not found");
		
		if (book != null ) {
			//&& book.getBooktitle().equals(bookInfo.getBooktitle())
			model.addAttribute("book", book);
			System.out.println(book.getAuthor());
			System.out.println(book.getPublishedyear());
			return "search-result";
		} 

		return "search-book";
	}
	/*@GetMapping("/searchResult")
	public String showBooks(HttpSession session, Model model) {
	    BookUser bookuser = (BookUser) session.getAttribute("bookuser");
	    if(bookuser != null) {
	    	List<Book> books = bookDao.findAll();
	    	model.addAttribute("books", books);
	    	return "search-result";
	    }
	    return "login";
	}*/
	
	@PostMapping("/addToBooklist")
	public String addToList(HttpSession session, @ModelAttribute("book") Book book, Model model) {
		BookUser bookuser = (BookUser) session.getAttribute("bookuser");
		String code = book.getCode();
		
		for(Book c : bookuser.getBooklist()) {
			if(c.getCode().equals(code)) {
				model.addAttribute("message", "Book is already in your booklist!");
				return "redirect:bookuser-home";
			}
		}
		
		/*if(BookUserDao.registerBookByBookCode(bookuser.getEmail(), code) > 0) {
			bookuser.setBooklist(bookuserDao.findRegisteredBooks(bookuser.getEmail()));
		}*/
		
		return "redirect:login";
	}
	
}
