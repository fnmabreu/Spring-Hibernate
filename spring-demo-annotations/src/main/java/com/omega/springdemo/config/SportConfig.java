package com.omega.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.omega.springdemo.interfaces.Coach;
import com.omega.springdemo.interfaces.FortuneService;
import com.omega.springdemo.interfaces.impl.SadFortuneService;
import com.omega.springdemo.interfaces.impl.SwimCoach;

@Configuration
@PropertySource("classpath:sport.properties")
// @ComponentScan("com.omega.springdemo")
public class SportConfig {

	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim Coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
