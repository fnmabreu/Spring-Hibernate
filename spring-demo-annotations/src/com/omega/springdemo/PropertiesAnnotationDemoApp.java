package com.omega.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omega.springdemo.interfaces.impl.SwimCoach;

public class PropertiesAnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("propApplicationContext.xml");

		// get the bean from spring container - default beanId
		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

		// call a method on the bean
		System.out.println(swimCoach.getDailyWorkOut());

		// call method to get the daily fortune
		// System.out.println("Email: " + swimCoach.getEmail() + "\nTeam: " + swimCoach.getTeam());
		
		// close the context
		context.close();
	}

}
