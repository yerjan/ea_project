package edu.mum.service;

import java.math.BigDecimal;
import java.util.List;

import edu.mum.domain.Savings;

public interface SavingsService {

	public void save(Savings savings);

	public List<Savings> findAll();

	public Savings findOne(Long id);

	public Savings update(Savings user);

	public Savings incrementBalance(Long id, BigDecimal pAmount, String pDesc);

	public Savings decrementBalance(Long id, BigDecimal pAmount, String pDesc);

}
