package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.StaffCredentials;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.UserCredentialsRestService;

@Component
public class UserCredentialsRestServiceImpl implements UserCredentialsRestService {

	@Autowired
	RemoteApi remoteApi;

	public List<StaffCredentials> findAll() {

		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/SavingsRest/userCredentials/", HttpMethod.GET,
				remoteApi.getHttpEntity(), StaffCredentials[].class).getBody());
	}

	public StaffCredentials findOne(String index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		StaffCredentials userCredentials = null;
		try {
			userCredentials = (restTemplate.exchange("http://localhost:8080/SavingsRest/userCredentials/" + index,
					HttpMethod.GET, remoteApi.getHttpEntity(), StaffCredentials.class).getBody());
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return userCredentials;
	}

	public StaffCredentials save(StaffCredentials product) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<StaffCredentials> httpEntity = new HttpEntity<StaffCredentials>(product, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/SavingsRest/userCredentials/add/", httpEntity,
				StaffCredentials.class);
		return null;
	}

}
