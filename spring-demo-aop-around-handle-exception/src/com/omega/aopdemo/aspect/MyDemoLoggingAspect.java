package com.omega.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.omega.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Around("execution(* com.omega.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		logger.info("\n====> Executing @Around on method: " + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// execute the method
		Object result = null;

		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			logger.warning(e.getMessage());

			// rethrow exception
			throw e;

		}

		// get end timestamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - begin;
		logger.info("\n====> Duration: " + duration / 1000.0 + " seconds");

		return result;
	}

	@After("execution(* com.omega.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		logger.info("\n=====> Executing @After (finally) on method: " + method);

	}

	@AfterThrowing(pointcut = "execution(* com.omega.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable exc) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		logger.info("\n=====> Executing @AfterThrowing on method: " + method);

		// log the exception
		logger.info("\n=====> The exception is: " + exc);
	}

	@Before("com.omega.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		logger.info("\n=====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		logger.info("Method: " + methodSig);

		// display the method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();

		for (Object tempArg : args) {
			logger.info(tempArg.toString());

			if (tempArg instanceof Account) {

				// downcast and print specific stuff
				Account theAccount = (Account) tempArg;

				logger.info("Account name: " + theAccount.getName());
				logger.info("Account level: " + theAccount.getLevel());
			}
		}
	}

}
