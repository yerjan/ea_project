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
	private CustomerDao customerDao;

	@Override
	public void save(Customer user) {
		customerDao.save(user);
	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) customerDao.findAll();
	}

	@Override
	public Customer update(Customer user) {
		return customerDao.update(user);
	}

	@Override
	public Customer findOne(Long id) {

		return customerDao.findOne(id);
	}

}
