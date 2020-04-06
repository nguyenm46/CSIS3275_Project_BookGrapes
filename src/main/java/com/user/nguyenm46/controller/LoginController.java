package com.user.nguyenm46.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.user.nguyenm46.dao.BookUserDao;
import com.user.nguyenm46.dao.PublisherDao;
import com.user.nguyenm46.model.BookUser;
import com.user.nguyenm46.model.LoginInfo;
import com.user.nguyenm46.model.Publisher;
//Hsueh-Cheng Liu 300280496 

@Controller
@SessionAttributes("user")
public class LoginController {

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
	public String login(HttpSession session, Model model) {
		System.out.println("GetMappign start");

		if (session.getAttribute("user") != null) {
			System.out.println("session != null");
			System.out.println(session.getAttribute("user").getClass().getName());
			if (session.getAttribute("user").getClass().getName() == "com.user.nguyenm46.model.BookUser") {
				BookUser bookuser = (BookUser) session.getAttribute("user");
				model.addAttribute("message", "Welcome back " + bookuser.getUsername());
				System.out.println("GetMappign not log out, just back to home (bookuser)");
				return "bookuser-home";
			} else if (session.getAttribute("user").getClass().getName() == "com.user.nguyenm46.model.Publisher") {
				Publisher publisher = (Publisher) session.getAttribute("user");
				model.addAttribute("message", "Welcome back " + publisher.getName());
				System.out.println("GetMappign not log out, just back to home (publisher)");
				return "publisher-home";
			}
		}
		System.out.println("GetMappign end");
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginInfo") LoginInfo loginInfo, Model model) {
		System.out.println("PostMappign start");
		BookUser bookuser = bookuserDao.findByEmail(loginInfo.getEmail());
		Publisher publisher = publisherDao.findByEmail(loginInfo.getEmail());
		if (publisher != null) {
			System.out.println(publisher.getEmail());
			System.out.println(publisher.getPassword());
		}
		System.out.println(loginInfo.getEmail());
		System.out.println(loginInfo.getPassword());
		model.addAttribute("message", "Login Fail");
		System.out.println("PostMappign end");
		if (bookuser != null && bookuser.getPassword().equals(loginInfo.getPassword())) {
			model.addAttribute("user", bookuser);
			model.addAttribute("msg", "Welcome back " + bookuser.getUsername());
			return "bookuser-home";
		} else if (publisher != null && publisher.getPassword().equals(loginInfo.getPassword())) {
			model.addAttribute("user", publisher);
			model.addAttribute("msg", "Welcome back " + publisher.getName());
			return "publisher-home";
		}

		return "login";
	}

	/**
	 * log out user method
	 * 
	 * @return
	 */
	@GetMapping("/logoutUser")
	public String logoutUser(HttpSession session, SessionStatus sessionStatus) {

		if (session.getAttribute("user") != null) {
			session.removeAttribute("user");
			session.invalidate();
			sessionStatus.setComplete();
			return "logout";
			// go to log out page
		}

		return "home";
	}

	/**
	 * log out publisher method
	 * 
	 * @return
	 */
	@GetMapping("/logoutPublisher")
	public String logoutPublisher(HttpSession session, SessionStatus sessionStatus) {

		if (session.getAttribute("user") != null) {
			session.removeAttribute("user");
			session.invalidate();
			sessionStatus.setComplete();
			return "logout";
			// go to log out page
		}
		return "home";
	}

}
