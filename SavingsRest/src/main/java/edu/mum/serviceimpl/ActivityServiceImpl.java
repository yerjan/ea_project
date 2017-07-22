package edu.mum.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.ActivityDao;
import edu.mum.domain.Activity;
import edu.mum.service.ActivityService;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;

	public void save(Activity activity) {
		activityDao.save(activity);
	}
}
