package com.omega.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* com.omega.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create a pointcut for getter methods
	@Pointcut("execution(* com.omega.aopdemo.dao.*.get*(..))")
	public void getter() {
	}

	// create a pointcut for setter methods
	@Pointcut("execution(* com.omega.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}
}
