package com.omega.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omega.aopdemo.dao.AccountDAO;
import com.omega.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get the bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountDAO getter/setter method
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();

		// close the context
		context.close();

	}

}
