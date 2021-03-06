package edu.mum.serviceimpl;

import java.math.BigDecimal;
import java.util.Calendar;
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

	public List<Savings> findAll() {
		return (List<Savings>) savingsDao.findAll();
	}

	public List<Savings> findByCustomer(Long customerId) {
		return (List<Savings>) savingsDao.findByCustomer(customerId);
	}

	@Override
	public Savings findOne(Long id) {
		return savingsDao.findOne(id);
	}

	@Override
	public Transaction incrementBalance(Transaction tran) {

		Savings s = null;
		try {
			s = savingsDao.findOne(tran.getSavings().getId());

			SysConfig sysConfig = sysConfigDao.getSysConfig();
			tran.setTranDate(sysConfig.getSysDate());

			Balance b = balanceDao.findActiveBalance(tran.getSavings().getId());

			if (b == null) {
				Balance b1 = new Balance();
				b1.setInterest(new BigDecimal(0));
				b1.setPrincipal(tran.getAmount());
				b1.setSavings(s);
				b1.setStatus(0);
				b1.setValueDate(sysConfig.getSysDate());
				balanceDao.save(b1);

			} else {
				if (sysConfig.getSysDate().compareTo(b.getValueDate()) != 0) {
					b.setStatus(1);
					Balance b1 = new Balance();
					b1.setInterest(new BigDecimal(0));
					b1.setPrincipal(tran.getAmount().add(b.getPrincipal()));
					b1.setSavings(s);
					b1.setStatus(0);
					b1.setValueDate(sysConfig.getSysDate());
					balanceDao.save(b1);

				} else {
					b.setPrincipal(b.getPrincipal().add(tran.getAmount()));
					b.setValueDate(sysConfig.getSysDate());
					balanceDao.update(b);
				}
			}

			tran.setCurrency(s.getCurrency());
			tran.setType("INCOME");
			tranDao.save(tran);
		} catch (Exception up) {
			System.out.println("incrementBalance transaction Failed!!!");
			System.out.println(": " + up.getMessage());
			up.printStackTrace(System.out);
		}
		return tran;
	}

	@Override
	public Transaction decrementBalance(Transaction tran) {
		Savings s = savingsDao.findOne(tran.getSavings().getId());

		SysConfig sysConfig = sysConfigDao.getSysConfig();
		tran.setTranDate(sysConfig.getSysDate());
		Balance b = balanceDao.findActiveBalance(tran.getSavings().getId());

		if (b == null) {

			Balance b1 = new Balance();
			b1.setInterest(new BigDecimal(0));
			b1.setPrincipal(tran.getAmount());
			b1.setSavings(s);
			b1.setStatus(0);
			b1.setValueDate(sysConfig.getSysDate());
			balanceDao.save(b1);

		} else {
			if (sysConfig.getSysDate().compareTo(b.getValueDate()) != 0) {
				b.setStatus(1);

				Balance b1 = new Balance();
				b1.setInterest(new BigDecimal(0));
				b1.setPrincipal(tran.getAmount());
				b1.setSavings(s);
				b1.setStatus(0);
				b1.setValueDate(sysConfig.getSysDate());
				balanceDao.save(b1);

			} else {
				b.setPrincipal(b.getPrincipal().subtract(tran.getAmount()));
				b.setValueDate(sysConfig.getSysDate());
				balanceDao.update(b);
			}
		}

		tran.setCurrency(s.getCurrency());
		tran.setType("WITHDRAW");

		tranDao.save(tran);

		return tran;
	}

	@Override
	public Savings createSavings(Savings savings) {
		savingsDao.save(savings);
		SysConfig sysConfig = sysConfigDao.getSysConfig();
		Balance b1 = new Balance();
		b1.setInterest(new BigDecimal(0));
		b1.setPrincipal(new BigDecimal(0));
		b1.setSavings(savings);
		b1.setStatus(0);
		b1.setValueDate(sysConfig.getSysDate());
		balanceDao.save(b1);
		return savings;
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

	@Override
	public void endOfDayCalculation() {
		// First we increment day
		SysConfig sysConfig = sysConfigDao.getSysConfig();
		Calendar cal = Calendar.getInstance();
		cal.setTime(sysConfig.getSysDate());
		cal.add(Calendar.DATE, 1);
		sysConfig.setSysDate(cal.getTime());
		sysConfigDao.update(sysConfig);

		// assuming interest is calculated
		BigDecimal interest = new BigDecimal(10);

		List<Savings> list = savingsDao.findAll();
		for (Savings savings : list) {
			Transaction transaction = new Transaction();
			transaction.setAmount(interest);
			transaction.setCurrency(savings.getCurrency());
			transaction.setDescription("BATCH - INTEREST");
			transaction.setType("INCOME");
			transaction.setSavings(savings);

			incrementBalance(transaction);
		}

	}

}
