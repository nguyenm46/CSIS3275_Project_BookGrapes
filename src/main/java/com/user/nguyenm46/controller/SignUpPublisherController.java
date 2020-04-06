package com.user.nguyenm46.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.nguyenm46.dao.PublisherDao;
import com.user.nguyenm46.model.Publisher;
//Hsueh-Cheng Liu 300280496 

@Controller
public class SignUpPublisherController {
	@Autowired
	PublisherDao publisherDao;

	/**
	 * Create new signUpPublisherForm object for empty from
	 * 
	 * @return
	 */
	@ModelAttribute("publisher")
	public Publisher setSignUpPublisherForm() {
		return new Publisher();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/showSignUpFormPub")
	public String showFormPub() {
		return "publisher-signup";
	}

	/**
	 * Save User sign up publisher form
	 * 
	 * @param signUpForm
	 * @param model
	 * @return
	 */
	@PostMapping("/saveSignUpFormPub")
	public String saveUser(@ModelAttribute("publisher") Publisher publisher, Model model) {

		boolean result = publisherDao.addPublisher(publisher);
		if (result)
			model.addAttribute("message", "<script>alert('You have successfully signed up!')</script>");
		else
			model.addAttribute("message", "<script>alert('You have successfully signed up!')</script>");

		return "publisher-signup-success";
	}

}
