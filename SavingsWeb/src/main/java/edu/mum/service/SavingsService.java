package edu.mum.service;

import java.math.BigDecimal;
import java.util.List;

import edu.mum.domain.Balance;
import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;

public interface SavingsService {

	public List<Savings> findByCustomerId(Long id);

	public Savings findOne(Long id);

	public List<Transaction> tranListByAccountId(Long id);

	public Balance getActiveBalance(Long id);

	public Savings processIncome(Transaction tran);

	public Savings processWithdraw(Transaction tran);

	public Savings processOpen(Long accountId);

	public Savings processClose(Long accountId);
}
