package com.user.nguyenm46.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.user.nguyenm46.dao.BookDao;
import com.user.nguyenm46.model.Book;

@Controller
@SessionAttributes("user")
public class ManagePublishedBooksController {
	
	@Autowired 
	BookDao bookDao;


	/**
	 * Create edit book
	 * 
	 * @return
	 */
	@ModelAttribute("showpublishedbook")
	public Book registerForm() {
		return new Book();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/showPublishedBooks")
	public String showCourses() {
		return "show-published-books";
	}

	@PostMapping("/show-published-books")
	public String register(HttpSession session, @ModelAttribute("showpublishedbook") Book book, Model model) {
		String code = book.getCode();

		/*
		 * for (Book b : publisher.getBooklist()) { if (b.getCode().equals(code)) {
		 * //model.addAttribute("message", "Course already registered."); return
		 * "redirect:showCourses"; } }
		 * 
		 * if (studentDao.registerCourseByCourseCode(student.getEmail(), code) > 0) {
		 * student.setRegisteredCourses(studentDao.findRegisteredCourses(student.
		 * getEmail())); }
		 */

		return "edit-book?param="+code;
	}
}
