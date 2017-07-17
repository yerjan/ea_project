package edu.mum.dao.impl;

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

	public Savings findByCurrency(String currency) {

		Query query = entityManager.createQuery("select u from Savings u  where u.currency =:currency");
		return (Savings) query.setParameter("currency", currency).getSingleResult();

	}

}