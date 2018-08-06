package com.omega.springdemo.interfaces.impl;

import org.springframework.stereotype.Component;

import com.omega.springdemo.interfaces.Coach;

@Component
public class PingPongCoach implements Coach{

	public PingPongCoach() {
		System.out.println(">> PingPongCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkOut() {
		return "Practice your pingpong drop shot";
	}
}
