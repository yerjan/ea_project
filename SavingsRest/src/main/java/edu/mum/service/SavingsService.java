package edu.mum.service;

import java.util.List;

import edu.mum.domain.Balance;
import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;

public interface SavingsService {

	public void save(Savings savings);

	public List<Savings> findAll();

	public List<Savings> findByCustomer(Long customerId);

	public Savings findOne(Long id);

	public Savings update(Savings user);

	public Transaction incrementBalance(Transaction tran);

	public Transaction decrementBalance(Transaction tran);

	public Savings openSavings(Long id);

	public Savings closeSavings(Long id);

	public List<Transaction> listTransaction(Long id);

	public Balance getActiveBalance(Long id);
}
