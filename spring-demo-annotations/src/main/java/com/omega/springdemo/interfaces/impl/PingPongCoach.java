package com.omega.springdemo.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.omega.springdemo.interfaces.Coach;
import com.omega.springdemo.interfaces.FortuneService;

@Component
public class PingPongCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	public PingPongCoach() {
		System.out.println(">> PingPongCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkOut() {
		return "Practice your pingpong drop shot";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
