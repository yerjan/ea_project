package edu.mum.dao;

import edu.mum.domain.StaffCredentials;

public interface StaffCredentialsDao extends GenericDao<StaffCredentials> {
  
	public StaffCredentials findByUserName(String userName);
}
