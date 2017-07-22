package edu.mum.service;

import java.util.List;

import edu.mum.domain.Customer;
 
public interface CustomerService {

	public List<Customer> findAll();

	public Customer findOne(Long id);

}
