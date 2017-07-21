package edu.mum.aspect;

import java.util.Date;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.dao.ActivityDao;
import edu.mum.dao.impl.ActivityDaoImp;
import edu.mum.domain.Activity;
import edu.mum.domain.Customer;
import edu.mum.domain.Savings;
import edu.mum.domain.Staff;
import edu.mum.domain.StaffCredentials;
import edu.mum.domain.Transaction;
import edu.mum.service.ActivityService;

@Aspect
@Component
public class ActivityLogging{
	@Autowired
	private ActivityService activityService;
	
	@Pointcut("execution(* edu.mum.service.SavingsService.createSavings)")
	public void createSavings(){}
	
	@Pointcut("execution(* edu.mum.service.SavingsService.incrementBalance(transaction))")
	public void incrementBalance(Transaction transaction){}
	
	@Pointcut("execution(* edu.mum.service.SavingsService.decrementBalance(transaction))")
	public void decrementBalance(Transaction transaction){}
	
	

	@Before("incrementBalance(transaction) && decrementBalance(transaction)")
	public void save(Transaction transaction){
		Activity activity = new Activity();
		activity.setUser((long) 1);
		activity.setEvent("Withdraw balance");
		activity.setData("Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
		
		activityService.save(activity);
	}
		
//		@Before()
//		public void update(Savings user){
//			Activity act= new Activity();
//			ActivityDao dao = new ActivityDaoImp();
//			act.setEvent("Savng Account Updated");
//			act.setDatetime(new Date());
//			//act.setUser(null);
//			dao.addActivity(act);	
//		}
//		
//		@Before("execution(* edu.mum.service.SavingsService.openSavings(..))")
//		public void incrementBalance(Transaction tran){
//			Activity act= new Activity();
//			ActivityDao dao = new ActivityDaoImp();
//			act.setEvent("Savng Account Incremented");
//			act.setDatetime(new Date());
//			//act.setUser(null);s
//			dao.addActivity(act);
//		}
}
		
			
	
	
	
	