package com.omega.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Match methods in a DAO package and exclude getter/setter methods
 * 
 */
@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.omega.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create a pointcut for getter methods
	@Pointcut("execution(* com.omega.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// create a pointcut for setter methods
	@Pointcut("execution(* com.omega.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytcs() {
		System.out.println("\n=====>>> Performing API analytics");
	}
}
