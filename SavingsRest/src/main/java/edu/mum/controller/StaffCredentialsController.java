package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.StaffCredentials;
import edu.mum.service.StaffCredentialsService;

@RestController
@RequestMapping({ "/staffCredentials" })
public class StaffCredentialsController {

	@Autowired
	StaffCredentialsService credentialsService;

	@RequestMapping("/add")
	public void addOne(@RequestBody StaffCredentials staffCredentials) {
		credentialsService.save(staffCredentials);
	}

	@RequestMapping("/{id}")
	public StaffCredentials findOne(@PathVariable("id") String userName) {
		StaffCredentials validCredentials = credentialsService.findByUserName(userName);
		return validCredentials;
	}

}
