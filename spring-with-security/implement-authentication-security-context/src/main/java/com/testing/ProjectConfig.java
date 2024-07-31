package com.testing;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class ProjectConfig {
	
//	@Bean
//	public InitializingBean initializingBean() {
//		return () -> SecurityContextHolder.setStrategyName(
//				SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
//	}
	
	@Bean
	public InitializingBean initializingBean() {
	return () -> SecurityContextHolder.setStrategyName(
	SecurityContextHolder.MODE_GLOBAL);
	}
}
