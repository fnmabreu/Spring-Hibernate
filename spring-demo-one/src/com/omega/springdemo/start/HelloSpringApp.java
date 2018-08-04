package com.omega.springdemo.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omega.springdemo.interfaces.Coach;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve a bean from spring container
		Coach theCoach = context.getBean("myFootballCoach", Coach.class);

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkOut());

		// let's call out new method for fortunes
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
	}

}
