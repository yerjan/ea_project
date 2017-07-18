package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Customer;
import edu.mum.rest.service.CustomerRestService;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class CustomerServiceImpl implements edu.mum.service.CustomerService {
	
	@Autowired
	private CustomerRestService customerRestService;

 	@Autowired
	private UserCredentialsService credentialsService;

// 	
//     public void save( Customer user) {  		
//  		userRestService.save(user);
// 	}
//  	
//    @Override
//    public void saveFull( Customer user) {  		
//   		//credentialsService.save(user.getUserCredentials());
//   		userRestService.save(user);
// 	}
   	
	
	public List<Customer> findAll() {
		return (List<Customer>)customerRestService.findAll();
	}

 	@Override
	public Customer findOne(Long id) {
		 
		return customerRestService.findOne(id);
	}
 

}
