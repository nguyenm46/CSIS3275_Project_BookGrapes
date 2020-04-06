package com.user.nguyenm46.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.nguyenm46.dao.BookUserDao;
import com.user.nguyenm46.model.BookUser;

//Hsueh-Cheng Liu 300280496 
@Controller
public class SignUpBookuserController {

	@Autowired
	BookUserDao bookuserDao;

	/**
	 * Create new signUpForm bookuser object for empty from
	 * 
	 * @return
	 */
	@ModelAttribute("bookuser")
	public BookUser setSignUpForm() {
		return new BookUser();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/showSignUpForm")
	public String showForm() {
		return "bookuser-signup";
	}

	/**
	 * Save User sign up form
	 * 
	 * @param signUpForm
	 * @param model
	 * @return
	 */
	@PostMapping("/saveSignUpForm")
	public String saveUser(@ModelAttribute("bookuser") BookUser bookuser, Model model) {
		boolean result = bookuserDao.addBookUser(bookuser);
		if (result)
			model.addAttribute("message", "<script>alert('You have successfully signed up!')</script>");
		else
			model.addAttribute("message", "<script>alert('You have successfully signed up!!')</script>");

		return "bookuser-signup-success";
	}

}
