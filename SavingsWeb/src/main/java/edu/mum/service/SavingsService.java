package edu.mum.service;

import java.math.BigDecimal;
import java.util.List;

import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;

public interface SavingsService {

	public List<Savings> findByCustomerId(Long id);
}
