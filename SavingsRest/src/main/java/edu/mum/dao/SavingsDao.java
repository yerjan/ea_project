package edu.mum.dao;

import edu.mum.domain.Savings;

public interface SavingsDao extends GenericDao<Savings> {
      
	public Savings findByCurrency(String currency);
}
