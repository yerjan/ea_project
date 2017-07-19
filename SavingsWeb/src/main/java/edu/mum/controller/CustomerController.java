package edu.mum.controller;

import java.util.List;

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
		
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customer", customers);
		//public string ret(ar1,)
		return "customers";
	}
	
  	@RequestMapping("/{id}")
	public String getUserById(@PathVariable("id") Long id,Model model) {
		Customer customer = customerService.findOne(id);
		model.addAttribute("customer", customer);
 		return "customer";
	}
// pagination 
  	
@RequestMapping("/{startIndex}-{size}")
	public String findCustemers(@PathVariable("startIndex") int startIndex,@PathVariable("size") int size, Model model) {

	List<Customer> customers = customerService.findCustemers(startIndex, size);
	
       model.addAttribute("customer", customers);
	
	return "customers";
	}

}
