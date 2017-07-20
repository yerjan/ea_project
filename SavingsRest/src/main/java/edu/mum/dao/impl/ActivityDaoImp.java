package edu.mum.dao.impl;
import javax.persistence.Query;

import edu.mum.domain.Balance;

import edu.mum.dao.ActivityDao;
import edu.mum.domain.Activity;

public class ActivityDaoImp extends GenericDaoImpl<Activity> implements ActivityDao {

	@Override
	public void addActivity(Activity aspect) {
		/*// TODO Auto-generated method stub
		Query query = entityManager
				.createQuery(" insert into Aspect {id, user, event,parameters} a  where a.savings.id == :accountId and a.valueDate <= :valueDate");
	 query.setParameter("accountId", accountId).setParameter("valueDate", valueDate);
	 query.executeUpdate();*/
	 
	 entityManager.persist(aspect);
	}

	
}
