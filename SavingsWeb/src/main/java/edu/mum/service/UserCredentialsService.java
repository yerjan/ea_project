package edu.mum.service;

import java.util.List;

import edu.mum.domain.StaffCredentials;
 
public interface UserCredentialsService {

	public void save(StaffCredentials userCredentials);
 	public List<StaffCredentials> findAll();
	public StaffCredentials findOne(String userName);
 }
