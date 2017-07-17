package edu.mum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.CustomerDao;
import edu.mum.domain.Customer;
import edu.mum.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao userDao;

	@Override
	public void save(Customer user) {
		userDao.save(user);
	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) userDao.findAll();
	}

	@Override
	public Customer update(Customer user) {
		return userDao.update(user);

	}

	@Override
	public Customer findOne(Long id) {

		return userDao.findOne(id);
	}

}
