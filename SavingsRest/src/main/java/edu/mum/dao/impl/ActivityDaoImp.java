package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.domain.Balance;

import edu.mum.dao.ActivityDao;
import edu.mum.domain.Activity;

@SuppressWarnings("unchecked")
@Repository
public class ActivityDaoImp extends GenericDaoImpl<Activity> implements ActivityDao {

}
