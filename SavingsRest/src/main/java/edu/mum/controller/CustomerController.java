package edu.mum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Customer;
import edu.mum.service.CustomerService;

@RestController
@RequestMapping({ "/customers" })
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping
	public List<Customer> listUsers(Model model) {
		return customerService.findAll();
	}

	@RequestMapping("/{id}")
	public Customer getUserById(@PathVariable("id") Long id) {
		return customerService.findOne(id);
	}

}
