package edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class HomeController {

 
	@RequestMapping({"/","/login"})
	public String welcome(Model model) {
		
		return "login";
	}
 
}
