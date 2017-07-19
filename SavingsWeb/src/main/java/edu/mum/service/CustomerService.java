package edu.mum.service;

import java.util.List;

import edu.mum.domain.Customer;
 
public interface CustomerService {

	//public void save(Customer customer);
	public List<Customer> findAll();
	public List<Customer> findCustemers(int startIndex, int size);
	public Customer findOne(Long id);
 	//public void saveFull( Customer customer);		

}
