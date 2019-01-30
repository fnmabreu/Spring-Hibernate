package com.omega.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// execution(modified-patterns? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
	
	// param-pattern
		// () - matches a method with no arguments
		// (*) - matches a method with one argument of any type
		// (..) - matches a method with 0 or more arguments of any type
	
	// @Before("execution(* add*())") // use wildcards
	
	// @Before("execution(* add*(com.omega.aopdemo.Account, ..))") 
	
	@Before("execution(* com.omega.aopdemo.dao.*.*(..))") 
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}
}
