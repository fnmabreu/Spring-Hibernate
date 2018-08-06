package com.omega.springdemo.interfaces.impl;

import org.springframework.stereotype.Component;

import com.omega.springdemo.interfaces.FortuneService;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return null;
	}

}
