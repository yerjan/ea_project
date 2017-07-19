package edu.mum.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.domain.Balance;
import edu.mum.domain.Savings;

@Aspect
@Component

public class AccountChangeAspect {

			@Autowired
			ApplicationContext applicationContext;
			
			@Pointcut("execution(* edu.mum.service.savingsService*(..))")
			public void depositOrWithdraw() {
			}

			@Pointcut("execution(* edu.mum.service..*(..))")
			public void transferFund() {
			}

			@After("depositOrWithdraw() && args(savings, amount)")
			public void logDepositOrWithdrawTransaction(JoinPoint joinPoint, Savings saving, Double amount) {
				try {
					notifyTransaction(joinPoint, saving);
					
				} catch (Throwable e) {
					System.out.println("Exception Thrown");
					e.printStackTrace();
				}
			}

			@After("transferFund() && args(source, destination, amount)")
			public void logTransferFundTransaction(JoinPoint joinPoint, Savings source, Savings destination, Double amount) {
				try {
					notifyTransaction(joinPoint, source);
					
				} catch (Throwable e) {
					System.out.println("Exception Thrown");
					e.printStackTrace();
				}
			}

			
			private void notifyTransaction(JoinPoint joinPoint, Savings saving) {
				try {
					Logger log = Logger.getLogger("");
				    log.info("   **********     Sending Message....!    **********");
					
					Balance balanceChange = (Balance) applicationContext.getBean("balanceChange");
					//Balance.process(saving);
					
				} catch (Throwable e) {
					System.out.println("Exception Thrown");
					e.printStackTrace();
				}
			}

		
		
	}

