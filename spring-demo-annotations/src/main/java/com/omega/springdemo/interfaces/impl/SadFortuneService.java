package com.omega.springdemo.interfaces.impl;

import com.omega.springdemo.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is sad day";
	}

}
