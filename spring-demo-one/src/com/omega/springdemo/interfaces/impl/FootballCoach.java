package com.omega.springdemo.interfaces.impl;

import com.omega.springdemo.interfaces.Coach;
import com.omega.springdemo.interfaces.FortuneService;

public class FootballCoach implements Coach {

	private FortuneService fortuneService;
	
	public FootballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Make a game friendly";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
