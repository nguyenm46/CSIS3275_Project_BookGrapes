package com.user.nguyenm46.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.nguyenm46.model.Message;
//Hsueh-Cheng Liu 300280496 

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String handlerHome(Model model) {
		return "home";
	}
}
