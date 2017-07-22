package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.SysConfigDao;
import edu.mum.domain.SysConfig;

@SuppressWarnings("unchecked")
@Repository
public class SysConfigDaoImpl extends GenericDaoImpl<SysConfig> implements SysConfigDao {

	public SysConfigDaoImpl() {
		super.setDaoType(SysConfig.class);
	}

	public SysConfig getSysConfig() {

		Query query = entityManager.createQuery("select u from SysConfig u ");
		return (SysConfig) query.getSingleResult();

	}
}