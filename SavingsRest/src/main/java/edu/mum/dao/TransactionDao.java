package edu.mum.dao;

import edu.mum.domain.Transaction;

public interface TransactionDao extends GenericDao<Transaction> {

	public Transaction findByAccount(Long accountId);
}
