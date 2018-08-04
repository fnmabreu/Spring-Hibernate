package com.omega.springdemo.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omega.springdemo.interfaces.impl.CricketCoach;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve a bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkOut());
		
		// let's call out new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// call our new methods to get the literal values
		System.out.println(theCoach.getEmailAddress());
		
		System.out.println(theCoach.getTeam());

		// close the context
		context.close();
	}

}
