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

//	@Autowired
//	UserDao userDao;
	@Autowired
	BookUserDao bookuserDao;
	

	
	/**
	 * Create new signUpForm object for empty from
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
	
	@GetMapping("/home1")
	public String backHome() {
		return "home";
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

		// Implement business logic to save user details into a database
		// .....

		System.out.println("Name : " + bookuser.getName());
		System.out.println("FullName : " + bookuser.getFullname());
		System.out.println("DOB : " + bookuser.getDob());
		System.out.println("Password : " + bookuser.getPassword());
		System.out.println("Email : " + bookuser.getEmail());
		
		List<BookUser> bookusers = bookuserDao.findAll();

		System.out.println(bookusers);

		//model.addAttribute("bookusers", bookusers);
				
//		model.addAttribute("message", "User SignUp successfully.");
//		model.addAttribute("user", user);

		//insert info to sql
		//INSERT INTO bookusers VALUES('test@gmail.com', 'admin', 'test admin','1986-10-26', '123456');
		boolean result = bookuserDao.addBookUser(bookuser);
		  if (result)
		    model.addAttribute("message", "<script>alert('You have successfully signed up!')</script>");
		  else
		    model.addAttribute("message", "<script>alert('You have successfully signed up!!')</script>");
		  
		return "bookuser-signup-success";
	}
	
	

}
