package edu.mum.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Transaction;
import edu.mum.service.ActivityService;

@Aspect
@Component
public class ActivityLogging{
	@Autowired
	private ActivityService activityService;
	
//	@Pointcut("execution(* edu.mum.service.SavingsService.createSavings(..))")
//	public void createSavings(){}
//	
//	@Pointcut("execution(* edu.mum.service.SavingsService.incrementBalance(..))")
//	public void incrementBalance(){}
	
//	@Pointcut("within(edu.mum.serviceimpl..*)")
//	public void decrementBalance(){}
	
	@Pointcut("execution(* edu.mum.serviceimpl.SavingsServiceImpl.decrementBalance(..))")
	public void decrement(){}
	
	@Before("decrement()")
	public void something(){
		System.out.println(">>>>>>>>>>>>>IMPL BOLJ BAINA!        !!!!!!!!!!!!!!!!!!!!");
	}
//
//	@Before("incrementBalance()")
//	public void save(Transaction transaction){
//		System.out.println(">>>>>>>>>>>>>>>>>>>>> ASPECT! >>>>>>>>>>>>>>>>>>>>>>>");
////		Activity activity = new Activity();
////		activity.setUser((long) 1);
////		activity.setEvent("Withdraw balance");
//		//activity.setData("Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
//		
//		//System.out.println("Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
//	
//		//activityService.save(activity);
//	}
		
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
		
			
	
	
	
	