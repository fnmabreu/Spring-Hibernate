package com.omega.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omega.springdemo.config.SportConfig;
import com.omega.springdemo.interfaces.impl.SwimCoach;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container - default beanId
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());

		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call our new swim coach methods.. has the props values injected
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("email: " + theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
