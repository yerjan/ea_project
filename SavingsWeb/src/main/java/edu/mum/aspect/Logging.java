package edu.mum.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public interface Logging {
	// Isolates/restricts WHERE @Logging can be applied
		 @Pointcut("execution(* edu.mum.service..*(..))")
//		 @Pointcut("execution(* edu.mum.service..update(..))")    // - If you want to AOP ONLY updates...IGNORES Save
	 	    public static void applicationMethod() {}

		 // Annotation
		   @Pointcut("@annotation(edu.mum.aspect.annotation.Logging)")
		    public static void logging() {}
		
		      // Remove logging() &&  AND it will do a "regular"[no annotation] execution Point cut.
	//		  @Before("logging() && applicationMethod()")
//			  @Before("execution(* *.*.*..*(..))")                  // "indiscriminate" application Try it!
	  
			  //------------------3 WAYS to bind parameters----------------------------
	//---#1---------
			//  @Pointcut("execution(* edu.mum.service..save(..)) && args(order) ")
			  
 //             public void testOrderCombo(Order order) {}
	//----#2-------
//			  @Pointcut("execution(* edu.mum.service..save(..))")
//			  public void testOrder() {}

//			  @Pointcut(" args(order)  ")
//			  public void orderArgs(Order order) {}
	//--------------------------------------------------------------------		  
		//	  @Before("testOrderCombo(awder)")                        // Explicit version #1
//			  @Before("testOrder() && orderArgs(awder)")              // EXPLICIT Version #2
//			  @Before("execution(* edu.mum.service..save(..)) && args(awder)  ")   // Implicit version #3
//			  public void testExecution(Order awder) {
//				    System.out.println();
	//			    System.out.println("BIND 'awder' to Order in Advice -- in save");
	//			    System.out.println("Order Number: " + awder.getOrderNumber());


				  
}
