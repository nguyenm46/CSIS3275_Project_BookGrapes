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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.user.nguyenm46.dao.BookDao;
import com.user.nguyenm46.dao.BookUserDao;
import com.user.nguyenm46.dao.PublisherDao;
import com.user.nguyenm46.model.Book;
import com.user.nguyenm46.model.BookInfo;
import com.user.nguyenm46.model.BookUser;
import com.user.nguyenm46.model.Publisher;
import com.user.nguyenm46.model.ReviewInfo;

//Hsueh-Cheng Liu 300280496 

@Controller
@SessionAttributes("bookuser")
public class AddBookReviewController {

	@Autowired
	BookDao bookDao;
	@Autowired
	BookUserDao bookuserDao;

	/**
	 * Create new setRegisterNewBookForm object for empty from
	 * 
	 * @return
	 */
	@ModelAttribute("newReview")
	public ReviewInfo setBookReview() {
		return new ReviewInfo();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/addReview")
	public String showWriteReview(Model model,HttpServletRequest request) {
		String booktitle = request.getParameter("booktitle");
		model.addAttribute("booktitle",booktitle);
//		model.addAttribute(attributeValue)
		System.out.println(booktitle);
		return "addreview";
	}

	/**
	 * Save new review form
	 * 
	 * @param signUpForm
	 * @param model
	 * @return
	 */
	@PostMapping("/addReview")
	public String saveBook(@ModelAttribute("newReview") ReviewInfo reviewInfo, Model model, HttpSession session,
			HttpServletRequest request) {
//		String code = request.getParameter("bookcode");
		String booktitle = reviewInfo.getBooktitle();
		System.out.println(booktitle);
		// Implement business logic to save user details into a database
		// .....

		System.out.println("BookReview : " + reviewInfo.getReview());
		System.out.println("BookCode : " + reviewInfo.getBooktitle());

//		List<Book> books = bookDao.findAll();
//
//		System.out.println(books);
//
//		model.addAttribute("review", books);

//		model.addAttribute("message", "User SignUp successfully.");
//		model.addAttribute("user", user);

		// insert info to sql
		BookUser bookuser = (BookUser) session.getAttribute("user");
		Book book = bookDao.findByTitle(booktitle);
		boolean result = bookDao.addBookReview(book.getCode(), bookuser.getEmail(), reviewInfo.getReview());
		model.addAttribute("msg", "Welcome back " + bookuser.getUsername());
		if (result)
			model.addAttribute("message", "<script>alert('Successed add new review!')</script>");
		else
			model.addAttribute("message", "<script>alert('Successed add new review!')</script>");

		return "bookuser-home";
	}
	
	
	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/readReview")
	public String showReadReview(Model model,HttpServletRequest request) {
		String bookcode = request.getParameter("bookcode");
		List<String> reviews = bookDao.searchUserReview(bookcode);
		model.addAttribute("reviews",reviews);
//		model.addAttribute(attributeValue)
		System.out.println(reviews);
		return "readreview";
	}

}
