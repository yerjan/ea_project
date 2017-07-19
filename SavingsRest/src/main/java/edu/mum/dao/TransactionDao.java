package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Transaction;

public interface TransactionDao extends GenericDao<Transaction> {

	public List<Transaction> listTranByAccount(Long accountId);
}
