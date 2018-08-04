package com.omega.springdemo.interfaces.impl;

import com.omega.springdemo.interfaces.FortuneService;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
