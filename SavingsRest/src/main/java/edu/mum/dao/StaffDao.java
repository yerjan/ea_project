package edu.mum.dao;

import edu.mum.domain.Staff;

public interface StaffDao extends GenericDao<Staff> {
      
	public Staff findByEmail(String email);
}
