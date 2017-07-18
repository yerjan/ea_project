package edu.mum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.GenericDao;
import edu.mum.dao.StaffCredentialsDao;
import edu.mum.domain.StaffCredentials;
import edu.mum.domain.StaffCredentials;

@Service
@Transactional 
public class StaffCredentialsServiceImpl implements edu.mum.service.StaffCredentialsService {
	
 	@Autowired
	private StaffCredentialsDao userCredentialsDao;

 	
     public void save( StaffCredentials userCredentials) {  		
  		userCredentialsDao.save(userCredentials);
 	}
  	
  	
	public List<StaffCredentials> findAll() {
		return (List<StaffCredentials>)userCredentialsDao.findAll();
	}

	public StaffCredentials findByUserName(String userName) {
		System.out.println("findOne: 4");
		return userCredentialsDao.findByUserName(userName);
		
	}


	@Override
	public StaffCredentials update(StaffCredentials userCredentials) {
		return userCredentialsDao.update(userCredentials);
	
	}

}
