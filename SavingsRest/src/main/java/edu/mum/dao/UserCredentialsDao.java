package edu.mum.dao;

import edu.mum.domain.StaffCredentials;

public interface UserCredentialsDao extends GenericDao<StaffCredentials> {
  
	public StaffCredentials findByUserName(String userName);
}
