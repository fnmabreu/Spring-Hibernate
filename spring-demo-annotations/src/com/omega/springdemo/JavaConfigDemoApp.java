package com.omega.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omega.springdemo.config.SportConfig;
import com.omega.springdemo.interfaces.Coach;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container - default beanId
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());

		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
