package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.User;
import edu.mum.rest.service.UserRestService;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class UserServiceImpl implements edu.mum.service.UserService {
	
	@Autowired
	private UserRestService userRestService;

 	@Autowired
	private UserCredentialsService credentialsService;

 	
     public void save( User user) {  		
  		userRestService.save(user);
 	}
  	
     @Override
    	public void saveFull( User user) {  		
   		credentialsService.save(user.getUserCredentials());
   		userRestService.save(user);
 	}
   	
	
	public List<User> findAll() {
		return (List<User>)userRestService.findAll();
	}

 	@Override
	public User findOne(Long id) {
		 
		return userRestService.findOne(id);
	}
 

}
