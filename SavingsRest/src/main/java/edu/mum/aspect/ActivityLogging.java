package edu.mum.aspect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Activity;
import edu.mum.domain.Transaction;
import edu.mum.service.ActivityService;

@Aspect
@Component
public class ActivityLogging {
	 @Autowired
	 private ActivityService activityService;
	 
	@Before("execution(* edu.mum.serviceimpl.SavingsServiceImpl.incrementBalance(..)) && args(tran)")
	public void logIncome(JoinPoint joinPoint, Object tran) {
		Transaction transaction = (Transaction) tran;
			
		System.out.println(transaction.getDescription());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		Activity activity = new Activity();
		activity.setEvent("Account income");
		activity.setUser(transaction.getSavings().getCustomerId());
		
		activity.setData("Account ID: \"" + transaction.getSavings().getId()
					   + "\", Amount: \"" + transaction.getAmount()
					   + "\", Description: \"" + transaction.getDescription()
					   + "\", Date: \"" + dateFormat.format(date));
		
		activityService.save(activity);
		
	}
	
	@Before("execution(* edu.mum.serviceimpl.SavingsServiceImpl.decrementBalance(..)) && args(tran)")
	public void logWithdraw(JoinPoint joinPoint, Object tran) {
		Transaction transaction = (Transaction) tran;
			
		System.out.println(transaction.getDescription());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		Activity activity = new Activity();
		activity.setEvent("Account Withdraw");
		activity.setUser(transaction.getSavings().getCustomerId());
		
		activity.setData("Account ID: \"" + transaction.getSavings().getId()
				   + "\", Amount: \"" + transaction.getAmount()
				   + "\", Description: \"" + transaction.getDescription()
				   + "\", Date: \"" + dateFormat.format(date));
	
		activityService.save(activity);
	}

}
