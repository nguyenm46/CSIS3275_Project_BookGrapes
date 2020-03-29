package com.user.wongi5.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.wongi5.model.HelloWorld;
import com.user.wongi5.model.Message;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String handlerHome(Model model) {
		return "home";
	}
}
