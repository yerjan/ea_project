package edu.mum.dao.impl;

import java.util.Date;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.BalanceDao;
import edu.mum.domain.Balance;

@SuppressWarnings("unchecked")
@Repository
public class BalanceDaoImpl extends GenericDaoImpl<Balance> implements BalanceDao {

	public BalanceDaoImpl() {
		super.setDaoType(Balance.class);
	}

	@Override
	public Balance findByAccount(Long accountId) {

		Query query = entityManager
				.createQuery("select u from Balance u  where u.accountId =:accountId and u.valueDate = :valueDate");
		return (Balance) query.setParameter("accountId", accountId).setParameter("valueDate", accountId)
				.getSingleResult();

	}

	@Override
	public Balance findByAccountWithDate(Long accountId, Date valueDate) {

		Query query = entityManager
				.createQuery("select u from Balance u  where u.accountId =:accountId and u.valueDate = :valueDate");
		return (Balance) query.setParameter("accountId", accountId).setParameter("valueDate", valueDate)
				.getSingleResult();

	}

}