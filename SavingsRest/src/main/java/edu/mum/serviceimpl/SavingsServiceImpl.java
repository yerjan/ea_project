package edu.mum.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.SavingsDao;
import edu.mum.domain.Savings;
import edu.mum.service.SavingsService;

@Service
@Transactional
public class SavingsServiceImpl implements SavingsService {

	@Autowired
	private SavingsDao savingsDao;

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
	public Savings incrementBalance(Long id, BigDecimal pAmount, String pDesc) {

		Savings s = savingsDao.findOne(id);
		
		
		
		return s;
	}

	@Override
	public Savings decrementBalance(Long id, BigDecimal pAmount, String pDesc) {
		return savingsDao.findOne(id);
	}

}
