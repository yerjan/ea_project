package edu.mum.dao;

import edu.mum.domain.Staff;

public interface UserDao extends GenericDao<Staff> {
      
	public Staff findByEmail(String email);
}
