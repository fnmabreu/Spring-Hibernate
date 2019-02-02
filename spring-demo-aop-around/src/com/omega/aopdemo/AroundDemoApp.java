package com.omega.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omega.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	private static Logger logger = Logger.getLogger(AroundDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("\nMain Program: AroundDemoApp");

		logger.info("Calling getFortune");

		String data = theFortuneService.getFortune();

		logger.info("\nMy fortune is: " + data);

		logger.info("Finished");

		// close the context
		context.close();

	}

}
