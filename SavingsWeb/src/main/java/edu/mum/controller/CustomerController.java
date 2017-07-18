package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Customer;
import edu.mum.service.CustomerService;

@Controller
@RequestMapping({"/customers"})
public class CustomerController {
	
	@Autowired
	private CustomerService  customerService;

	@RequestMapping({"", "/all"})
	public String listUsers(Model model) {
		//model.addAttribute("customer", customerService.findAll());
		return "customers";
	}
	
  	@RequestMapping("/{id}")
	public String getUserById(@PathVariable("id") Long id,Model model) {
		//Customer user = customerService.findOne(id);
		//model.addAttribute("user", user);

 		return "customer";
	}	
 
}
