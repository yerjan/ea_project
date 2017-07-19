package edu.mum.serviceimpl;

import java.math.BigDecimal;
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

	public List<Savings> findByCustomer(Long customerId) {
		return (List<Savings>) savingsDao.findByCustomer(customerId);
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

		Balance b = balanceDao.findActiveBalance(tran.getSavings().getId());

		if (b == null) {
			// balanceDao.updateBalanceStatus(s.getId());

			Balance b1 = new Balance();
			b1.setInterest(new BigDecimal(0));
			b1.setPrincipal(tran.getAmount());
			b1.setSavings(s);
			b1.setStatus(0);
			b1.setValueDate(sysConfig.getSysDate());
			balanceDao.save(b);

		} else {
			if (sysConfig.getSysDate().compareTo(b.getValueDate()) != 0) {
				b.setStatus(1);

				Balance b1 = new Balance();
				b1.setInterest(new BigDecimal(0));
				b1.setPrincipal(tran.getAmount());
				b1.setSavings(s);
				b1.setStatus(0);
				b1.setValueDate(sysConfig.getSysDate());
				balanceDao.save(b);

			} else {
				b.setPrincipal(b.getPrincipal().add(tran.getAmount()));
				b.setValueDate(sysConfig.getSysDate());
				balanceDao.update(b);
			}
		}

		tran.setCurrency(s.getCurrency());
		tran.setType("INCOME");

		tranDao.save(tran);

		return s;
	}

	@Override
	public Savings decrementBalance(Transaction tran) {
		Savings s = savingsDao.findOne(tran.getSavings().getId());

		SysConfig sysConfig = sysConfigDao.getSysConfig();
		tran.setTranDate(sysConfig.getSysDate());
		Balance b = balanceDao.findActiveBalance(tran.getSavings().getId());

		if (b == null) {
			// balanceDao.updateBalanceStatus(s.getId());

			Balance b1 = new Balance();
			b1.setInterest(new BigDecimal(0));
			b1.setPrincipal(tran.getAmount());
			b1.setSavings(s);
			b1.setStatus(0);
			b1.setValueDate(sysConfig.getSysDate());
			balanceDao.save(b);

		} else {
			if (sysConfig.getSysDate().compareTo(b.getValueDate()) != 0) {
				b.setStatus(1);

				Balance b1 = new Balance();
				b1.setInterest(new BigDecimal(0));
				b1.setPrincipal(tran.getAmount());
				b1.setSavings(s);
				b1.setStatus(0);
				b1.setValueDate(sysConfig.getSysDate());
				balanceDao.save(b);

			} else {
				b.setPrincipal(b.getPrincipal().subtract(tran.getAmount()));
				b.setValueDate(sysConfig.getSysDate());
				balanceDao.update(b);
			}
		}

		tran.setCurrency(s.getCurrency());
		tran.setType("WITHDRAW");

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

	@Override
	public List<Transaction> listTransaction(Long id) {

		List<Transaction> s = tranDao.listTranByAccount(id);
		return s;
	}

	@Override
	public Balance getActiveBalance(Long id) {

		Balance s = balanceDao.findActiveBalance(id);
		return s;
	}

}
