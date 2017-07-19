package edu.mum.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//@Componet
public class LoggingAspect {
	
	@Pointcut("execution(* edu.mum.service..*(..))")
	public void depositOrWithdraw() {
	}

	@Pointcut("execution(* edu.mum.service..*(..))")
	public void transferFund() {
	}

	@After("depositOrWithdraw()")
	public void logDepositOrWithdrawTransaction(JoinPoint joinPoint) {
		try {
			logTransaction(joinPoint);
			
		} catch (Throwable e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
	}

	@After("transferFund()")
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
	}

}
