package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

 import edu.mum.domain.StaffCredentials;

@Component
public interface UserCredentialsRestService {

 	public List<StaffCredentials> findAll();

	public StaffCredentials findOne(String index);

	public StaffCredentials save(StaffCredentials member);

}
