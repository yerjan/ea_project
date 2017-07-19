package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.domain.Balance;
import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;

@Component
public interface SavingRestService {

	public Savings findOne(Long index);

	public List<Savings> findByCustomerId(Long customerId);

	public List<Transaction> tranListByAccountId(Long accountId);

	public Balance getActiveBalance(Long index);

	public Savings processIncome(Transaction tran);

	public Savings processWithdraw(Transaction tran);

	public Savings processOpen(Long accountId);

	public Savings processClose(Long accountId);
}
