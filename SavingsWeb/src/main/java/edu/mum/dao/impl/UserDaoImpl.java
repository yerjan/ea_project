package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.Customer;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<Customer> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(Customer.class );
		}

	public Customer findByEmail(String email) {
	     
		Query query = entityManager.createQuery("select u from User u  where u.email =:email");
		return (Customer) query.setParameter("email", email).getSingleResult();
			     

	}


 }