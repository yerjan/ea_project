package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import edu.mum.dao.TransactionDao;
import edu.mum.domain.Transaction;

@SuppressWarnings("unchecked")
@Repository
public class TransactionDaoImpl extends GenericDaoImpl<Transaction> implements TransactionDao {

	public TransactionDaoImpl() {
		super.setDaoType(Transaction.class);
	}

	@Override
	public List<Transaction> listTranByAccount(Long accountId) {

		Query query = entityManager.createQuery("select u from Transaction u  where u.savings.id =:accountId");
		return (List<Transaction>) query.setParameter("accountId", accountId).getResultList();

	}

}