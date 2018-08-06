package com.omega.springdemo.interfaces.impl;

import org.springframework.stereotype.Component;

import com.omega.springdemo.interfaces.Coach;

@Component
public class TennisCoach implements Coach {

	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	@Override
	public String getDailyWorkOut() {
		return "Practice your backhand volley";
	}

}
