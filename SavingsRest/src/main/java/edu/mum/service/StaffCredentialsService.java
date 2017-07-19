package edu.mum.service;

import java.util.List;

import edu.mum.domain.StaffCredentials;
 
public interface StaffCredentialsService {
	//Aop
	public void save(StaffCredentials userCredentials);
	//Aop
	public StaffCredentials update(StaffCredentials userCredentials);
	public List<StaffCredentials> findAll();
	public StaffCredentials findByUserName(String userName);
 }
