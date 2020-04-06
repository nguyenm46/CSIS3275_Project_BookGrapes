package com.user.nguyenm46.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
// Khue Nguyen 300300461 / Hsueh-Cheng Liu 300280496 

@Controller
public class SearchBookController {

	@Autowired
	BookDao bookDao;
	@Autowired
	BookUserDao bookuserDao;

	@ModelAttribute("bookInfo")
	public BookInfo searchBook() {
		return new BookInfo();
	}

	@ModelAttribute("book")
	public Book addToBookList() {
		return new Book();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/searchBook")
	public String searchBook(HttpSession session) {
		return "search-book";
	}

	@PostMapping("/searchBook")
	public String login(@ModelAttribute("bookInfo") BookInfo bookInfo, Model model) {
		Book book = bookDao.findByTitle(bookInfo.getBooktitle());
		model.addAttribute("message", " - Book not found");

		if (book != null) {
			model.addAttribute("book", book);
			System.out.println(book.getAuthor());
			System.out.println(book.getPublishedyear());
			return "search-result";
		}

		return "search-book";
	}

	@GetMapping("/addToBooklist")
	public String addToList(HttpSession session, @ModelAttribute("book") Book book, Model model,
			HttpServletRequest request) {
		BookUser bookuser = (BookUser) session.getAttribute("user");
		String code = request.getParameter("bookcode");

		for (Book c : bookuser.getBooklist()) {
			if (c.getCode().equals(code)) {
				model.addAttribute("message", "Book is already in your booklist!");
				return "redirect:bookuser-home";
			}
		}

		boolean result = bookuserDao.registerBookByBookCode(bookuser.getEmail(), code);
		model.addAttribute("msg", "Welcome back " + bookuser.getUsername());
		if (result)
			model.addAttribute("message", "<script>alert('Successed add to booklist!')</script>");
		else
			model.addAttribute("message", "<script>alert('Successed add to booklist!')</script>");

		return "bookuser-home";
	}

}
