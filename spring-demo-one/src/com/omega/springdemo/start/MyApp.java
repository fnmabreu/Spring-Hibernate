package com.omega.springdemo.start;

import com.omega.springdemo.interfaces.Coach;
import com.omega.springdemo.interfaces.impl.TrackCoach;

public class MyApp {

	public static void main(String[] args) {
		
		// create the object 
		Coach theCoach = new TrackCoach();
		
		// use the object
		System.out.println(theCoach.getDailyWorkOut());
	}

}
