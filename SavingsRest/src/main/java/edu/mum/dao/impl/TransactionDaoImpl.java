package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.SavingsDao;
import edu.mum.dao.TransactionDao;
import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;

@SuppressWarnings("unchecked")
@Repository
public class TransactionDaoImpl extends GenericDaoImpl<Transaction> implements TransactionDao {

	public TransactionDaoImpl() {
		super.setDaoType(Transaction.class);
	}

	public Transaction listSavingsByAccount(Long accountId) {

		Query query = entityManager.createQuery("select u from Transaction u  where u.savings.accountId =:accountId");
		return (Transaction) query.setParameter("accountId", accountId).getSingleResult();

	}

}