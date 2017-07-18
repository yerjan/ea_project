package edu.mum.dao;

import edu.mum.domain.Customer;

public interface UserDao extends GenericDao<Customer> {
      
	public Customer findByEmail(String email);
}
