package com.omega.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omega.springdemo.interfaces.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container - default beanId
		Coach coach = context.getBean("tennisCoach", Coach.class);

		// call a method on the bean
		System.out.println(coach.getDailyWorkOut());

		// close the context
		context.close();
	}

}
