package edu.mum.service;

import java.math.BigDecimal;
import java.util.List;

import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;

public interface SavingsService {

	public void save(Savings savings);

	public List<Savings> findAll();

	public Savings findOne(Long id);

	public Savings update(Savings user);

	public Savings incrementBalance(Transaction tran);

	public Savings decrementBalance(Transaction tran);

	public Savings openSavings(Long id);

	public Savings closeSavings(Long id);
}
