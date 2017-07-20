package edu.mum.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;

@Aspect

	public class LoggingAspect{
	
		@Before("args(savings) && execution(* edu.mum.service.SavingsService.save(..))")
		public void save(Savings savings){
			
		}
		@Before("args(user) && execution(* edu.mum.service.SavingsService.update(..))")
		public void update(Savings user){
			
		}
		@Before("args(tran) && execution(* edu.mum.service.SavingsService.incrementBalance(..))")
		public void incrementBalance(Transaction tran){
			
		}
		@Before("args(tran) && execution(* edu.mum.service.SavingsService.decrementBalance(..))")
		public void decrementBalance(Transaction tran){
			
		}
		@Before("args(id) && execution(* edu.mum.service.SavingsService.openSavings(..))")
		public void openSavings(Long id){
			
		}
		@Before("args(id) && execution(* edu.mum.service.SavingsService.closeSavings(..))")
		public void closeSavings(Long id){
			
		}
	
	
	
	
	
	
	/*
	//@Componet
	//@Pointcut("execution(* edu.mum.service..save(..)) && args(order) ")
	
		@Pointcut("execution(* edu.mum.service..*(..))")
		public void depositOrWithdraw() {
		}

		@Pointcut("execution(* edu.mum.service..*(..))")
		public void transferFund() {
		}
		@Pointcut("execution(*edu.mum.service.*savingService.*(..))")

		@After("depositOrWithdraw()")
		public void logDepositOrWithdrawTransaction(JoinPoint joinPoint) {
			try {
				logTransaction(joinPoint);
				
			} catch (Throwable e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
		}

		
		
		//@Around("")
		
		//can apply in different method by usng @Logable
		//@Before("@annotation(edu.mum.aspect.Loggable)")
		
		@After(" /") //transferFund()
		public void logTransferFundTransaction(JoinPoint joinPoint) {
			try {
				logTransaction(joinPoint);
				
			} catch (Throwable e) {
				System.out.println("Exception Thrown");
				e.printStackTrace();
			}
		}

		private void logTransaction(JoinPoint joinPoint) {
			System.out.println("===========LoggingAspect==logResource(JoinPoint joinPoint)===========");
			Logger log = Logger.getLogger("");
			log.info("   **********     TARGET CLASS : " + joinPoint.getSignature().getName() + "    **********");
			System.out.println();
			System.out.println("   **********     TARGET CLASS : " + joinPoint.getSignature().getDeclaringTypeName() + "."
					+ joinPoint.getSignature().getName() + "    **********");
		}*/

	}
