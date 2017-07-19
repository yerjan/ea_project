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
import edu.mum.domain.Savings;
import edu.mum.service.CustomerService;
import edu.mum.service.SavingsService;

@Controller
@RequestMapping({"/customers"})
public class CustomerController {
	
	@Autowired
	private CustomerService  customerService;

	@Autowired
	private SavingsService savingsService;
	
	@RequestMapping({"", "/all"})
	public String listUsers(Model model) {
		
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customers";
	}
	
  	@RequestMapping("/{id}")
	public String getUserById(@PathVariable("id") Long id,Model model) {
		Customer customer = customerService.findOne(id);
		List<Savings> savings = savingsService.findByCustomerId(customer.getId());
		
		model.addAttribute("customer", customer);
		model.addAttribute("savings", savings);
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
