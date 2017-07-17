package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.Staff;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<Staff> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(Staff.class );
		}

	public Staff findByEmail(String email) {
	     
		Query query = entityManager.createQuery("select u from User u  where u.email =:email");
		return (Staff) query.setParameter("email", email).getSingleResult();
			     

	}


 }