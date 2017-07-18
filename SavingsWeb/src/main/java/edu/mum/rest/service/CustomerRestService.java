package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.domain.Customer;

@Component
public interface CustomerRestService {

 	public List<Customer> findAll();

	public Customer findOne(Long index);

	//public Customer save(Customer member);

}
