package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public List<Savings> findByCustomerId(Long id) {
		return savingRestService.findByCustomerId(id);
	}

	public Savings findOne(Long id) {
		return savingRestService.findOne(id);
	}

	public List<Transaction> tranListByAccountId(Long id) {
		return savingRestService.tranListByAccountId(id);
	}

	public Balance getActiveBalance(Long id) {
		return savingRestService.getActiveBalance(id);
	}

}
