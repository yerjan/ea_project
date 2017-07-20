package edu.mum.aspect;

import java.util.Date;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import edu.mum.dao.ActivityDao;
import edu.mum.dao.impl.ActivityDaoImp;
import edu.mum.domain.Activity;
import edu.mum.domain.Customer;
import edu.mum.domain.Savings;
import edu.mum.domain.Staff;
import edu.mum.domain.StaffCredentials;
import edu.mum.domain.Transaction;

@Aspect
@Component
	public class ActivityLogging{
	
	//Pointcut(" edu.mum.controler || edu.mum.service")
	//private void forSave(){}
	//@Before void before(JointPoint theJointPoint)
	
		@Before("args(savings) && execution(* edu.mum.service.SavingsService.save(..))")
		public void save(Savings savings){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent("Savng Account Created");
			act.setDatetime(new Date());
			//act.setUser(null);s
			dao.addActivity(act);
		}
		@Before("args(user) && execution(* edu.mum.service.SavingsService.update(..))")
		public void update(Savings user){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent("Savng Account Updated");
			act.setDatetime(new Date());
			//act.setUser(null);
			dao.addActivity(act);
			
		}
		@Before("args(tran) && execution(* edu.mum.service.SavingsService.incrementBalance(..))")
		public void incrementBalance(Transaction tran){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent("Savng Account Incremented");
			act.setDatetime(new Date());
			//act.setUser(null);s
			dao.addActivity(act);
		}
		@Before("args(tran) && execution(* edu.mum.service.SavingsService.decrementBalance(..))")
		public void decrementBalance(Transaction tran){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent("Savng Account Decremented");
			act.setDatetime(new Date());
			//act.setUser(null);s
			dao.addActivity(act);
		}
		@Before("args(id) && execution(* edu.mum.service.SavingsService.openSavings(..))")
		public void openSavings(Long id){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent("Savng Account Opened");
			act.setDatetime(new Date());
			//act.setUser(null);s
			dao.addActivity(act);
		}
		@Before("args(id) && execution(* edu.mum.service.SavingsService.closeSavings(..))")
		public void closeSavings(Long id){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent("Savng Account Closed.");
			act.setDatetime(new Date());
			//act.setUser(null);
			dao.addActivity(act);
		}
		@Before("args(cus) && execution(* edu.mum.service.CustomerService.save(..))")
		public void logCustomer(Customer cus){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent(cus.getFirstName()+" " +cus.getLastName()+" Saved.");
			act.setDatetime(new Date());
			//act.setUser();
			dao.addActivity(act);
		}
		@Before("args(cus) && execution(* edu.mum.service.CustomerService.update(..))")
		public void logCustomerUpdate(Customer cus){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent(cus.getFirstName()+" " +cus.getLastName()+" updated.");
			act.setDatetime(new Date());
			//act.setUser(null);
			dao.addActivity(act);
		}
		@Before("args(staf) && execution(* edu.mum.service.StaffService.save(..))")
		public void logStaffSave(Staff staf){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent(staf.getFirstName()+" " +staf.getLastName()+" Saved.");
			act.setDatetime(new Date());
			act.setUser(staf.getUserCredentials().getUser());
			dao.addActivity(act);
		}
		@Before("args(staf) && execution(* edu.mum.service.StaffService.update(..))")
		public void logStaffUpdate(Staff staf){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent(staf.getFirstName()+" " +staf.getLastName()+" updated.");
			act.setDatetime(new Date());
			act.setUser(staf.getUserCredentials().getUser());	
			dao.addActivity(act);
		}
		@Before("args(staf) && execution(* edu.mum.service.StaffCredentialsService.save(..))")
		public void logStaffCreSave(StaffCredentials staf){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent(staf.getUserName()+ " Saved.");
			act.setDatetime(new Date());
			act.setUser(staf.getUser());
			dao.addActivity(act);
		}
		@Before("args(staf) && execution(* edu.mum.service.StaffCredentialsService.update(..))")
		public void logStaffCreUpdate(StaffCredentials staf){
			Activity act= new Activity();
			ActivityDao dao = new ActivityDaoImp();
			act.setEvent(staf.getUserName()+" " +" updated.");
			act.setDatetime(new Date());
			act.setUser(staf.getUser());	
			dao.addActivity(act);
		}
		


		}
		
			
	
	
	
	