package edu.mum.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import edu.mum.domain.Transaction;

@Aspect
@Component
public class ActivityLogging {
	// @Autowired
	// private ActivityService activityService;

	// @Pointcut("execution(*
	// edu.mum.service.SavingsService.createSavings(..))")
	// public void createSavings(){}
	//
	// @Pointcut("execution(*
	// edu.mum.service.SavingsService.incrementBalance(..))")
	// public void incrementBalance(){}

	// @Pointcut("within(edu.mum.serviceimpl..*)")
	// public void decrementBalance(){}

	// @Pointcut("execution(* edu.mum.serviceimpl.*(tran))")
	// public void decrement(){}

	// @Before("decrement(Transaction)")
	// @Before("execution(* edu.mum..*(..))")
	// @Before("execution(* edu.mum.serviceimpl..*(..)) && args(Object)")
	@Before("execution(* edu.mum.serviceimpl.SavingsServiceImpl..*(..)) && args(tran)")
	// @Before("execution(public * *(..))")
	public void something(JoinPoint joinPoint, Object tran) {
		if (joinPoint.getSignature().toString().contains("incrementBalance")) {
			System.out.println("FOUND IT:::::::::::::::: LOL");
			Transaction transaction = (Transaction) tran;
			
			System.out.println(transaction.getDescription());
		}
		System.out.println(">>>>>>>>>>>>>WHY IS IT NOT WORKING. COME OON!!!" + joinPoint.getSignature());
	}
	//
	// @Before("incrementBalance()")
	// public void save(Transaction transaction){
	// System.out.println(">>>>>>>>>>>>>>>>>>>>> ASPECT!
	// >>>>>>>>>>>>>>>>>>>>>>>");
	//// Activity activity = new Activity();
	//// activity.setUser((long) 1);
	//// activity.setEvent("Withdraw balance");
	// //activity.setData("Type: " + transaction.getType() + ", Amount: " +
	// transaction.getAmount());
	//
	// //System.out.println("Type: " + transaction.getType() + ", Amount: " +
	// transaction.getAmount());
	//
	// //activityService.save(activity);
	// }

	// @Before()
	// public void update(Savings user){
	// Activity act= new Activity();
	// ActivityDao dao = new ActivityDaoImp();
	// act.setEvent("Savng Account Updated");
	// act.setDatetime(new Date());
	// //act.setUser(null);
	// dao.addActivity(act);
	// }
	//
	// @Before("execution(* edu.mum.service.SavingsService.openSavings(..))")
	// public void incrementBalance(Transaction tran){
	// Activity act= new Activity();
	// ActivityDao dao = new ActivityDaoImp();
	// act.setEvent("Savng Account Incremented");
	// act.setDatetime(new Date());
	// //act.setUser(null);s
	// dao.addActivity(act);
	// }
}
