package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.SavingsDao;
import edu.mum.domain.Savings;

@SuppressWarnings("unchecked")
@Repository
public class SavingsDaoImpl extends GenericDaoImpl<Savings> implements SavingsDao {

	public SavingsDaoImpl() {
		super.setDaoType(Savings.class);
	}

	@Override
	public Savings findByCurrency(String currency) {

		Query query = entityManager.createQuery("select u from Savings u  where u.currency =:currency");

		return (Savings) query.setParameter("currency", currency).getSingleResult();
	}

	@Override
	public List<Savings> findByCustomer(Long customerId) {

		Query query = entityManager.createQuery("select u from Savings u  where u.customerId =:customerId");

		return (List<Savings>) query.setParameter("customerId", customerId).getResultList();

	}

}