package com.omega.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omega.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		logger.info("\nMain Program: AroundHandleExceptionDemoApp");

		logger.info("Calling getFortune");

		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);

		logger.info("\nMy fortune is: " + data);

		logger.info("Finished");

		// close the context
		context.close();

	}

}
