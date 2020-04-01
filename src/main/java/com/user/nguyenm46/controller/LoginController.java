package com.user.nguyenm46.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.user.nguyenm46.dao.BookUserDao;
import com.user.nguyenm46.dao.PublisherDao;
import com.user.nguyenm46.dao.StudentDao;
import com.user.nguyenm46.model.BookUser;
import com.user.nguyenm46.model.LoginInfo;
import com.user.nguyenm46.model.Publisher;
import com.user.nguyenm46.model.Student;
//Hsueh-Cheng Liu 300280496 

@Controller
@SessionAttributes("bookuser")
public class LoginController {

	//(required = false)
	@Autowired 
	BookUserDao bookuserDao;
	@Autowired
	PublisherDao publisherDao;

	/**
	 * Create new signUpForm object for empty from
	 * 
	 * @return
	 */
	@ModelAttribute("loginInfo")
	public LoginInfo loginForm() {
		return new LoginInfo();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String login(HttpSession session) {
		BookUser bookuser = (BookUser) session.getAttribute("bookuser");
		Publisher publisher =(Publisher) session.getAttribute("publisher");
		if (bookuser != null) {
			return "bookuser-home";
		}
		else if (publisher != null) {
			return "publisher-home";
		}
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginInfo") LoginInfo loginInfo, Model model) {

		BookUser bookuser = bookuserDao.findByEmail(loginInfo.getEmail());
		Publisher publisher = publisherDao.findByEmail(loginInfo.getEmail());
		model.addAttribute("message", "Login Fail");

		if (bookuser != null && bookuser.getPassword().equals(loginInfo.getPassword())) {
			model.addAttribute("bookuser", bookuser);
			model.addAttribute("message", "Welcome back");
			return "bookuser-home";
		}
		else if (publisher != null && publisher.getPassword().equals(loginInfo.getPassword())) {
			model.addAttribute("publisher", publisher);
			model.addAttribute("message", "Welcome back");
			return "publisher-home";
		}

		return "login";
	}

	/**
	 * log out method
	 * 
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		Publisher publisher =(Publisher) session.getAttribute("publisher");
		BookUser student = (BookUser) session.getAttribute("bookuser");
		if (student != null) {
			session.removeAttribute("bookuser");
			return "logout";
			// go to log out page
		}
		else if (publisher != null) {
			session.removeAttribute("publisher");
			return "logout";
			// go to log out page
		}
		return "login";
	}

}
