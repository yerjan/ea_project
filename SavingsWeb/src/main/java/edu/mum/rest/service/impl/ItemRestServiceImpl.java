package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Item;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.ItemRestService;

@Component
public class ItemRestServiceImpl  implements ItemRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<Item> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/Lab_12_RestService/items/", HttpMethod.GET, remoteApi.getHttpEntity(), Item[].class).getBody());
 	}

	public Item findOne(Long index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/Lab_12_RestService/items/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), Item.class).getBody());
	}

	public Item save(Item product) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Item> httpEntity = new HttpEntity<Item>(product, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/Lab_12_RestService/items/add/", httpEntity, Item.class);
 		return null;
	}

}
