package edu.mum.service;

import java.util.List;


import edu.mum.domain.Balance;
import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;

public interface SavingsService {

	public List<Savings> findAll();

	public List<Savings> findByCustomer(Long customerId);

	public Savings findOne(Long id);

	//AOP
	public Transaction incrementBalance(Transaction transaction);
	
	//AOP
	public Transaction decrementBalance(Transaction transaction);

	//AOP
	public Savings createSavings(Savings newSavig);

	public List<Transaction> listTransaction(Long id);

	public Balance getActiveBalance(Long id);
	
	public void endOfDayCalculation();
}
