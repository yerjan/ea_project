package edu.mum.dao.impl;

import java.util.Date;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.dao.BalanceDao;
import edu.mum.dao.SysConfigDao;
import edu.mum.domain.Balance;
import edu.mum.domain.SysConfig;

@SuppressWarnings("unchecked")
@Repository
public class BalanceDaoImpl extends GenericDaoImpl<Balance> implements BalanceDao {

	@Autowired
	private SysConfigDao sysConfigDao;

	public BalanceDaoImpl() {
		super.setDaoType(Balance.class);
	}

	@Override
	public Balance findByAccount(Long accountId) {
		SysConfig sysConfig = sysConfigDao.getSysConfig();

		Query query = entityManager.createQuery(
				"select u from Balance u  where u.savings.accountId <= accountId and u.valueDate = :valueDate");
		return (Balance) query.setParameter("accountId", accountId).setParameter("valueDate", sysConfig.getSysDate())
				.getSingleResult();

	}

	@Override
	public Balance findByAccountWithDate(Long accountId, Date valueDate) {

		Query query = entityManager.createQuery(
				"select u from Balance u  where u.savings.accountId <= accountId and u.valueDate = :valueDate");
		return (Balance) query.setParameter("accountId", accountId).setParameter("valueDate", valueDate)
				.getSingleResult();

	}

}