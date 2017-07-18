package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserCredentialsDao;
import edu.mum.domain.StaffCredentials;

 


@SuppressWarnings("unchecked")
@Repository
public class UserCredentialsDaoImpl extends GenericDaoImpl<StaffCredentials> implements UserCredentialsDao {

	public UserCredentialsDaoImpl() {
		super.setDaoType(StaffCredentials.class );
		}

	public StaffCredentials findByUserName(String userName) {

		Query query = entityManager.createQuery("select m from Authentication m  where m.userName =:userName");
		return (StaffCredentials) query.setParameter("userName", userName).getSingleResult();

	}

 
 }