package com.user.wongi5.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.user.wongi5.dao.BookUserDao;
import com.user.wongi5.dao.StudentDao;
import com.user.wongi5.model.BookUser;
import com.user.wongi5.model.LoginInfo;
import com.user.wongi5.model.Student;

@Controller
@SessionAttributes("bookuser")
public class LoginController {

	//(required = false)
	@Autowired 
	BookUserDao bookuserDao;
//	@Autowired
//	StudentDao studentDao;

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
		if (bookuser != null) {
			return "login-success";
		}
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginInfo") LoginInfo loginInfo, Model model) {

		BookUser bookuser = bookuserDao.findByEmail(loginInfo.getEmail());
		model.addAttribute("message", "Login Fail");

		if (bookuser != null && bookuser.getPassword().equals(loginInfo.getPassword())) {
			model.addAttribute("bookuser", bookuser);
			model.addAttribute("message", "Login Successful");
			return "login-success";
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
		BookUser student = (BookUser) session.getAttribute("bookuser");
		if (student != null) {
			session.removeAttribute("bookuser");
			return "logout";
			// go to log out page
		}
		return "login";
	}

}
