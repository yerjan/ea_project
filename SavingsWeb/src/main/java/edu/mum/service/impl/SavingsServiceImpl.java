package edu.mum.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Balance;
import edu.mum.domain.Customer;
import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;
import edu.mum.rest.service.SavingRestService;
import edu.mum.service.SavingsService;

@Service
@Transactional
public class SavingsServiceImpl implements SavingsService {

	@Autowired
	private SavingRestService savingRestService;

	public List<Savings> findByCustomerId(Long id){
		return savingRestService.findByCustomerId(id);
	}

	

}
