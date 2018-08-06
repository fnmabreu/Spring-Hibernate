package com.omega.springdemo.interfaces.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.omega.springdemo.interfaces.Coach;

@Component
public class SwimCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	    
	@Value("${foo.team}")
	private String team;

	public SwimCoach() {

	}
	
	@Override
	public String getDailyWorkOut() {
		return "Swim and sweat";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
}
