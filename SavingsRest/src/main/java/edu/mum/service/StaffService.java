package edu.mum.service;

import java.util.List;

import edu.mum.domain.Staff;
 
public interface StaffService {
	//Aop
	public void save(Staff user);
	public List<Staff> findAll();
	public Staff findOne(Long id);
	public Staff findByEmail(String email);
	//Aop
	public Staff update(Staff user);
	//Aop
	public void saveFull( Staff user);		

}
