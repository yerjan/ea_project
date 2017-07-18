package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.StaffCredentialsDao;
import edu.mum.domain.StaffCredentials;

 


@SuppressWarnings("unchecked")
@Repository
public class StaffCredentialsDaoImpl extends GenericDaoImpl<StaffCredentials> implements StaffCredentialsDao {

	public StaffCredentialsDaoImpl() {
		super.setDaoType(StaffCredentials.class );
		}

	public StaffCredentials findByUserName(String userName) {

		Query query = entityManager.createQuery("select m from AUTHENTICATION m  where m.userName =:userName");
		return (StaffCredentials) query.setParameter("userName", userName).getSingleResult();

	}

 
 }