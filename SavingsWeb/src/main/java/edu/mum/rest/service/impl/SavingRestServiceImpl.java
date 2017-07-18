package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Customer;
import edu.mum.domain.Savings;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.CustomerRestService;
import edu.mum.rest.service.SavingRestService;

@Component
public class SavingRestServiceImpl implements SavingRestService {

	@Autowired
	RemoteApi remoteApi;

	public Savings findOne(Long index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/SavingsRest/savings/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), Savings.class).getBody());
	}

	public List<Savings> findByCustomerId(Long customerId){
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/SavingsRest/savings?customerId=" + customerId, HttpMethod.GET, remoteApi.getHttpEntity(), Savings[].class).getBody());
	}
//	public Customer save(Customer member) {
//		RestTemplate restTemplate = remoteApi.getRestTemplate();
//		HttpEntity<Customer> httpEntity = new HttpEntity<Customer>(member, remoteApi.getHttpHeaders());
//		restTemplate.postForObject("http://localhost:8080/Lab_12_RestService/users/add/", httpEntity, Customer.class);
//		return null;
//	}

}
