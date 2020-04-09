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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.user.nguyenm46.dao.BookDao;
import com.user.nguyenm46.dao.PublisherDao;
import com.user.nguyenm46.model.Book;
import com.user.nguyenm46.model.BookUser;
import com.user.nguyenm46.model.Publisher;
//Hsueh-Cheng Liu 300280496 

@Controller
@SessionAttributes("user")
public class ManagePublishedBooksController {

	@Autowired
	BookDao bookDao;
	@Autowired
	PublisherDao publisherDao;

	/**
	 * Create show published book
	 * 
	 * @return
	 */
	@ModelAttribute("showpublishedbook")
	public Book registerForm() {
		return new Book();
	}

	/**
	 * Create edit book
	 * 
	 * @return
	 */
	@ModelAttribute("ebook")
	public Book editBookForm() {
		return new Book();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/showPublishedBooks")
	public String showCourses(HttpSession session, Model model) {
		Publisher publisher = (Publisher) session.getAttribute("user");
		if (publisher != null) {
			List<Book> books = publisherDao.findPublishedBooks(publisher.getEmail());
			model.addAttribute("books", books);
			return "show-published-books";
		}
		return "show-published-books";
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/edit-book")
	public String showCourses(Model model, HttpServletRequest request) {
		String bookcode = request.getParameter("bookcode");
		model.addAttribute("bookcode", bookcode);
		return "edit-book";
	}

	@PostMapping("/editBook")
	public String editbook(@ModelAttribute("ebook") Book book, Model model, HttpSession session) {
		Publisher publisher = (Publisher) session.getAttribute("user");
		String code = book.getCode();
		boolean result = bookDao.editbook(book);
		model.addAttribute("msg", "Welcome back " + publisher.getName());
		if (result)
			model.addAttribute("message", "<script>alert('Successfully edited book info!')</script>");
		else
			model.addAttribute("message", "<script>alert('NOT successfully edited book info!')</script>");
		return "publisher-home";
	}

	@RequestMapping("/publisherhome")
	public String handlerHome(HttpSession session, Model model) {
		Publisher publisher = (Publisher) session.getAttribute("user");
		model.addAttribute("msg", "Welcome back " + publisher.getName());
		return "publisher-home";
	}
}
