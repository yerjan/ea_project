package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.StaffCredentials;
import edu.mum.rest.service.UserCredentialsRestService;

@Service
@Transactional 
public class UserCredentialsServiceImpl implements edu.mum.service.UserCredentialsService {
	
 	@Autowired
	private UserCredentialsRestService userCredentialsRestService;

	 
     public void save( StaffCredentials userCredentials) {  		
  		userCredentialsRestService.save(userCredentials);
 	}
  	
 	public StaffCredentials findOne(String userName) {
 		return userCredentialsRestService.findOne(userName);
	}
	
	public List<StaffCredentials> findAll() {
		return (List<StaffCredentials>)userCredentialsRestService.findAll();
	}

 
}
