package com.omega.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omega.springdemo.interfaces.Coach;

public class PracticeAnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach theCoach = context.getBean("pingPongCoach", Coach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());

		// call a method on the bean
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();

	}

}
