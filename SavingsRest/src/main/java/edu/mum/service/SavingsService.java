package edu.mum.service;

import java.util.List;


import edu.mum.domain.Balance;
import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;

public interface SavingsService {
	//Aop
	public void save(Savings savings);

	public List<Savings> findAll();

	public List<Savings> findByCustomer(Long customerId);

	public Savings findOne(Long id);
	
	//Aop
	public Savings update(Savings user);
	//Aop
	public Savings incrementBalance(Transaction tran);
	//Aop
	public Savings decrementBalance(Transaction tran);
	//Aop
	public Savings openSavings(Long id);
   //Aop
	public Savings closeSavings(Long id);

	public List<Transaction> listTransaction(Long id);

	public Balance getActiveBalance(Long id);
}
