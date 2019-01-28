package com.omega.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with @Before advice
	
	// execution(modified-patterns? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
	
	//@Before("execution(public void add*())")
	
	@Before("execution(* add*())") // use wildcards
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}
}
