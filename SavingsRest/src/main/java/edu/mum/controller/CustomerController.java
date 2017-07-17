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
@RequestMapping({ "/Customers" })
public class CustomerController {

	@Autowired
	private CustomerService userService;

	@RequestMapping
	public List<Customer> listUsers(Model model) {
		return userService.findAll();
	}

	@RequestMapping("/{id}")
	public Customer getUserById(@PathVariable("id") Long id) {
		return userService.findOne(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Customer processAddNewUserForm(@RequestBody Customer userToBeAdded) {
		userService.save(userToBeAdded);

		return null;

	}

}
