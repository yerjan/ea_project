package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Customer;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.CustomerRestService;

@Component
public class CustomerRestServiceImpl implements CustomerRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<Customer> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/SavingsRest/customers/", HttpMethod.GET, remoteApi.getHttpEntity(), Customer[].class).getBody());
 	}

	public Customer findOne(Long index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/SavingsRest/customers/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), Customer.class).getBody());
	}

}
