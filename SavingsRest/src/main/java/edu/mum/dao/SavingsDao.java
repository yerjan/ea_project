package edu.mum.dao;


import java.util.List;

import edu.mum.domain.Savings;

public interface SavingsDao extends GenericDao<Savings> {

	public Savings findByCurrency(String currency);

	public List<Savings> findByCustomer(Long customerId);
}
