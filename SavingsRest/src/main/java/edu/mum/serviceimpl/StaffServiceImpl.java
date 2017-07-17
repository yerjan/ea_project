package edu.mum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.StaffDao;
import edu.mum.domain.Staff;
import edu.mum.service.StaffCredentialsService;

@Service
@Transactional 
public class StaffServiceImpl implements edu.mum.service.StaffService {
	
 	@Autowired
	private StaffDao userDao;

 	@Autowired
	private StaffCredentialsService credentialsService;

 	
     public void save( Staff user) {  		
  		userDao.save(user);
 	}
  	
     @Override
    	public void saveFull( Staff user) {  		
   		credentialsService.save(user.getUserCredentials());
   		userDao.save(user);
 	}
   	
	
	public List<Staff> findAll() {
		return (List<Staff>)userDao.findAll();
	}

	public Staff findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	public Staff update(Staff user) {
		 return userDao.update(user);

	}

	@Override
	public Staff findOne(Long id) {
		 
		return userDao.findOne(id);
	}
 

}
