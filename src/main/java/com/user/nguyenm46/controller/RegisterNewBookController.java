package com.user.nguyenm46.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.nguyenm46.dao.BookDao;
import com.user.nguyenm46.model.Book;
//Hsueh-Cheng Liu 300280496 

@Controller
public class RegisterNewBookController {
	
	@Autowired
	BookDao bookDao;

	/**
	 * Create new setRegisterNewBookForm object for empty from
	 * 
	 * @return
	 */
	@ModelAttribute("newbook")
	public Book setRegisterNewBookForm() {
		return new Book();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/showRegisterNewBook")
	public String showSignUpFormPub() {
		return "registernewbook";
	}

	/**
	 * Save new book form
	 * 
	 * @param signUpForm
	 * @param model
	 * @return
	 */
	@PostMapping("/saveRegisterNewBook")
	public String saveBook(@ModelAttribute("newbook") Book book, Model model) {

		// Implement business logic to save user details into a database
		// .....

		System.out.println("Booktitle : " + book.getBooktitle());
		System.out.println("Author : " + book.getAuthor());
		System.out.println("Publishedyear : " + book.getPublishedyear());

		List<Book> books = bookDao.findAll();

		System.out.println(books);

		model.addAttribute("books", books);

//		model.addAttribute("message", "User SignUp successfully.");
//		model.addAttribute("user", user);

		// insert info to sql
		
		boolean result = bookDao.addBook(book,String.valueOf(books.size()));
		
		if (result)
			model.addAttribute("message", "<script>alert('Successed add new book!')</script>");
		else
			model.addAttribute("message", "<script>alert('Successed add new book!')</script>");

		return "home";
	}
	

}
