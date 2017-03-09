package com.example.configuration;

import com.example.advice.HeaderFilterAdvice;
import com.example.controller.FooController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Web Configuration
 *
 * @author rafa aleman
 */
@Configuration
@EnableWebMvc
public class WebConfig {

	@Bean
	public FooController fooController() {
		return new FooController();
	}

	@Bean
	public HeaderFilterAdvice headerFilterAdvice() {
		return new HeaderFilterAdvice();
	}
}
