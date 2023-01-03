package com.example.javaeedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MyConfiguration {

	@Bean
	public MyBean myBean() {
		return new MyBean();
	}

	static class MyBean {

	}
}
