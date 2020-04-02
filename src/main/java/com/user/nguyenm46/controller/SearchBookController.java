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
import com.user.nguyenm46.model.BookUser;

@Controller
@SessionAttributes("bookuser")
public class SearchBookController {

	@Autowired
	BookUserDao bookuserDao;
	
	@Autowired 
	BookDao bookDao;
	
	@ModelAttribute("book")
	public Book searchBook() {
		return new Book();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/searchBook")
	public String showCourses(HttpSession session, Model model) {
	    BookUser bookuser = (BookUser) session.getAttribute("bookuser");
	    if(bookuser != null) {
	    	List<Book> books = bookDao.findAll();
	    	model.addAttribute("books", books);
	    	return "search-result";
	    }
	    return "login";
	}
	
	@PostMapping("/addToBooklist")
	public String register(HttpSession session, @ModelAttribute("book") Book book, Model model) {
		BookUser bookuser = (BookUser) session.getAttribute("bookuser");
		String code = book.getCode();
		
		for(Book c : bookuser.getBooklist()) {
			if(c.getCode().equals(code)) {
				model.addAttribute("message", "Book added to your booklist!");
				return "redirect:searchResult";
			}
		}
		
		if(bookuserDao.registerBookByBookCode(bookuser.getEmail(), code) > 0) {
			bookuser.setBooklist(bookuserDao.findRegisteredBooks(bookuser.getEmail()));
		}
		
		return "redirect:login";
	}
	
}
