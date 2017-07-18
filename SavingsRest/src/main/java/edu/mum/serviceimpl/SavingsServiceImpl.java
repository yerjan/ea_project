package edu.mum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.BalanceDao;
import edu.mum.dao.SavingsDao;
import edu.mum.dao.SysConfigDao;
import edu.mum.dao.TransactionDao;
import edu.mum.domain.Balance;
import edu.mum.domain.Savings;
import edu.mum.domain.SysConfig;
import edu.mum.domain.Transaction;
import edu.mum.service.SavingsService;

@Service
@Transactional
public class SavingsServiceImpl implements SavingsService {

	@Autowired
	private SavingsDao savingsDao;

	@Autowired
	private TransactionDao tranDao;

	@Autowired
	private BalanceDao balanceDao;

	@Autowired
	private SysConfigDao sysConfigDao;

	public void save(Savings savings) {
		savingsDao.save(savings);
	}

	public List<Savings> findAll() {
		return (List<Savings>) savingsDao.findAll();
	}

	public Savings update(Savings savings) {
		return savingsDao.update(savings);

	}

	@Override
	public Savings findOne(Long id) {
		return savingsDao.findOne(id);
	}

	@Override
	public Savings incrementBalance(Transaction tran) {

		Savings s = savingsDao.findOne(tran.getSavings().getId());

		SysConfig sysConfig = sysConfigDao.getSysConfig();
		tran.setTranDate(sysConfig.getSysDate());

		Balance b = balanceDao.findByAccount(tran.getSavings().getId());
		b.setPrincipal(b.getPrincipal().add(tran.getAmount()));
		if (b.getValueDate().compareTo(sysConfig.getSysDate()) == 0)
			balanceDao.update(b);
		else
			balanceDao.save(b);

		tran.setCurrency(s.getCurrency());
		tran.setType("INCR");

		tranDao.save(tran);

		return s;
	}

	@Override
	public Savings decrementBalance(Transaction tran) {
		Savings s = savingsDao.findOne(tran.getSavings().getId());

		SysConfig sysConfig = sysConfigDao.getSysConfig();
		tran.setTranDate(sysConfig.getSysDate());

		Balance b = balanceDao.findByAccount(tran.getSavings().getId());
		b.setPrincipal(b.getPrincipal().subtract(tran.getAmount()));

		if (b.getValueDate().compareTo(sysConfig.getSysDate()) == 0)
			balanceDao.update(b);
		else
			balanceDao.save(b);

		tran.setCurrency(s.getCurrency());
		tran.setType("DECR");

		tranDao.save(tran);

		return s;
	}

	@Override
	public Savings openSavings(Long id) {

		Savings s = savingsDao.findOne(id);
		s.setStatus("OPEN");

		return s;
	}

	@Override
	public Savings closeSavings(Long id) {

		Savings s = savingsDao.findOne(id);
		s.setStatus("CLOSED");

		return s;
	}

}
