package edu.mum.rest;

import java.nio.charset.Charset;
import java.util.Collections;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class RemoteApi {
	protected RestTemplate restTemplate;

	public RemoteApi() {
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	}
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	/*
	*		Set up authentication header
	*		PLUS JSON Accept header
	*/
	public HttpHeaders getHttpHeaders() {

		String username = "admin1";
		String password = "admin1";
		
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64( 
           auth.getBytes(Charset.forName("US-ASCII")) );
        String authHeader = "Basic " + new String( encodedAuth );
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.set("Authorization", authHeader);
		return requestHeaders;
	}

	public HttpEntity<?> getHttpEntity() {
		System.out.println("getHttpHeaders: " + getHttpHeaders());
		return new HttpEntity(getHttpHeaders());
	}

}

