package edu.mum.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import edu.mum.dao.BalanceDao;
import edu.mum.domain.Balance;
import edu.mum.domain.Transaction;

@SuppressWarnings("unchecked")
@Repository
public class BalanceDaoImpl extends GenericDaoImpl<Balance> implements BalanceDao {

	// @Autowired
	// private SysConfigDao sysConfigDao;

	public BalanceDaoImpl() {
		super.setDaoType(Balance.class);
	}

	@Override
	public Balance findActiveBalance(Long accountId) {
		// SysConfig sysConfig = sysConfigDao.getSysConfig();

		Query query = entityManager
				.createQuery("select u from Balance u  where u.savings.id = :accountId and u.status = 0");
		return (Balance) query.setParameter("accountId", accountId).getSingleResult();
		// Balance retBal = null;
		// if (listBal != null && listBal.size() > 0) {
		// retBal = listBal.get(0);
		// }
		// return (retBal);

	}

	@Override
	public Balance findByAccountWithDate(Long accountId, Date valueDate) {

		Query query = entityManager
				.createQuery("select u from Balance u  where u.savings.id == :accountId and u.valueDate <= :valueDate");
		return (Balance) query.setParameter("accountId", accountId).setParameter("valueDate", valueDate)
				.getSingleResult();

	}

	@Override
	public Balance updateBalanceStatus(Long accountId) {
		// SysConfig sysConfig = sysConfigDao.getSysConfig();

		Query query = entityManager.createQuery("update Balance u set u.status = 1 where u.savings.id == :accountId");
		return (Balance) query.setParameter("accountId", accountId).getSingleResult();

	}

}