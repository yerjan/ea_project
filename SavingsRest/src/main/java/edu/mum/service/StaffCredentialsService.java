package edu.mum.service;

import java.util.List;

import edu.mum.domain.StaffCredentials;

public interface StaffCredentialsService {

	public void save(StaffCredentials userCredentials);

	public StaffCredentials update(StaffCredentials userCredentials);

	public List<StaffCredentials> findAll();

	public StaffCredentials findByUserName(String userName);
}
