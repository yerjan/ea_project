package edu.mum.service;

import java.util.List;

import edu.mum.domain.Staff;
 
public interface StaffService {

	public void save(Staff user);
	public List<Staff> findAll();
	public Staff findOne(Long id);
	public Staff findByEmail(String email);
	public Staff update(Staff user);
	public void saveFull( Staff user);		

}
