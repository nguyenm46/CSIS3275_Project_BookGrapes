package com.user.nguyenm46.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.nguyenm46.model.HelloWorld;
import com.user.nguyenm46.model.Message;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String handlerHome(Model model) {
		return "home";
	}
}