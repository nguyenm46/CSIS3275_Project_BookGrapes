package com.user.nguyenm46.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.user.nguyenm46.dao.BookDao;
import com.user.nguyenm46.dao.BookUserDao;
import com.user.nguyenm46.model.Book;
import com.user.nguyenm46.model.BookInfo;
import com.user.nguyenm46.model.BookUser;

// Hsueh-Cheng Liu 300280496 
@Controller
@SessionAttributes("user")
public class ShowUserBooklistController {

	@Autowired
	BookUserDao bookuserDao;
	@Autowired
	BookDao bookDao;

	@ModelAttribute("showbooks")
	public BookUser searchBook() {
		return new BookUser();
	}

	@GetMapping("/showUserBooklists")
	public String showUserBooklist(HttpSession session, Model model) {
		BookUser bookuser = (BookUser) session.getAttribute("user");

		if (bookuser != null) {
			List<Book> books = bookuserDao.findRegisteredBooks(bookuser.getEmail());
			for (int i = 0; i < books.size(); i++) {
				Book bookInfo = bookDao.findByCode(books.get(i).getCode());
				books.set(i, bookInfo);
			}
			model.addAttribute("books", books);

			return "show-user-booklists";
		}
		return "show-user-booklists";
	}

	@RequestMapping("/userhome")
	public String handlerHome(HttpSession session, Model model) {
		BookUser bookuser = (BookUser) session.getAttribute("user");
		model.addAttribute("msg", "Welcome back " + bookuser.getUsername());
		return "bookuser-home";
	}
}